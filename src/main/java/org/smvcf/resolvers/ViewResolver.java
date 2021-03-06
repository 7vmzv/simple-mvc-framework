package org.smvcf.resolvers;


public class ViewResolver {
    private String index = "index";
    private String prefix;
    private String suffix;

    public String getViewPage(String viewPage){
        if(viewPage == null || viewPage.equals("")) {
            return this.prefix + index + this.suffix;
        }
        return this.prefix + viewPage + this.suffix;
    }

    public ViewResolver() {
        this.prefix = "/WEB-INF/view/";
        this.suffix = ".jsp";
    }
}
