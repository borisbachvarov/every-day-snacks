import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();      //Ex. input: 5,1=10000,4=20000
        String[] parts = input.split(",");

        int clientId = Integer.parseInt(parts[0]);
        Client client = ClientManager.getClientById(clientId);
        Order order = new Order(client);


        for (int i = 1; i < parts.length; i++) {
            String[] orderDetails = parts[i].split("=");
            int productId = Integer.parseInt(orderDetails[0]);
            int quantity = Integer.parseInt(orderDetails[1]);
            Product product = ProductManager.getProductById(productId);
            OrderLine orderLine = new OrderLine(product, quantity);

            order.addOrderLine(orderLine);
        }


       displayOrderSummary(order);

    }
    private static void displayOrderSummary(Order order) {
        System.out.println("\nOrder Summary:");
        System.out.println("Client: " + order.getClient().getName() + "\n");

        System.out.printf("%-15s %-10s %-20s %-25s %s\n", "Product", "Quantity", "Standard Unit Price", "Promotional Unit Price", "Line Total");
        for (OrderLine line : order.getOrderLines()) {
            String promoPrice = line.getProduct().getPromotion() != null ? String.format("EUR %.5f", line.calculatePromotionalUnitPrice()) : "-";
            System.out.printf("%-15s %-10d EUR %-18.2f %-25s EUR %.2f\n",
                    line.getProduct().getName(),
                    line.getQuantity(),
                    line.calculateStandardUnitPrice(),
                    promoPrice,
                    line.calculateLineTotal());
        }

        double totalBeforeDiscounts = order.calculateTotalBeforeDiscount();
        System.out.println("\nTotal Before Discounts: EUR " + String.format("%.2f", totalBeforeDiscounts));

        double basicDiscountAmount = totalBeforeDiscounts * order.getClient().getBasicDiscount();
        double totalAfterBasicDiscount = totalBeforeDiscounts - basicDiscountAmount;

        double additionalDiscountRate = 0.0;
        double additionalDiscountAmount = 0.0;
        if (totalAfterBasicDiscount > 30000) {
            additionalDiscountRate = order.getClient().getVolumeDiscountThreshold2();
        } else if (totalAfterBasicDiscount > 10000) {
            additionalDiscountRate = order.getClient().getVolumeDiscountThreshold1();
        }

        if (additionalDiscountRate > 0) {
            additionalDiscountAmount = totalAfterBasicDiscount * additionalDiscountRate;
            totalAfterBasicDiscount -= additionalDiscountAmount;
        }

        if (basicDiscountAmount > 0) {
            System.out.println("Basic Client Discount: EUR " + String.format("%.2f", basicDiscountAmount));
        }
        if (additionalDiscountAmount > 0) {
            System.out.println(String.format("Additional Volume Discount at %.0f%%: EUR %.2f", additionalDiscountRate * 100, additionalDiscountAmount));
        }

        System.out.println("Order Total Amount: EUR " + String.format("%.2f", totalAfterBasicDiscount));
    }
}