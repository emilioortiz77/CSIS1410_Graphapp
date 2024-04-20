package graphapp.tests.models;

import graphapp.models.OrderedPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedPairTest {

    @Test
    void isXIntegerFromOrderedPair() {
        OrderedPair orderedPair = new OrderedPair(1,2, "foo");
        assertEquals(1, orderedPair.getX());
    }

    @Test
    void isYIntegerFromOrderedPair() {
        OrderedPair orderedPair = new OrderedPair(1,2, "foo");
        assertEquals(2, orderedPair.getY());
    }

    @Test
    void isLabelStringFromOrderedPair() {
        OrderedPair orderedPair = new OrderedPair(1,2, "foo");
        assertEquals("foo", orderedPair.getLabel());
    }

    @Test
    void testToString() {
        OrderedPair orderedPair = new OrderedPair(1,2, "foo");
        assertEquals("OrderedPair{x=1, y=2, label='foo'}", orderedPair.toString());
    }
}