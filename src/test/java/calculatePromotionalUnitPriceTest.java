package test.java;

import main.java.OrderLine;
import main.java.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calculatePromotionalUnitPriceTest {
    @Test
    void calculatePromotionalUnitPrice_ThirtyPercentOff() {
        Product product = new Product(2, "Granny's Cup Cake", 0.38, 1.2, "30% off");
        OrderLine line = new OrderLine(product, 100);
        double unitPrice = line.calculateStandardUnitPrice();
        double expectedPromotionalPrice = Math.round(unitPrice * 0.7 * 100000.0) / 100000.0;

        double actualPromotionalPrice = line.calculatePromotionalUnitPrice();

        assertEquals(expectedPromotionalPrice, actualPromotionalPrice,
                "The promotional unit price should be 30% less than the standard price.");
    }

    @Test
    void calculatePromotionalUnitPrice_BuyTwoGetThirdFree() {
        Product product = new Product(4, "Crispy Chips", 0.60, 1.0, "Buy 2, get 3rd free");
        OrderLine line = new OrderLine(product, 20000);

        int freeItems = 20000 / 3;
        double totalPriceForAllItems = 20000 * 1.60;
        double valueOfFreeItems = freeItems * 1.60;
        double expectedPromotionalPrice = Math.round((totalPriceForAllItems - valueOfFreeItems) / 20000 * 100000.0) / 100000.0;

        // Call the method under test
        double actualPromotionalPrice = line.calculatePromotionalUnitPrice();

        // Assert that the actual promotional price matches the expected price
        assertEquals(expectedPromotionalPrice, actualPromotionalPrice,
                "The promotional unit price should reflect the 'Buy 2, get 3rd free' promotion.");
    }

}