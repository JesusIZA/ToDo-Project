package mysite.jr.commands;

import mysite.jr.commands.impls.login.LoginCommand;
import mysite.jr.commands.impls.login.OpenLoginPageCommand;
import mysite.jr.commands.impls.logout.LogoutCommand;
import mysite.jr.commands.impls.main.*;
import mysite.jr.commands.impls.profile.OpenEditProfilePageCommand;
import mysite.jr.commands.impls.registration.OpenRegistrationPageCommand;
import mysite.jr.commands.impls.registration.RegistrationCommand;
import mysite.jr.commands.impls.second.OpenSecondPageCommand;
import mysite.jr.configurations.CommandConfigurator;

import java.util.HashMap;
import java.util.Map;

public class FactoryCommand {
    private static final FactoryCommand factoryCommand = new FactoryCommand();

    private Map<String,Command> commandMap = new HashMap<>();

    private FactoryCommand() {
        commandMap.put(CommandConfigurator.OPEN_LOGIN_PAGE, new OpenLoginPageCommand());
        commandMap.put(CommandConfigurator.LOGIN, new LoginCommand());
        commandMap.put(CommandConfigurator.OPEN_REGISTRATION_PAGE, new OpenRegistrationPageCommand());
        commandMap.put(CommandConfigurator.REGISTRATION, new RegistrationCommand());
        commandMap.put(CommandConfigurator.OPEN_MAIN_PAGE, new OpenMainPageCommand());
        commandMap.put(CommandConfigurator.OPEN_EDIT_PROFILE_PAGE, new OpenEditProfilePageCommand());
        commandMap.put(CommandConfigurator.OPEN_SECOND_PAGE, new OpenSecondPageCommand());
        commandMap.put(CommandConfigurator.LOGOUT, new LogoutCommand());
    }

    public static FactoryCommand getInstance(){
        return factoryCommand;
    }

    public Command getCommand(String command){
        return commandMap.get(command);
    }

}