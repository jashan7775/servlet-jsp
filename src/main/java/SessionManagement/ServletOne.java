package SessionManagement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Session Management Example</h2>");

        // Cookie
        String username = "jashan";
        Cookie c = new Cookie("username", username);
        c.setMaxAge(10 * 60);
        resp.addCookie(c);
        out.println("<p><strong>Cookie Added:</strong> " + c.getName() + " = " + c.getValue() + "</p>");

        // HTTP Session
        HttpSession session = req.getSession();
        String secret = UUID.randomUUID().toString();
        session.setAttribute("secret", secret);
        session.setMaxInactiveInterval(10 * 60);
        out.println("<p><strong>Generated Secret HTTP Session ID:</strong> " + secret + "</p>");

        // Servlet Context
        ServletContext servletContext = getServletContext();
        out.println("<p><strong>Servlet Context:</strong> " + servletContext.getContextPath() + "</p>");

        // Servlet Config
        ServletConfig servletConfig = getServletConfig();
        String u = servletConfig.getInitParameter("username");
        out.println("<p><strong>Servlet Config Parameter (username):</strong> " + u + "</p>");

        out.println("</body></html>");
    }
}
