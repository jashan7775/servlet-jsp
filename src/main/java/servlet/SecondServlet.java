package servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

// we dont use web servlet annotation here, we do manually mapping of second  servlet in web.xml file
// here we dont directly implement the servlet interface, we dont implement servlet via generic servlet
// in generic servlet all the methods are implemented except for and we do implementation for that here
public class SecondServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service Requested..");
    }
}
