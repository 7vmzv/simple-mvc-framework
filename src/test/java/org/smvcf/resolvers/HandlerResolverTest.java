package org.smvcf.resolvers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ProperUrl definition : /controllerName/methodeName
 */
public class HandlerResolverTest {
    //Arrange
    HandlerResolver handlerResolver = new HandlerResolver();

    @Test
    public void should_return_ErrorController_when_given_empty_string(){
        //Act
        handlerResolver.setUrl("");
        String actual = handlerResolver.getHandler();

        //Assert
        assertEquals("ErrorController", actual);
    }

    @Test
    public void should_throw_when_given_a_string_contains_non_valid_class_name(){

    }

    @Test
    public void should_return_proper_controller_name_when_given_proper_url(){
        //Act
        handlerResolver.setUrl("controllerName/methodeName");
        String actual = handlerResolver.getHandler();

        //Assert
        assertEquals("ControllerNameController", actual);
    }

}
