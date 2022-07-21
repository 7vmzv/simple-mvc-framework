package org.smvcf.resolvers;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.smvcf.exceptions.InvalidControllerNameException;
import org.smvcf.url.UrlConventions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * ProperUrl definition : /controllerName/methodeName
 */
public class HandlerResolverTest {
    //Arrange
    HandlerResolver handlerResolver = new HandlerResolver();

    @Test
    public void should_throw_when_given_empty_string(){
        
        handlerResolver.setUrl("");
        

        //Act //Assert
        assertThrows(InvalidControllerNameException.class, () -> {
            String actual = handlerResolver.getHandler();
        });
    }

    @Test
    public void should_throw_when_given_a_string_contains_non_valid_class_name(){
        //Act
        handlerResolver.setUrl("9ontroller/methodeName");
        String actual = handlerResolver.getHandler();

        //Assert
        assertThrows(InvalidControllerNameException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                if (!actual.matches(UrlConventions.CONTROLLER_NAME_FORMAT)){
                    throw new InvalidControllerNameException();
                }
            }
        });

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
