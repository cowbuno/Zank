package com.company;

import com.company.database.Db_Ticket;

import java.sql.Connection;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
//        DbFunction db = new DbFunction();
//        Connection conn = db.connect_to_db("postgres","postgres","12345678");


        Scanner scan = new Scanner(System.in);
        Enter_to_site enter = new Enter_to_site();

        Db_Ticket db_ticket = new Db_Ticket();
        Connection conn = db_ticket.connectToDb("postgres","postgres","12345678");

//        for(int i = 1; i <= 6; i++){
//            db_ticket.create_table_ticket(conn, "table" + i);
//            db_ticket.insert_row(conn, "table" + i, "07:15", "09:15", 40, 25000);
//            db_ticket.insert_row(conn, "table" + i, "14:20", "16:00", 25, 24000);
//            db_ticket.insert_row(conn, "table" + i, "21:20", "22:50", 35, 20000);
//            db_ticket.insert_row(conn, "table" + i, "17:15", "19:00", 15, 24000);
//            db_ticket.insert_row(conn, "table" + i, "09:05", "10:50", 10, 24000);
//        }







//        db.createTable(conn, "consumer ");
//        db.insert_row(conn, "consumer", "Nurkhat", "nkwt", "nktwn@gmail.com", "050509551608", "123456789" );
//        db.update_name(conn, "consumer", "Nurkhat", "Zhenis");
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
