package com.ongoni.entities;

public class Client {

    protected int id;
    protected String name;
    protected String password;
    protected String bankAccountNumber;
    protected double bankAccountBalance;

    public Client() { }

    public Client(String name, String password, String bankAccountNumber, double bankAccountBalance) {
        this.name = name;
        this.password = password;
        this.bankAccountNumber = bankAccountNumber;
        this.bankAccountBalance = bankAccountBalance;
    }

    public Client(int id, String name, String password, String bankAccountNumber, double bankAccountBalance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.bankAccountNumber = bankAccountNumber;
        this.bankAccountBalance = bankAccountBalance;
    }

    public int getId() {
        return id;
    }

    public Client setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Client setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Client setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public double getBankAccountBalance() {
        return bankAccountBalance;
    }

    public Client setBankAccountBalance(double bankAccountBalance) {
        this.bankAccountBalance = bankAccountBalance;
        return this;
    }

}
