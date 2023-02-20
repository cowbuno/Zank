package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class aviaTickets {
    static Scanner scan = new Scanner(System.in);
    static DbFunction db = new DbFunction();
    static Connection conn=db.connect_to_db("postgres","postgres","12345678");

    public static void chooseCities{
        Scanner scan = new Scanner(System.in);

        System.out.print("\nRESERVATION FORM:\n");
        System.out.print("Choose the departure city:");
        System.out.println("1.Astana - Almaty ");
        System.out.println("2.Astana - Shymkent");
        System.out.println("3.Almaty  - Shymkent");
        System.out.println("4.Almaty - Astana ");
        System.out.println("5.Shymkent - Almaty");
        System.out.println("6.Shymkent - Astana");

        int number = scan.nextInt();
        scan.nextLine();
        switch (number) {
            case 1 : ;
            case 2 : ;
            case 3 : ;
            case 4 : ;
            case 5 : ;
            case 6 : ;
        }
    }






}
