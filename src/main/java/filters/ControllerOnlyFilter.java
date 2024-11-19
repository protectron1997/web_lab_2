package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.annotation.WebFilter;

@WebFilter("/model")
public class ControllerOnlyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Boolean isFromController = (Boolean) httpRequest.getAttribute("fromController");

        if (Boolean.TRUE.equals(isFromController)) {
            chain.doFilter(request, response);
        } else {

            ((HttpServletResponse) response).sendError(400);
        }
    }

}
