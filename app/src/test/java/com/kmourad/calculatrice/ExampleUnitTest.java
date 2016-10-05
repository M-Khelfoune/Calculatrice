package com.kmourad.calculatrice;

import org.junit.Test;

import static android.R.attr.value;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test // Test Divide
    public void divide_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onKeyClikedIsValid("2");
        compute.onKeyClikedIsValid("5");
        compute.onKeyClikedIsValid("/");
        compute.onKeyClikedIsValid("5");
        compute.onKeyClikedIsValid("=");
        String value = compute.getCurrentValue().toString();
        assertTrue(value.equals("5") );
    }

    @Test // Multiply and virgule
    public void multiply_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onKeyClikedIsValid("3");
        compute.onKeyClikedIsValid(",");
        compute.onKeyClikedIsValid("1");
        compute.onKeyClikedIsValid("*");
        compute.onKeyClikedIsValid("2");
        compute.onKeyClikedIsValid("=");
        String value = compute.getCurrentValue().toString();
        assertTrue(value.equals("6,2") );
    }

    @Test // Plus
    public void plus_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onKeyClikedIsValid("3");
        compute.onKeyClikedIsValid("+");
        compute.onKeyClikedIsValid("2");
        compute.onKeyClikedIsValid("=");
        String value = compute.getCurrentValue().toString();
        assertTrue(value.equals("5") );
    }

    @Test // Minus
    public void Minus_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onKeyClikedIsValid("3");
        compute.onKeyClikedIsValid("-");
        compute.onKeyClikedIsValid("2");
        compute.onKeyClikedIsValid("=");
        String value = compute.getCurrentValue().toString();
        assertTrue(value.equals("1") );
    }

    @Test // button 'C' Clear
    public void Clear_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onKeyClikedIsValid("3");
        compute.onKeyClikedIsValid("2");
        compute.onKeyClikedIsValid("C");
        String value = compute.getCurrentValue().toString();
        assertTrue(value.equals("0") );
    }

    @Test // Mltiple operation continue
    public void Multiple_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onKeyClikedIsValid("3");
        compute.onKeyClikedIsValid("/");
        compute.onKeyClikedIsValid("1");
        compute.onKeyClikedIsValid("=");
        compute.onKeyClikedIsValid("+");
        compute.onKeyClikedIsValid("1");
        compute.onKeyClikedIsValid("=");
        compute.onKeyClikedIsValid("-");
        compute.onKeyClikedIsValid("2");
        compute.onKeyClikedIsValid("=");
        compute.onKeyClikedIsValid("*");
        compute.onKeyClikedIsValid("5");
        compute.onKeyClikedIsValid("=");
        String value = compute.getCurrentValue().toString();
        assertTrue(value.equals("10") );
    }

}