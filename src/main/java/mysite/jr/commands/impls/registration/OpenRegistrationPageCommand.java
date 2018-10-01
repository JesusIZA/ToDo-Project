package mysite.jr.commands.impls.registration;

import mysite.jr.commands.Command;
import mysite.jr.configurations.PathConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenRegistrationPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OpenRegistrationPageCommand");
        request.getRequestDispatcher(PathConfigurator.getPath().REGISTRATION_VIEW).forward(request, response);
    }
}
