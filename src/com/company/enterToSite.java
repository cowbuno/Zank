package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class enterToSite {
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
        System.out.println("Successful registration");
    }

    public static void login() {
        System.out.print("\nLOGIN FORM:\n");
        System.out.print("Your email:");
        String email = scan.next();
        System.out.print("Enter your password:");
        String password = scan.next();
        if(db.checkAccount(conn, "consumer", email, password) == true){
            System.out.println("Successful log in ");
//          Должна вызываться функция users что-то там

        } else {
            againLoginig();
        }
    }

// короче это класс, когда неправильный пароль и email  был введен, тогда и вызывается
    public static void againLoginig(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Password or Email is wrong");
        System.out.println("1) Please log in again");
        System.out.println("2) If you don't have account, register");

        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 : register();
            case 2 : login();
        }
    }
}