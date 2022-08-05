package org.smvcf.resolvers;

import org.smvcf.exceptions.InvalidControllerNameException;
import org.smvcf.url.UrlConventions;

public class HandlerResolver {
    private String url;
    private String controller;
    private String methode;

    public String getHandler() throws InvalidControllerNameException{
        if(url == null || url.equals("") || !url.matches(UrlConventions.URL_CONVENTION)) {
            throw new InvalidControllerNameException();
        }

        splitTheUrlAndResolveControllerAndMethod();
        return controller.substring(0, 1).toUpperCase() + controller.substring(1) + "Controller";
    }

    public void setUrl(String url){
        this.url = url;
    }

    private void splitTheUrlAndResolveControllerAndMethod(){
        String[] controllerAndMethode =  url.split("/");
        controller = controllerAndMethode[0];
        methode = controllerAndMethode[1];
    }
    public static void main(String[] args) {
        HandlerResolver foo = new HandlerResolver();
        foo.setUrl("controllerName/methodeName");
        try {
            System.out.println(foo.getHandler());
        } catch (InvalidControllerNameException e) {
            // TODO Auto-generated catch block
            System.out.println("qegsdgsgdsgdsdgsgsgsd");
        }
    }
}
