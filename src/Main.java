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


        System.out.println("Client:     " + order.getClient().getName());
        System.out.println("Product 1:      " + order.getOrderLines().get(0).getProduct().getName());
        System.out.println("Product 2:      " + order.getOrderLines().get(1).getProduct().getName());
        System.out.println("Quantity 1:     " + order.getOrderLines().get(0).getQuantity());
        System.out.println("Quantity 2:     " + order.getOrderLines().get(1).getQuantity());
        System.out.println("Standard Unit Price 1:        " + order.getOrderLines().get(0).calculateStandardUnitPrice());
        System.out.println("Standard Unit Price 2:        " + order.getOrderLines().get(1).calculateStandardUnitPrice());
        System.out.println("Promotional Price 1:        " + order.getOrderLines().get(0).calculatePromotionalUnitPrice());
        System.out.println("Promotional Price 2:        " + order.getOrderLines().get(1).calculatePromotionalUnitPrice());
        System.out.println("Line Total 1:       " + order.getOrderLines().get(0).calculateLineTotal());
        System.out.println("Line Total 2:       " + order.getOrderLines().get(1).calculateLineTotal());
        System.out.println("Total before Client Discount:       "  + order.calculateTotalBeforeDiscount());
        System.out.println("Additional Volume Discount:         " );
        System.out.println("Order Total:        " + order.calculateOrderTotal());
    }
}