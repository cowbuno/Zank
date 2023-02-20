package com.company;

import java.sql.*;

public class DbTicket {

    public Connection connect_to_db_ticket(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    static void create_table_ticket(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(empid SERIAL, departure_time varchar(20), arrival_time varchar(20), place integer (20), price integer(20));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insert_row(Connection conn, String table_name, String departure_time, String arrival_time, int place, int price) {
        Statement statement;
        try {
            String query = String.format("insert into %s(departure_time, arrival_time, place, price) values('%s','%s','%s','%s');", table_name, departure_time, arrival_time, place, price);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_time(Connection conn, String table_name) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("empid") + ". ");
                System.out.print(rs.getString("departure_time") + "-");
                System.out.print(rs.getString("arrival_time") + " | ");
                System.out.print(rs.getString("place") + " | ");
                System.out.println(rs.getString("price") + " kzt");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showInfo(Connection conn, String table_name, int empid) {
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where empid = '%s'", table_name, empid);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("departure_time") + "-");
                System.out.print(rs.getString("arrival_time") + " | ");
                System.out.print(rs.getString("place") + " | ");
                System.out.println(rs.getString("price") + " kzt");
            }

            reduce_place(conn,table_name, empid);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void reduce_place(Connection conn, String table_name, int empid) {
        Statement statement;
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}