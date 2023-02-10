package com.company;

import java.sql.Connection;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        DbFunciton db = new DbFunciton();
        Connection conn = db.connect_to_db("postgres","postgres","12345678");
        //db.createTable(conn, "consumer ");
        db.insert_row(conn, "employee", "abhishek", "india");
    }
}
