package servlets;

import beans.DataDotsBean;
import beans.Dot;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@WebServlet("/model")
public class AreaCheckServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            var start = Instant.now();

            double x = 0;
            double y = 0;
            double r = 0;

            x = Double.parseDouble(request.getParameter("x"));
            y = Double.parseDouble(request.getParameter("y"));
            r = Double.parseDouble(request.getParameter("r"));

            if(!valuesCheck(x,y,r)){
                throw new Exception("wrong values!");
            }


            HttpSession session = request.getSession();
            DataDotsBean dataDots = (DataDotsBean) session.getAttribute("dataDotsBean");

            if (dataDots == null){
                dataDots = new DataDotsBean();
                session.setAttribute("dataDotsBean", dataDots);
            }

            Dot tmpDot = new Dot(x,y,r,areaCheck(x,y,r));

            var end = Instant.now();
            long time = ChronoUnit.NANOS.between(start,end);
            tmpDot.setTime(String.valueOf(time));

            dataDots.addDot(tmpDot);
            session.setAttribute("dataDotsBean", dataDots);

            //сохраняем в атрибут последнюю точку для result.jsp
            session.setAttribute("lastDot", tmpDot);


            response.sendRedirect(request.getContextPath() + "/result.jsp");

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
            response.sendError(400, "Данные пришли не от контроллера! или невалид. дан.");
        }
    }

    boolean areaCheck(double x, double y, double r){
        boolean rectangle = ((x>=(-r)) && (x<=0)) && ((y<=(r/2)) && (y>=0));
        boolean triangle  = (x>=0) && (y<=0) && ((0.5*x-0.5*r)<= y);
        boolean circle = (x>=0) && (y>=0) && ((x*x + y*y)<=r*r);
        return rectangle || triangle || circle;
    }

    boolean valuesCheck(double x,double y, double r){
        boolean rCheck = (r==1) || (r==1.5) || (r==2) || (r==2.5) || (r == 3);
        boolean xCheck = (x>=-5) && (x<=5);
        boolean yCheck = (y>=-5) && (y<=5);
        return rCheck && xCheck && yCheck;
    }

}
