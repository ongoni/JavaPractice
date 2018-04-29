package com.ongoni.dao.database;

import com.ongoni.dao.ClientDAO;
import com.ongoni.dao.DAOInstanceHolder;
import com.ongoni.entities.Client;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ClientH2DAO implements ClientDAO {

    private String url;
    private String username;
    private String password;

    public ClientH2DAO() {
        Properties properties = new Properties();

        try(FileInputStream fis = new FileInputStream((Objects.requireNonNull(
                getClass().getClassLoader().getResource("database.properties"))).getPath())) {
            properties.load(fis);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            Class.forName(properties.getProperty("db.driver"));

            createClientTable();
        } catch (IOException | NullPointerException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    private void createClientTable() {
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement createTableStatement = connection.createStatement();
            createTableStatement.executeUpdate(
                    "create table if not exists client ("
                            + "id int auto_increment not null,"
                            + "`name` varchar(50) not null,"
                            + "password varchar(100) not null,"
                            + "bank_account varchar(100) not null,"
                            + "balance decimal not null,"
                            + "primary key(id))"
            );
            createTableStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            ResultSet resultSet = connection
                    .createStatement()
                    .executeQuery("select * from client");

            while (resultSet.next()) {
                clients.add(
                        new Client()
                                .setId(resultSet.getInt("id"))
                                .setName(resultSet.getString("name"))
                                .setPassword(resultSet.getString("password"))
                                .setBankAccountNumber(resultSet.getString("bank_account"))
                                .setBankAccountBalance(resultSet.getDouble("balance"))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return clients;
    }

    @Override
    public void AddClient(Client client) {
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            connection
                    .createStatement()
                    .executeUpdate(
                            "insert into client(`name`, password, bank_account, balance) values("
                                    + client.getName() + ", "
                                    + client.getPassword() + ", "
                                    + client.getBankAccountNumber() + ", "
                                    + client.getBankAccountBalance() + ")"
                    );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
