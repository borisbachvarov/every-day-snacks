package main.java;

import java.util.HashMap;

public class ProductManager {

    public static final HashMap<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Danish Muffin", 0.52, 0.8, "none"));
        products.put(2, new Product(2, "Granny's Cup Cake", 0.38, 1.2, "30% off"));
        products.put(3, new Product(3, "Frenchy's Croissant", 0.41, 0.9, "none"));
        products.put(4, new Product(4, "Crispy Chips", 0.60, 1.0, "Buy 2, get 3rd free"));
    }

//Code block for getting products from a json file
//    static {
//        loadProductsFromJson("src/main/java/resources/products.json");
//    }
//
//    private static void loadProductsFromJson(String filePath) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            List<Product> productList = mapper.readValue(new File(filePath), new TypeReference<List<Product>>() {
//            });
//            for (Product product : productList) {
//                products.put(product.getId(), product);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static Product getProductById(int id) {
        return products.get(id);
    }

    public static void addProduct(int id, Product product) {
        products.put(id, product);
    }

    public static void removeProduct(int id) {
        products.remove(id);
    }


}
