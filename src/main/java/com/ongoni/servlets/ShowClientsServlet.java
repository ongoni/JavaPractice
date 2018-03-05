package com.ongoni.servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ongoni.dao.FileReaderWriter;
import com.ongoni.entities.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShowClientsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = new FileReaderWriter()
                .readAll(new File("../../clients.json"));

        List<Client> clients = new Gson()
                .fromJson(
                        content,
                        new TypeToken<List<Client>>() { }.getType()
                );

        req.setAttribute("clients", clients);
        req.getRequestDispatcher("clients.jsp").forward(req, resp);
    }

}
