package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenOneValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(5));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        String[] test = new String[]{"0", "1", "2", "6"};
        Input in = new StubInput(
                test
        );
        ValidateInput input = new ValidateInput(out, in);
        for (String elem : test) {
            int selected = input.askInt("Select: ");
            assertThat(selected, is(Integer.parseInt(elem)));
        }
    }

    @Test
    public void whenMinusInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(-5));
    }
}