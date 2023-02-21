package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Aviat_Ticket {
    static Scanner scan = new Scanner(System.in);
    static Db_Ticket db = new Db_Ticket();
    static Connection conn=db.connect_to_db_ticket("postgres","postgres","12345678");
    static Index ind = new Index();

    public static void chooseCities(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\nRESERVATION FORM:\n");
        System.out.print("Choose the city:");
        System.out.println("1.Astana - Almaty ");
        System.out.println("2.Astana - Shymkent");
        System.out.println("3.Almaty  - Shymkent")  ;
        System.out.println("4.Almaty - Astana ");
        System.out.println("5.Shymkent - Almaty");
        System.out.println("6.Shymkent - Astana");

        int number = scan.nextInt();

        choose_Time(number);

    }

    public static void choose_Time(int _case) {

        if (_case == 1) {
            System.out.println("Astana - Almaty");

        } else if (_case == 2) {
            System.out.println("Astana - Shymkent");

        } else if (_case == 3) {
            System.out.println("Almaty  - Shymkent");

        } else if (_case == 4) {
            System.out.println("Almaty - Astana ");

        } else if (_case == 5) {
            System.out.println("Shymkent - Almaty");

        } else if (_case == 6) {
            System.out.println("Shymkent - Astana");

        }

        System.out.println("departure - arrival | place | price");
        db.read_time(conn, "table" + _case);
        int empid = scan.nextInt();
        buying_Ticket(empid);
    }


    public static void buying_Ticket(int empid){
        System.out.print("Please enter card's number: ");
        String card_number = scan.next();
        System.out.print("Please enter card's data: ");
        String card_data = scan.next();
        System.out.print("Please enter card's cvv: ");
        String card_cvv = scan.next();
        System.out.println("You succesfully buy a ticket");
//        ind.index_Page();
    }

}