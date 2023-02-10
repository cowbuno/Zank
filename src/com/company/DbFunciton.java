package com.company;
import javax.swing.plaf.nimbus.State;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunciton {
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
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try {
            String query = "create table " + table_name + "(empid SERIAL, name varchar(20), surname varchar(20), email varchar(30) ,IIN varchar(12), password varchar(20), primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void insert_row(Connection conn,String table_name, String name, String surname, String email, String IIN, String password){
        Statement statement;
        try {
            String query=String.format("insert into %s(name, surname, email, IIN, password) values('%s','%s','%s','%s','%s');",table_name, name, surname, email, IIN, password);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("surname") + " ");
                System.out.print(rs.getString("email") + " ");
                System.out.println(rs.getString("IIN") + " ");

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean checkAccount(Connection conn, String table_name, String name, String password){
        try {
            String query = String.format("select * from %s where name='%s' and password='%s'", table_name, name, password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public void update_name(Connection conn, String table_name, String old_name, String new_name){
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name = '%s'", table_name, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data update");
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
