package mysite.jr.commands.impls.second;

import mysite.jr.commands.Command;
import mysite.jr.configurations.PathConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenSecondPageCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OpenSecondPageCommand");
        request.getRequestDispatcher(PathConfigurator.getPath().SECOND_VIEW).forward(request, response);
    }
}
