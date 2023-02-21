package com.company;

import com.company.database.DbFunctions;
import java.sql.Connection;
import java.util.Scanner;

public class Enter_to_site {
    static Scanner scan = new Scanner(System.in);
    static DbFunctions db = new DbFunctions();
    static Connection conn=db.connectToDb("postgres","postgres","12345678");

    public static void register(){
        System.out.print("\nREGISTRATION FORM:\n");
        System.out.print("Your Name:");
        String name = scan.next();
        System.out.print("Your Surname:");
        String surname = scan.next();
        System.out.print("Your email:");
        String email = scan.next();
        System.out.print("Your IIN: ");
        String IIN = scan.next();
        System.out.print("Your password:");
        String password = scan.next();


        db.insertRow(conn,"consumer", name,surname, email, IIN ,password);
        System.out.println("Successful registration");
    }

    public static void again_loginig(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Password or Email is wrong");
        System.out.println("1) If you don't have account, register");
        System.out.println("2) Please log in again");

        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 : register();
            case 2 : login();
        }
    }

    public static void login() {
        Index ind=new Index();
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your email:");
        String email = scan.next();
        System.out.print("Enter your password:");
        String password = scan.next();
        if(db.checkAccount(conn, "consumer", email, password) == true){
            System.out.println("Successful log in ");
            ind.index_Page(email,password);

        } else {
            again_loginig();
        }
    }
}