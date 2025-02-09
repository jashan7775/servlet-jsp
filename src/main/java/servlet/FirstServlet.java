package servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/firstServlet")
// here we directly implement servlet interface
public class FirstServlet implements Servlet {

    private ServletConfig servletConfig;

    // life cycle methods
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("Servlet Initialized..");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service Requested..");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed..");
    }

    // non life cycle methods
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public String getServletInfo() {
        return "This servlet is created by Jashan..";
    }

}
