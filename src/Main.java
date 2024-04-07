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


        for (OrderLine line : order.getOrderLines()) {
            System.out.println("Client;     " + order.getClient().getName());
            System.out.println("Product:    " + order.getOrderLines().get(0).getProduct().getName());
            System.out.println("Quantity:   " + order.getOrderLines().get(0).getQuantity());
            System.out.println("Standard Unit Price:    " + order.getOrderLines().get(0).calculateStandardUnitPrice());
            System.out.println("Promotional Price:  " + order.getOrderLines().get(0).calculatePromotionalUnitPrice());
            System.out.println("Line Total:     " + order.getOrderLines().get(0).calculateLineTotal());
            System.out.println("Total Before Discount:      " + order.calculateTotalBeforeDiscount());
            if (order.calculateBasicDiscountAmount() == 0) {
                System.out.println("Additional Volume Discount:     " + order.calculateBasicDiscountAmount());
            } else {
                System.out.println("Additional Volume Dsicount at " + order.calculateBasicDiscountAmount() + ":");
            }

            System.out.println("Order Total:    " + order.calculateOrderTotal());
        }

    }
}