package mysite.jr.services;

import mysite.jr.entities.User;

public class RegistrationService {
    private static RegistrationService service = new RegistrationService();

    public static RegistrationService getService(){
        return service;
    }

    private RegistrationService(){}

    public boolean verify(User user){
        boolean ret = true;

        //valid
        //db check

        return  ret;
    }

    public void registration(User user){

    }
}
