package com.example.fordlabs.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class CalculationServiceTest {

    CalculationService calculationService = new CalculationService();

    private Integer a =4;
    private Integer b= 4;

    @Test
    public void testAddition(){
    assertEquals(8,calculationService.addInputs(a,b));
    }

    @Test
    public void testSubtraction(){
        assertEquals(0,calculationService.subtractInputs(a,b));
    }

    @Test
    public void testMultiplication(){
        assertEquals(16,calculationService.multiplyInputs(a,b));
    }

    @Test
    public void testDivision(){
        assertEquals(1,calculationService.divideInputs(a,b));
    }


    /*@Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }*/
}