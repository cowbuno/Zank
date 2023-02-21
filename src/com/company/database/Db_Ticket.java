package com.company.database;

import java.sql.*;

public class Db_Ticket extends DbFunctions {
    static void create_table_ticket(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name  + "(empid SERIAL, departure_time varchar(20), arrival_time varchar(20), place integer, price integer, primary key(empid));";
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
                System.out.print(rs.getString("arrival_time") + " |    ");
                System.out.print(rs.getString("place") + "    | ");
                System.out.println(rs.getString("price") + " kzt");
            }

        } catch (SQLException e) {
            e.printStackTrace();
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