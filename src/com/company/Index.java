package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Index {
    static Scanner scan = new Scanner(System.in);
    static DbFunction db = new DbFunction();
    static Connection conn=db.connect_to_db("postgres","postgres","12345678");
    static Profile profile = new Profile();


    public static void indexPage(String email, String password){

        System.out.println("Choose an option:");
        System.out.println("1.Profile");
        System.out.println("2.Air Tickets");
        System.out.println("3.Log Out");

        int choose = scan.nextInt();
        if (choose==1){
            profile.profilePage(email, password);
        }
        else if(choose==2){

        }
        else if(choose==3){
            System.out.println("See you soon!");
        }
        else{
            System.out.println("Please Enter again");
            indexPage(email, password);
        }

    }
}
