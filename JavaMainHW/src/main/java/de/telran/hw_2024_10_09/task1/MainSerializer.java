package de.telran.hw_2024_10_09.task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainSerializer {
    public static void main(String[] args) throws IOException {
        Client client1 = new Client(1L, "status1", 101L, "John", "Smith", "John.Smith@yahoo.com", "USA", "+123456789");
        Client client2 = new Client(2L, "status2", 102L, "Donald", "Duck", "Donald.Duck@yahoo.com", "USA", "+198765432");
        Client client3 = new Client(3L, "status3", 103L, "Kate", "Fox", "Kate.Fox@yahoo.com", "UK", "+234567891");

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        System.out.println("Clients:");
        System.out.println(clients);


        //System.out.println(ClientSerializer.readClient()); - exception
        System.out.println("------------------------------------");

        System.out.println("save client1 to file ...");
        ClientSerializer.write(client1);
        System.out.println("read client from file: ");
        System.out.println(ClientSerializer.readClient());
        System.out.println("------------------------------------");


        System.out.println("save 3 clients to file ...");
        ClientSerializer.write(clients);
        System.out.println("read clients from file: ");
        System.out.println(ClientSerializer.readClients());
        System.out.println("------------------------------------");
    }
}
