package com.company;

import java.sql.Connection;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        DbFunciton db = new DbFunciton();
        Connection conn = db.connect_to_db("postgres","postgres","12345678");
//        db.createTable(conn, "consumer ");
//        db.insert_row(conn, "consumer", "Nurkhat", "nkwt", "nktwn@gmail.com", "050509551608", "123456789" );
//        db.update_name(conn, "employee", "Nurkhat", "Zhenis");
        db.read_data(conn, "consumer");
        System.out.println(db.checkAccount(conn,"consumer", "Zhenis", "123456789"));
    }
}
