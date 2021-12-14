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
        int selected0 = input.askInt("Select: ");
        assertThat(selected0, is(0));
        int selected1 = input.askInt("Select: ");
        assertThat(selected1, is(1));
        int selected2 = input.askInt("Select: ");
        assertThat(selected2, is(2));
        int selected6 = input.askInt("Select: ");
        assertThat(selected6, is(6));

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