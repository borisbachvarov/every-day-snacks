package test.java;

import main.java.OrderLine;
import main.java.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateStandardUnitPriceTest {

    @Test
    void calculateStandardUnitPrice_PercentageMarkup() {
        Product product = new Product(1, "Danish Muffin", 0.52, 0.8, "none");
        OrderLine line = new OrderLine(product, 10000);
        double expected = 0.94;

        double actual = line.calculateStandardUnitPrice();

        assertEquals(expected, actual, "");
    }

    @Test
    void calculateStandardUnitPrice_FixedMarkup() {
        Product product = new Product(4, "Crispy Chips", 0.60, 1.0, "Buy 2, get 3rd free");
        OrderLine line = new OrderLine(product, 20000);
        double expected = 1.60;

        double actual = line.calculateStandardUnitPrice();

        assertEquals(expected, actual, "");
    }
}