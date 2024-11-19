package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@MultipartConfig
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            boolean forwardFlag = !((request.getParameter("x") == null) || (request.getParameter("y") == null) || (request.getParameter("r") == null));

            if(forwardFlag){
                request.setAttribute("fromController", true);
                request.getRequestDispatcher("/model").forward(request,response);
            }
            else{
                throw new Exception("Empty Values!");
            }

        }
        catch (Exception e){
            response.sendError(400);
            //response.getWriter().println(e.getMessage());
        }
    }
}
