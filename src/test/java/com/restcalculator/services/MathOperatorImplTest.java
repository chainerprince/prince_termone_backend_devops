package com.restcalculator.services;

import com.restcalculator.Exceptions.InvalidOperationException;
import junit.framework.TestCase;

public class MathOperatorImplTest extends TestCase {
    // generate test cases for all the operations
    public void testDoMath() throws InvalidOperationException {
        MathOperatorImpl mathOperatorImpl = new MathOperatorImpl();
        assertEquals(5, mathOperatorImpl.doMath(2, 3, "+"));
        assertEquals(-1, mathOperatorImpl.doMath(2, 3, "-"));
        assertEquals(6, mathOperatorImpl.doMath(2, 3, "*"));
        assertEquals(0.6666666666666666, mathOperatorImpl.doMath(2, 3, "/"));
        assertEquals(8, mathOperatorImpl.doMath(2, 3, "**"));
        assertEquals(0.6989700043360187, mathOperatorImpl.doMath(2, 3, "log"));
        assertEquals(0.6309297535714574, mathOperatorImpl.doMath(2, 3, "ln"));
    }
    // mock the exception
    public void testDoMathException() {
        MathOperatorImpl mathOperatorImpl = new MathOperatorImpl();
        try {
            mathOperatorImpl.doMath(2, 3, "unknown");
            fail("Expected an InvalidOperationException to be thrown");
        } catch (InvalidOperationException e) {
            assertEquals("Unknown operation", e.getMessage());
        }
    }
    // test divide by zero
    public void testDoMathDivideByZero() {
        MathOperatorImpl mathOperatorImpl = new MathOperatorImpl();
        try {
            mathOperatorImpl.doMath(2, 0, "/");
            fail("Expected an InvalidOperationException to be thrown");
        } catch (InvalidOperationException e) {
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }

}