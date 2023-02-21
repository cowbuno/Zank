package com.company.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions extends DbConnection implements IDatabase {

    @Override
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
    @Override
    public void insertRow(Connection conn, String table_name, String name, String surname, String email, String IIN, String password) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name, surname, email, IIN, password) values('%s','%s','%s','%s','%s');", table_name, name, surname, email, IIN, password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean checkAccount(Connection conn, String table_name, String email, String password) {
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

    @Override
    public void user_info(Connection conn, String table_name, String email,  String password) {
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
    @Override
    public void update_email(Connection conn, String table_name, String new_email, String old_email) {
        Statement statement;
        try {
            String query = String.format("update %s set email='%s' where email = '%s'", table_name, new_email, old_email);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void update_iin(Connection conn, String table_name, String new_iin, String old_iin) {
        Statement statement;
        try {
            String query = String.format("update %s set iin='%s' where iin = '%s'", table_name, new_iin, old_iin);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void update_password(Connection conn, String table_name, String new_password, String old_password) {
        Statement statement;
        try {
            String query = String.format("update %s set password='%s' where password = '%s'", table_name, new_password, old_password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}