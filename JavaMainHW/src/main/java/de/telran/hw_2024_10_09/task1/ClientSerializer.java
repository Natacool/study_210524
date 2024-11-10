package de.telran.hw_2024_10_09.task1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ClientSerializer {

    public static void write(Client clientObj) throws IOException {
        String fileName = "client.txt";
        write(clientObj, fileName);
    }

    public static void write(Client clientObj, String fileName) throws IOException {
        Path path = Path.of(fileName);
        write(clientObj, path);
    }

    public static void write(Client client, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(client.getId().toString());
        lines.add(client.getStatus());
        lines.add(client.getTaxCode().toString());
        lines.add(client.getFirstName());
        lines.add(client.getLastName());
        lines.add(client.getEmail());
        lines.add(client.getAddress());
        lines.add(client.getPhone());
        write(lines, path);

    }

    public static void write(List<Client> clients) throws IOException {
        String fileName = "clients.txt";
        Path path = Path.of(fileName);

        List<String> lines = new ArrayList<>();
        Integer size = clients.size();
        lines.add(size.toString());

        for (Client client: clients) {
            lines.add(client.getId().toString());
            lines.add(client.getStatus());
            lines.add(client.getTaxCode().toString());
            lines.add(client.getFirstName());
            lines.add(client.getLastName());
            lines.add(client.getEmail());
            lines.add(client.getAddress());
            lines.add(client.getPhone());
        }
        write (lines, path);
    }

    private static void write(List<String> lines, Path objPath) throws IOException {
        Files.write (objPath,lines);
    }




    public static Client readClient() throws IOException {
        String fileName = "client.txt";
        return readClient(fileName);
    }

    public static Client readClient(String fileName) throws IOException {
        Path path = Path.of(fileName);
        return readClient(path);
    }

    public static Client readClient(Path path) throws IOException {
        Client client = new Client();

        List<String> lines = read(path);
        if (lines.size() < 8)
            return null;

        client.setId(Long.parseLong(lines.get(0)));
        client.setStatus(lines.get(1));
        client.setTaxCode(Long.parseLong(lines.get(2)));
        client.setFirstName(lines.get(3));
        client.setLastName(lines.get(4));
        client.setEmail(lines.get(5));
        client.setAddress(lines.get(6));
        client.setPhone(lines.get(7));

        return client;

    }


    public static List<Client> readClients() throws IOException {
        List<Client> clients = new ArrayList<>();
        String fileName = "clients.txt";
        Path path = Path.of(fileName);
        List<String> lines = read(path);
        int size = Integer.parseInt(lines.get(0));

        for (int i=1; i<lines.size(); i=i+8) {
            Client client = new Client();
            client.setId(Long.parseLong(lines.get(i)));
            client.setStatus(lines.get(i+1));
            client.setTaxCode(Long.parseLong(lines.get(i+2)));
            client.setFirstName(lines.get(i+3));
            client.setLastName(lines.get(i+4));
            client.setEmail(lines.get(i+5));
            client.setAddress(lines.get(i+6));
            client.setPhone(lines.get(i+7));
            clients.add(client);
        }

        if (size == clients.size()){
            return clients;
        } else {
            return null;
        }
    }

    private static List<String> read(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        return lines;
    }


// serialize 1
    public static void serializeClient(Client client) throws IOException {
        String fileName= "ser_client.txt";
        serializeClient(client, fileName);
    }

    public static void serializeClient(Client client, String fileName)throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(client);
        outputStream.close();
    }

// serialize list
    public static void serializeClients(Client[] clients) throws IOException {
        String fileName= "ser_clients.txt";
        serializeClients(clients, fileName);
    }

    public static void serializeClients(Client[] clients, String fileName) throws IOException {
        try {
            FileOutputStream fileOutput = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(clients);
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }




// deserialize 1
    public static Client deserializeClient() throws IOException, ClassNotFoundException {
        String fileName= "ser_client.txt";
        return deserializeClient(fileName);
    }

    public static Client deserializeClient(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        Client client = (Client) inputStream.readObject();
        inputStream.close();
        return client;
    }


// deserialize list
    public static Client[] deserializeClients() throws IOException {
        String fileName= "ser_clients.txt";
        return deserializeClients(fileName);
    }

    public static Client[] deserializeClients(String fileName) throws IOException {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);
            Client[] clients = (Client[]) inputStream.readObject();
            inputStream.close();
            return clients;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}