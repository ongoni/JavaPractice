package com.ongoni.servlets;

import com.ongoni.dao.ClientHandler;
import com.ongoni.entities.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;

public class ShowClientsServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        ClientHandler.clients = ClientHandler.getClients();
        Client.setLastId(
                ClientHandler.clients.stream()
                        .max(Comparator.comparingInt(Client::getId))
                        .get()
                        .getId()
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", ClientHandler.clients);
        req.getRequestDispatcher("/clients.jsp").forward(req, resp);
    }

}
