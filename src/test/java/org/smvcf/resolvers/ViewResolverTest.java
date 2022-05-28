package org.smvcf.resolvers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViewResolverTest {
    //Arrange
    ViewResolver viewResolver = new ViewResolver();

    @Test
    public void should_return_empty_string_when_given_null(){
        //act
        String actual = viewResolver.getViewPage(null);

        //assert
        assertEquals("", actual);
    }

    @Test
    public void should_return_empty_string_when_given_empty_one(){
        //act
        String actual = viewResolver.getViewPage("");

        //assert
        assertEquals("", actual);
    }

    @Test
    public void should_return_prefix_concatenated_with_input_concatenated_with_suffix_when_given_non_empty_or_null_string(){
        //act
        String actual = viewResolver.getViewPage("hamza");

        //assert
        assertEquals("/WEB-INF/view/hamza.jsp", actual);
    }
}