package mysite.jr.configurations;

public class PathConfigurator {
    private static PathConfigurator configurator = new PathConfigurator();

    public static PathConfigurator getPath(){
        return configurator;
    }

    private PathConfigurator(){}

    public static final String LOGIN_VIEW = "/login.jsp";
    public static final String REGISTRATION_VIEW = "/registration.jsp";
    public static final String MAIN_VIEW = "/WEB-INF/views/main.jsp";
    public static final String SECOND_VIEW = "/WEB-INF/views/second.jsp";
    public static final String EDIT_PROFILE_VIEW = "/WEB-INF/views/editProfile.jsp";
    public static final String ERROR_VIEW = "/WEB-INF/views/error.jsp";

}
