import java.util.ArrayList;
import java.util.List;

public class Order {
    private Client client;
    private List<OrderLine> orderLines;

    public Order(Client client) {
        this.client = client;
        this.orderLines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine line) {
        orderLines.add(line);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public double calculateTotalBeforeDiscount() {
        double totalPrice = 0.0;
        for (OrderLine line : orderLines) {
            totalPrice += line.calculateLineTotal();
        }
        return totalPrice;
    }

    public double calculateOrderTotal() {
        double orderTotal = 0.0;
        double beforeDiscount = calculateTotalBeforeDiscount();
        double basicDiscountAmount = client.getBasicDiscount() * beforeDiscount;

        orderTotal = beforeDiscount - basicDiscountAmount;

        double additionalDiscountRate = 0.0;
        if (orderTotal > 30000) {
            additionalDiscountRate = client.getVolumeDiscountThreshold2();

        } else if (orderTotal > 10000) {
            additionalDiscountRate = client.getVolumeDiscountThreshold1();
        }
        double additionalDiscountAmount = orderTotal * additionalDiscountRate;


        return orderTotal - additionalDiscountAmount;
    }

    public double calculateBasicDiscountAmount() {
        double totalOrderAmount = 0.0;
        return totalOrderAmount *= client.getBasicDiscount() / 100;

    }


}
