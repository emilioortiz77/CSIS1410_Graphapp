package graphapp.tests.utilities;

import graphapp.models.OrderedPair;
import graphapp.models.TimeFrame;
import graphapp.utilities.Calculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void convertListToOrderedPairs() {
        List<String> foo = new ArrayList<>();

        foo.add("2024-04-19T05:01:18");
        foo.add("2024-04-19T05:01:18");
        foo.add("2024-04-20T05:01:18");
        foo.add("2024-04-20T05:01:18");
        foo.add("2024-04-20T05:01:18");
        foo.add("2024-04-21T05:01:18");

        Calculator calculator = new Calculator();

        List<OrderedPair> list = calculator.convertListToOrderedPairs(foo, TimeFrame.MONTH);

        assertEquals(3, list.size());
    }
}