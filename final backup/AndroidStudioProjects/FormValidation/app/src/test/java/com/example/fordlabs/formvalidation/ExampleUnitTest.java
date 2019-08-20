package com.example.fordlabs.formvalidation;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {
   /* @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }*/

   ValidationService validationService = new ValidationService();

    @Test
    public void checkUserName(){
        String expected="FAIZAL";
       when(validationService.getUserName(1)).thenReturn("FAIZAL");
        String actual=validationService.getUserName(1);

        assertEquals(expected,actual);

    }

    @Test
    public void chechMocks(){
        when()
    }


}