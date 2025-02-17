package SessionManagement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/servlet-two")
public class ServletTwo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Session & Cookie Data Fetch</h2>");

        // Fetching Cookie
        Cookie[] cookies = req.getCookies();
        boolean cookieFound = false;

        if (cookies != null) {
            for (Cookie overCookies : cookies) {
                if (overCookies.getName().equals("username")) {
                    cookieFound = true;
                    out.println("<p><strong>Welcome back!</strong> Cookie Found: " + overCookies.getName() + " = " + overCookies.getValue() + "</p>");
                }
            }
        }
        if (!cookieFound) {
            out.println("<p style='color:red;'><strong>Cookie not found!</strong></p>");
        }

        // Fetching HTTP Session ID
        HttpSession session = req.getSession();
        String sessionSecret = (String) session.getAttribute("secret");

        if (sessionSecret != null) {
            out.println("<p><strong>Session Secret:</strong> " + sessionSecret + "</p>");
        } else {
            out.println("<p style='color:red;'><strong>Session secret not found!</strong></p>");
        }

        // Servlet Context
        ServletContext servletContext = getServletContext();
        out.println("<p><strong>Servlet Context:</strong> " + servletContext.getContextPath() + "</p>");

        // Servlet Config
        ServletConfig servletConfig = getServletConfig();
        out.println("<p><strong>Servlet Config:</strong> " + servletConfig + "</p>");

        String mail = servletConfig.getInitParameter("mail");
        out.println("<p><strong>Servlet Config Parameter (mail):</strong> " + mail + "</p>");

        out.println("</body></html>");
    }
}
