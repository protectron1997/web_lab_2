package filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.security.MessageDigest;



@WebFilter("/controller")
public class ControllerFileFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            Part partFileAc = httpRequest.getPart("fileAc");
            String fileAcName = partFileAc.getSubmittedFileName();


            String pathToKeyFile = httpRequest.getServletContext().getRealPath("/acFiles/" + fileAcName);

            File keyFile = new File(pathToKeyFile);

            if(keyFile.exists()){
                if(sameFiles(partFileAc.getInputStream(),new FileInputStream(keyFile))){
                    chain.doFilter(request, response);
                }
                else{
                    throw new Exception("Files not same");
                }
            }
            else{
                throw new Exception("File doesn't exists " + pathToKeyFile);
            }

        }
        catch (Exception e){
            //httpResponse.getWriter().write(e.getMessage());
            ((HttpServletResponse) response).sendError(400);
        }
    }


    boolean sameFiles(InputStream fromUserKey, InputStream fromServerKey) throws Exception{
        MessageDigest hashSum = MessageDigest.getInstance("SHA-1");
        byte[] buff = new byte[10000];
        int read = 0;

        //получим хэш сумму первого файла и второго соотв
        while((read = fromUserKey.read(buff)) != -1){
            hashSum.update(buff, 0, read);
        }
        byte[] userKeyHash = hashSum.digest();

        hashSum.reset();
        while((read = fromServerKey.read(buff)) != -1){
            hashSum.update(buff, 0, read);
        }
        byte[] serverKeyHash = hashSum.digest();




        return MessageDigest.isEqual(userKeyHash, serverKeyHash);
    }
}
