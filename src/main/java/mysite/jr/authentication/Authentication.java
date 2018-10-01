package mysite.jr.authentication;

import mysite.jr.entities.User;

import javax.servlet.http.HttpSession;
import java.util.*;

public class Authentication {
    public static final Authentication authentication = new Authentication();

    private Authentication() {
        users = new HashMap<>();
    }

    public static Authentication getInstance(){
        return authentication;
    }

    public static boolean isUserLogIn(HttpSession session){
        String login = (String)session.getAttribute("login");
        String password = (String)session.getAttribute("password");

        if(Objects.nonNull(login) && !Objects.equals(login, "") && Objects.nonNull(password) && !Objects.equals(password, "")) {
            String pass = users.get(login);

            if (Objects.nonNull(pass) && !Objects.equals(pass, "")) {
                return Objects.equals(pass, password);
            }

        }
        return false;
    }

    public static boolean isAdmin(HttpSession session) {
        String login = (String)session.getAttribute("login");
        if(Objects.equals(login, "Admin") || Objects.equals(login, "Admin2"))
            return true;
        return false;
    }

    private static Map<String, String> users;

    public static void addUser(User user) {
        if(!users.containsKey(user.getLogin())) {
            //check in DB
            users.put(user.getLogin(), user.getPassword());
            System.out.println("Add user: " + user.getLogin());
        }
    }

    public static void deleteUser(User user) {
        if(users.containsKey(user.getLogin())) {
            users.remove(user.getLogin());
            System.out.println("Delete user: " + user.getLogin());
        }
    }
}