package mysite.jr.commands.impls.logout;

import mysite.jr.authentication.Authentication;
import mysite.jr.commands.Command;
import mysite.jr.commands.FactoryCommand;
import mysite.jr.configurations.CommandConfigurator;
import mysite.jr.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LogoutCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LogoutCommand");
        HttpSession session = request.getSession();

        Authentication authentication = Authentication.getInstance();
        if (authentication.isUserLogIn(session)){
            authentication.deleteUser(new User((String)session.getAttribute("login")));
            session.removeAttribute("login");
            session.removeAttribute("password");
        }

        FactoryCommand.getInstance().getCommand(CommandConfigurator.OPEN_LOGIN_PAGE).execute(request, response);
    }
}
