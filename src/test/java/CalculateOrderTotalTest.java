package test.java;

import main.java.Client;
import main.java.Order;
import main.java.OrderLine;
import main.java.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateOrderTotalTest {

    @Test
    void calculateOrderTotal() {
        Client client = new Client(5, "MNO Vending", 0, 0.05, 0.07);
        Order order = new Order(client);
        Product product1 = new Product(4, "Crispy Chips", 0.60, 1.0, "Buy 2, get 3rd free");
        Product product2 = new Product(1, "Danish Muffin", 0.52, 0.8, "none");

        OrderLine line1 = new OrderLine(product1, 20000);
        OrderLine line2 = new OrderLine(product2, 10000);

        order.addOrderLine(line1);
        order.addOrderLine(line2);

        double totalBeforeDiscount = 30734.40;
        double basicDiscountAmount = totalBeforeDiscount * client.getBasicDiscount();
        double totalAfterBasicDiscount = totalBeforeDiscount - basicDiscountAmount;
        double additionalDiscountRate = (totalAfterBasicDiscount > 30000) ?
                client.getVolumeDiscountThreshold2() :
                (totalAfterBasicDiscount > 10000) ?
                        client.getVolumeDiscountThreshold1() : 0.0;
        double additionalDiscountAmount = totalAfterBasicDiscount * additionalDiscountRate;
        double expectedTotal = totalAfterBasicDiscount - additionalDiscountAmount;

        double actualTotal = order.calculateOrderTotal();

        assertEquals(expectedTotal, actualTotal, "The calculated order total should match the expected value.");
    }
}