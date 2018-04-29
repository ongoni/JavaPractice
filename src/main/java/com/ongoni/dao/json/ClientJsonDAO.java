package com.ongoni.dao.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ongoni.dao.ClientDAO;
import com.ongoni.dao.utils.FileReader;
import com.ongoni.dao.utils.FileWriter;
import com.ongoni.entities.Client;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ClientJsonDAO implements ClientDAO {

    private static List<Client> clients;

    private static File DEFAULT_FILE;

    static {
        DEFAULT_FILE = new File(
                Objects.requireNonNull(
                        ClientJsonDAO.class
                                .getClassLoader()
                                .getResource("clients.json"))
                        .getFile());

        clients = new Gson()
                .fromJson(
                        FileReader.readAll(DEFAULT_FILE),
                        new TypeToken<List<Client>>() { }.getType()
                );

        if (!clients.isEmpty()) {
            Client.setLastId(
                    ClientJsonDAO.clients.stream()
                            .max(Comparator.comparingInt(Client::getId))
                            .get()
                            .getId()
            );
        } else {
            ClientJsonDAO.clients = new ArrayList<>();
            Client.setLastId(0);
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void AddClient(Client client) {
        if (clients.stream().anyMatch(x -> x.getId() == client.getId())) {
            return;
        }

        clients.add(client);

        FileWriter.write(
                new GsonBuilder()
                        .setPrettyPrinting()
                        .create()
                        .toJson(clients),
                DEFAULT_FILE
        );
    }

}
