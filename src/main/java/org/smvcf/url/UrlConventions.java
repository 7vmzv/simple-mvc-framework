package org.smvcf.url;

public class UrlConventions {
    public static String CONTROLLER_NAME_FORMAT = "[a-zA-Z][a-zA-Z0-9_]*";
    public static String METHODE_NAME_FORMAT = "[a-z][a-zA-Z0-9_]*";
    public static String URL_CONVENTION = CONTROLLER_NAME_FORMAT + "/" + METHODE_NAME_FORMAT;

    public static void main(String[] args) {
        System.out.println("controllerName".matches(CONTROLLER_NAME_FORMAT));
    }

}
