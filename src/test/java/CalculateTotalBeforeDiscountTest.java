package test.java;

import main.java.Client;
import main.java.Order;
import main.java.OrderLine;
import main.java.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalBeforeDiscountTest {

    @Test
    void calculateTotalBeforeDiscount() {
        Client client = new Client(5, "MNO Vending", 0, 0.05, 0.07);
        Order order = new Order(client);
        Product product1 = new Product(4, "Crispy Chips", 0.60, 1.0, "Buy 2, get 3rd free");
        Product product2 = new Product(1, "Danish Muffin", 0.52, 0.8, "none");

        OrderLine line1 = new OrderLine(product1, 20000);
        OrderLine line2 = new OrderLine(product2, 10000);

        order.addOrderLine(line1);
        order.addOrderLine(line2);

        double expectedTotal = 9400.00 + 21334.40;

        double actualTotal = order.calculateTotalBeforeDiscount();
        assertEquals(expectedTotal, actualTotal, "The calculated total before discounts should equal the sum of line totals.");
    }
}