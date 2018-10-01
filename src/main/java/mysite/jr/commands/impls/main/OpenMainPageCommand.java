package mysite.jr.commands.impls.main;

import mysite.jr.commands.Command;
import mysite.jr.configurations.PathConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenMainPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OpenMainPageCommand");
        request.getRequestDispatcher(PathConfigurator.getPath().MAIN_VIEW).forward(request, response);
    }
}
