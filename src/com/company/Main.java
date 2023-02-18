package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DbFunction db = new DbFunction();
        Connection conn = db.connect_to_db("postgres","postgres","12345678");
        Scanner scan = new Scanner(System.in);
        enterToSite enter = new enterToSite();
//        db.createTable(conn, "consumer ");
//        db.insert_row(conn, "consumer", "Nurkhat", "nkwt", "nktwn@gmail.com", "050509551608", "123456789" );
//        db.update_name(conn, "consumer", "Nurkhat", "Zhenis");
//        db.read_data(conn, "consumer");
//        System.out.println(db.checkAccount(conn,"consumer", "Zhenis", "123456789"));

        System.out.println("Hello! It's Zan avia company!");
        System.out.println("Do you have account?");
        System.out.println("1) No, create account");
        System.out.println("2) Yes, log in");

        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 : enter.register();
            case 2 : enter.login();
        }


    }
}
