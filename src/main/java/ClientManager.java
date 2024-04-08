package main.java;
import java.util.HashMap;

public class ClientManager {

    private static final HashMap<Integer, Client> clients = new HashMap<>();

    static {
        clients.put(1, new Client(1, "ABC Distribution", 5, 0, 0.02));
        clients.put(2, new Client(2, "DEF Foods", 4, 0.01, 0.02));
        clients.put(3, new Client(3, "GHI Trade", 3, 0.01, 0.03));
        clients.put(4, new Client(4, "JKL Kiosks", 2, 0.03, 0.05));
        clients.put(5, new Client(5, "MNO Vending", 0, 0.05, 0.07));
    }

//Code block for getting clients from a json file
//    static {
//        loadClientsFromJson("src/main/java/resources/clients.json");
//    }
//
//    private static void loadClientsFromJson(String filePath) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            List<Client> clientList = mapper.readValue(new File(filePath), new TypeReference<List<Client>>() {
//            });
//            for (Client client : clientList) {
//                clients.put(client.getId(), client);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static Client getClientById(int id) {
        return clients.get(id);
    }

    public static void addClients(int id, Client client) {
        clients.put(id, client);
    }

    public static void removeClient(int id) {
        clients.remove(id);
    }
}
