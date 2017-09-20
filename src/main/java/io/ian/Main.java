package io.ian;

import io.ian.helpers.DatabaseManager;
import io.ian.models.Stat;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:stats.db")) {

            DatabaseManager dbm = new DatabaseManager(conn);
            Statement statement = dbm.getStatement();
            dbm.dropStatTable();
            dbm.createStatTable();
            dbm.insertIntoStatTable("Ian", 20, 5);
            ArrayList<Stat> results = dbm.getStats();

        } catch (SQLException ex) {
            System.out.println("We encountered a problem talking to the database");
        }

        System.out.println("we good");
    }
}
