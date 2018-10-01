package mysite.jr.listeners;

import mysite.jr.authentication.Authentication;
import mysite.jr.entities.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Objects;

public class SessionListener implements HttpSessionListener {

    //private static Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session start");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroy");
        String login = (String)se.getSession().getAttribute("login");
        String password = (String)se.getSession().getAttribute("password");
        if(Objects.nonNull(login) && !Objects.equals(login, "") &&Objects.nonNull(password) && !Objects.equals(password, "")) {
            Authentication.deleteUser(new User(login));
            se.getSession().removeAttribute("login");
            se.getSession().removeAttribute("password");
        }
    }

}
