package mysite.jr.commands.impls.registration;

import mysite.jr.authentication.Authentication;
import mysite.jr.commands.Command;
import mysite.jr.commands.FactoryCommand;
import mysite.jr.configurations.CommandConfigurator;
import mysite.jr.entities.User;
import mysite.jr.services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegistrationCommand");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        //Coding data

        System.out.println(name);
        System.out.println(email);
        System.out.println(login);
        System.out.println(password);

        User user = new User();

        if(Objects.nonNull(login) && !Objects.equals(login, "") && Objects.nonNull(password) && !Objects.equals(password, "") &&
                Objects.nonNull(name) && !Objects.equals(name, "") && Objects.nonNull(email) && !Objects.equals(email, "")){
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setEmail(email);

            if(RegistrationService.getService().verify(user)) {
                RegistrationService.getService().registration(user);
                Authentication authentication = Authentication.getInstance();
                authentication.addUser(user);
                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("password", password);
                FactoryCommand.getInstance().getCommand(CommandConfigurator.OPEN_MAIN_PAGE).execute(request, response);
            }
        } else {
            request.setAttribute("error", "Some error");
            FactoryCommand.getInstance().getCommand(CommandConfigurator.OPEN_REGISTRATION_PAGE).execute(request, response);
        }

    }
}
