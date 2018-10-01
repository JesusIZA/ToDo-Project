package mysite.jr.services;

import mysite.jr.entities.User;

public class LoginService {
    private static LoginService service = new LoginService();

    public static LoginService getService(){
        return service;
    }

    private LoginService(){}

    public boolean verify(User user){
        boolean ret = true;

        //valid
        //db check

        return  ret;
    }
}
