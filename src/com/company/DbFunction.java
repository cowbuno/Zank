package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunction {
    public Connection connect_to_db(String dbname, String user, String pass) {
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

    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(empid SERIAL, name varchar(20), surname varchar(20), email varchar(30) ,IIN varchar(12), password varchar(20), primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insert_row(Connection conn, String table_name, String name, String surname, String email, String IIN, String password) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name, surname, email, IIN, password) values('%s','%s','%s','%s','%s');", table_name, name, surname, email, IIN, password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static boolean checkAccount(Connection conn, String table_name, String email, String password) {
        try {
            String query = String.format("select * from %s where email='%s' and password='%s'", table_name, email, password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static void userInfo(Connection conn, String table_name, String email,  String password) {
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("select * from %s where email = '%s' and password= '%s'", table_name, email, password);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(" | Surname: " + rs.getString("surname"));
                System.out.println(" | Name: " + rs.getString("name"));
                System.out.println(" | IUN: " + rs.getString("iin"));
                System.out.println(" | E-mail: " + rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_name(Connection conn, String table_name, String old_name, String new_name) {
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name = '%s'", table_name, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data update");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}