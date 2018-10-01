package mysite.jr.filters;

import mysite.jr.authentication.Authentication;
import mysite.jr.configurations.PathConfigurator;
import mysite.jr.configurations.SecurityConfigurator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("SecurityFilter");

        SecurityConfigurator configuration = SecurityConfigurator.getInstance();
        String command = request.getParameter("command");
        String role = configuration.security(command);
        //All
        if (Objects.equals(role, SecurityConfigurator.ALL)) {
            //LOGGER.debug("Filter.Security (SecurityFilter.doFilter()) info : Successful request for ALL.");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //Users
        if (Objects.equals(role, SecurityConfigurator.AUTH)
                && Authentication.isUserLogIn(request.getSession())) {
            //LOGGER.debug("Filter.Security (SecurityFilter.doFilter()) info : Successful request for AUTH.");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (Objects.equals(role, SecurityConfigurator.AUTH)
                && !Authentication.isUserLogIn(request.getSession())) {
            //LOGGER.info("Filter.Security (SecurityFilter.doFilter()) info : Not authorised request for AUTH.");
            request.setAttribute("error", "Authentication failed AUTH");
            request.getRequestDispatcher(PathConfigurator.getPath().ERROR_VIEW).forward(request, response);
            return;
        }
        //Admin
        if (Objects.equals(role, SecurityConfigurator.ADMIN)
                && Authentication.isUserLogIn(request.getSession())
                && Authentication.isAdmin(request.getSession())) {
            //LOGGER.debug("Filter.Security (SecurityFilter.doFilter()) info : Successful request for ADMIN.");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (Objects.equals(role, SecurityConfigurator.ADMIN)
                && !Authentication.isUserLogIn(request.getSession())) {
            //LOGGER.warn("Filter.Security (SecurityFilter.doFilter()) info : Not authorised request for ADMIN.");
            request.setAttribute("error", "Authentication failed ADMIN");
            request.getRequestDispatcher(PathConfigurator.getPath().ERROR_VIEW).forward(request, response);
            return;
        }
        if (Objects.equals(role, SecurityConfigurator.ADMIN)
                && !Authentication.isAdmin(request.getSession())) {
            //LOGGER.warn("Filter.Security (SecurityFilter.doFilter()) info : Illegal request for ADMIN.");
            request.setAttribute("error", "Illegal request");
            request.getRequestDispatcher(PathConfigurator.getPath().ERROR_VIEW).forward(request, response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    @Override
    public void destroy() {

    }
}
