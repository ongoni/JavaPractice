package com.ongoni.dao;

import com.ongoni.dao.database.ClientH2DAO;
import com.ongoni.dao.json.ClientJsonDAO;

public final class DAOInstanceHolder {

    public static ClientDAO h2Dao = new ClientH2DAO();

    public static ClientDAO jsonDao = new ClientJsonDAO();

}
