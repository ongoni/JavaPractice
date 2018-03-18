package com.ongoni.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ongoni.entities.Client;

import java.io.File;
import java.util.List;
import java.util.Objects;

public final class ClientHandler {

    public static List<Client> clients;

    private static File DEFAULT_FILE = new File(
            Objects.requireNonNull(
                    ClientHandler.class
                            .getClassLoader()
                            .getResource("clients.json"))
                    .getFile());

    public static List<Client> getClients() {
        return new Gson()
                .fromJson(
                        FileReader.readAll(DEFAULT_FILE),
                        new TypeToken<List<Client>>() { }.getType()
                );
    }

    public static void SaveClients() {
        FileWriter.write(
                new GsonBuilder()
                        .setPrettyPrinting()
                        .create()
                        .toJson(clients),
                DEFAULT_FILE
        );
    }

}
