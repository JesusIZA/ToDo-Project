package mysite.jr.servlets;

import mysite.jr.commands.Command;
import mysite.jr.commands.FactoryCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    /**
     * Execute command user need if it is posible
     * @param req - user request
     * @param resp - response user
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        FactoryCommand factory = FactoryCommand.getInstance();
        Command command = factory.getCommand((String) req.getParameter("command"));
        try {
            command.execute(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
