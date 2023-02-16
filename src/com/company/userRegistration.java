package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class userRegistration {
    static Scanner scan = new Scanner(System.in);
    static DbFunction db = new DbFunction();
    static Connection conn=db.connect_to_db("postgres","postgres","12345678");

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


        DbFunction.insert_row(conn,"consumer", name,surname, email, IIN ,password);
    }

    public static void login() {
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your email:");
        String email = scan.next();
        System.out.print("Enter your password:");
        String password = scan.next();
        if(db.checkAccount(conn, "consumer", email, password) == true){
            System.out.println("Successfully entering ");
//          Должна вызываться функция users что-то там

        } else {
            System.out.println("Unsuccessfully entering ");
//          Должна вызываться функция обратного входа либо забыли пароль но это не будет
        }



    }
}