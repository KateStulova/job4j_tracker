package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCounterTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCounter.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionCounter.diapason(2, 5, x -> 2 * Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = Arrays.asList(13D, 25D, 41D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionCounter.diapason(3, 6, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(27D, 81D, 243D);
        assertThat(result, is(expected));
    }
}