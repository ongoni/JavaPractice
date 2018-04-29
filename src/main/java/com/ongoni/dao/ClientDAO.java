package com.ongoni.dao;

import com.ongoni.entities.Client;

import java.util.List;

public interface ClientDAO {

    List<Client> getClients();
    void AddClient(Client client);

}
