package com.ongoni.servlets;

import com.ongoni.dao.DAOInstanceHolder;
import com.ongoni.entities.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowClientsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("clients", DAOInstanceHolder.jsonDao.getClients());
        req.setAttribute("clients", DAOInstanceHolder.h2Dao.getClients());
        req.getRequestDispatcher("/showClients.jsp").forward(req, resp);
    }

}
