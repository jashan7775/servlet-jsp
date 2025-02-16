package SessionManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-two")
public class ServletTwo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        out.println("Servlet Two..");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie overCookies : cookies) {
                System.out.println(overCookies.getName());
                if (overCookies.getName().equals("jashan")) {
                    System.out.println("Cookie is present");
                    out.println("Welcome back : Cookie is present..");
                }
            }
        } else {
            out.println("Cookie is not present..");
        }
    }
}
