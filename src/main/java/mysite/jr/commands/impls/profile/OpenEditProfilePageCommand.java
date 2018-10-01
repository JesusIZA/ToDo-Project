package mysite.jr.commands.impls.profile;

import mysite.jr.commands.Command;
import mysite.jr.configurations.PathConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenEditProfilePageCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OpenEditProfilePageCommand");
        request.getRequestDispatcher(PathConfigurator.getPath().EDIT_PROFILE_VIEW).forward(request, response);
    }
}
