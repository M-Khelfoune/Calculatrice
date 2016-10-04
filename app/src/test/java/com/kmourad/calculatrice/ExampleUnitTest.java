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
    @Test
    public void addition_isCorrect() throws Exception {
        Compute compute = new Compute();
        compute.onClearClikedValue();     // 0
        compute.onNumberClicked(2);       // 2
        compute.onMultiplyCliked();       // *
        compute.onNumberCliked(3);        // 3
        value = compute.onEqualCliked();  // 6
        compute.onDivideCliked();         // /
        compute.onClikedNumber(2);        // 2
        value = compute.onEqualCliked();  // 3
        compute.onAddCliked();            // +
        compute.onClikedNumber(1);        // 1
        value = compute.onEqualCliked();  // 4
        compute.onMinusCliked();          // -
        compute.onClikedNumber(2);        // 2
        value = compute.onEqualCliked();  // 2
        assertEquals(2, value);
    }
}