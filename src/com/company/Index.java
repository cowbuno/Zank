package com.company;

import com.company.database.DbFunctions;
import com.company.ticket.Avia_Ticket;

import java.sql.Connection;
import java.util.Scanner;

public class Index {
    static Scanner scan = new Scanner(System.in);
    static DbFunctions db = new DbFunctions();
    static Connection conn=db.connectToDb("postgres","postgres","12345678");
    static Profile profile = new Profile();
    static Avia_Ticket avia = new Avia_Ticket();


    public static void index_Page(String email, String password){

        System.out.println("Choose an option:");
        System.out.println("1.Profile");
        System.out.println("2.Air Tickets");
        System.out.println("3.Log Out");

        int choose = scan.nextInt();
        if (choose==1){
            profile.profile_page(email, password);
        }
        else if(choose==2){
            Avia_Ticket.chooseCities();
        }
        else if(choose==3){
            System.out.println("See you soon!");
        }
        else{
            System.out.println("Please Enter again");
            index_Page(email, password);
        }

    }
}
