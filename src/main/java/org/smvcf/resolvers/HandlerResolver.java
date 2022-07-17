package org.smvcf.resolvers;

public class HandlerResolver {
    private String url;
    private String controller;
    private String methode;

    public String getHandler(){
        if(url == null || url.equals("")) {
            return "ErrorController";
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
}
