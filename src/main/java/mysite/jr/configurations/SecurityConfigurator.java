package mysite.jr.configurations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SecurityConfigurator {
    private static final SecurityConfigurator config = new SecurityConfigurator();
    //roles
    public static final String ALL = "all";
    public static final String AUTH = "authorised";
    public static final String ADMIN = "administrator";

    private Map<String,String> grant = new HashMap<>();

    public static SecurityConfigurator getInstance(){
        return config;
    }

    /**
     * Map with list roles and commands they can call
     */
    private SecurityConfigurator() {
        grant.put(CommandConfigurator.OPEN_LOGIN_PAGE, ALL);
        grant.put(CommandConfigurator.LOGIN, ALL);
        grant.put(CommandConfigurator.OPEN_REGISTRATION_PAGE, ALL);
        grant.put(CommandConfigurator.REGISTRATION, ALL);
        grant.put(CommandConfigurator.OPEN_MAIN_PAGE, AUTH);
        grant.put(CommandConfigurator.OPEN_EDIT_PROFILE_PAGE, AUTH);
        grant.put(CommandConfigurator.OPEN_SECOND_PAGE, AUTH);
        grant.put(CommandConfigurator.LOGOUT, AUTH);
    }

    public String security(String command){
        return grant.get(command);
    }

    public Set<String> getEndPoints(){
        return grant.keySet();
    }
}
