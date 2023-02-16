package com.company;

import java.sql.Connection;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        DbFunction db = new DbFunction();
        Connection conn = db.connect_to_db("postgres","postgres","12345678");
//        db.createTable(conn, "consumer ");
//        db.insert_row(conn, "consumer", "Nurkhat", "nkwt", "nktwn@gmail.com", "050509551608", "123456789" );
//        db.update_name(conn, "consumer", "Nurkhat", "Zhenis");
//        db.read_data(conn, "consumer");
//        System.out.println(db.checkAccount(conn,"consumer", "Zhenis", "123456789"));
        userRegistration reg = new userRegistration();
//        reg.register();
        reg.login();
    }
}
