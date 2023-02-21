package com.company.database;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DbConnection {
    private Connection conn;

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public Connection connectToDb(String dbname, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            setConn(DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass));
            if (getConn() != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}