package com.company;

import com.company.database.DbFunctions;

import java.sql.Connection;
import java.util.Scanner;

public class Profile {
    static Scanner scan = new Scanner(System.in);
    static DbFunctions db = new DbFunctions();
    static Connection conn = db.connectToDb("postgres", "postgres", "12345678");
    static Index ind = new Index();


    public static void profile_page(String email, String password) {
        System.out.println("Your Data:");
        db.user_info(conn, "consumer", email, password);
        System.out.println("Do you want to change your data?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choose = scan.nextInt();


        if (choose == 1){
            changeData(email, password);
        }
        else if (choose == 2){
            System.out.println("Your data hasn't changed");
            ind.index_Page(email, password);

        }
    }

    public static void changeData(String email, String password){
        System.out.println("1.e-mail");
        System.out.println("2.iin");
        System.out.println("3.password");
        System.out.println("4.Cancel");
        int choice= scan.nextInt();
        if (choice==1){
            System.out.print("Your current email:");
            String old = scan.next();
            System.out.print("Your new email:");
            String _new = scan.next();
            db.update_email(conn, "consumer", _new, old);
            profile_page(_new,password);
        }
        else if (choice==2){
            System.out.print("Your current iin:");
            String old = scan.next();
            System.out.print("Your new iin:");
            String _new = scan.next();
            db.update_iin(conn, "consumer", _new, old);
            profile_page(email,password);
        }
        else if (choice==3){
            System.out.print("Your current password:");
            String old = scan.next();
            System.out.print("Your new password:");
            String _new = scan.next();
            db.update_password(conn, "consumer", _new, old);
            profile_page(email,_new);
        }
        else if (choice==4){
            profile_page(email, password);
        }
    }
}
