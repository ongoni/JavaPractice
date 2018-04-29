package com.ongoni.servlets;

import com.ongoni.dao.DAOInstanceHolder;
import com.ongoni.entities.Client;
import com.ongoni.dao.json.ClientJsonDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOInstanceHolder.h2Dao.AddClient(
        /*DAOInstanceHolder.jsonDao.AddClient(*/new Client(
                Client.getNextAllowedId(),
                req.getParameter("name"),
                req.getParameter("password"),
                req.getParameter("bank"),
                Double.parseDouble(req.getParameter("balance"))
        ));

        resp.sendRedirect("all");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addClient.jsp").forward(req, resp);
    }

}
