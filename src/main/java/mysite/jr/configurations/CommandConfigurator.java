package mysite.jr.configurations;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public class CommandConfigurator {
    private static CommandConfigurator configurator = new CommandConfigurator();

    public static CommandConfigurator getInstance(){
        return configurator;
    }

    private CommandConfigurator(){}

    public static final String MAIN_PATH = "/do";

    public static final String OPEN_LOGIN_PAGE = "open_login_page";
    public static final String LOGIN = "login";
    public static final String OPEN_REGISTRATION_PAGE = "open_registration_page";
    public static final String REGISTRATION = "registration";
    public static final String OPEN_MAIN_PAGE = "open_main_page";
    public static final String OPEN_EDIT_PROFILE_PAGE = "open_edit_profile_page";
    public static final String OPEN_SECOND_PAGE = "open_second_page";
    public static final String LOGOUT = "logout";

    public String getPageComand(HttpServletRequest request, String command) {
        return request.getContextPath() + MAIN_PATH + "?command=" + command;
    }
    public String getMainPath(HttpServletRequest request) {
        return request.getContextPath() + MAIN_PATH;
    }
}
