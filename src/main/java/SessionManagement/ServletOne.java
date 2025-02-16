package SessionManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-one")
public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // cookie
        String username = "jashan";

        Cookie c = new Cookie(username, "jashan");
        c.setMaxAge(10 * 60);
        resp.addCookie(c);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Servlet One..");

        //http session

    }
}
