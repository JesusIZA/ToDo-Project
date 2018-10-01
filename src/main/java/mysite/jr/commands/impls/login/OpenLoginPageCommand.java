package mysite.jr.commands.impls.login;

import mysite.jr.commands.Command;
import mysite.jr.configurations.PathConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenLoginPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OpenLoginPageCommand");
        request.getRequestDispatcher(PathConfigurator.getPath().LOGIN_VIEW).forward(request, response);
    }
}
