package org.smvcf.resolvers;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.smvcf.exceptions.InvalidControllerNameException;
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
            handlerResolver.getHandler();
        });
    }

    @Test
    public void should_throw_when_given_a_string_contains_non_valid_class_name(){
        //Act
        handlerResolver.setUrl("9ontroller/methodeName");
        

        //Assert
        assertThrows(InvalidControllerNameException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                    handlerResolver.getHandler();
            }
        });

    }

    @Test
    public void should_return_proper_controller_name_when_given_proper_url(){
        //Act
        handlerResolver.setUrl("controllerName/methodeName");
        String actual = "";
        try {
            actual = handlerResolver.getHandler();
        } catch (InvalidControllerNameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Assert
        assertEquals("ControllerNameController", actual);
    }

}
