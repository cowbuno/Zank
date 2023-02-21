package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Profile {
    static Scanner scan = new Scanner(System.in);
    static DbFunction db = new DbFunction();
    static Connection conn = db.connect_to_db("postgres", "postgres", "12345678");
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
        System.out.println("2.uin");
        System.out.println("3.password");
        System.out.println("4.Cancel");
        int choice= scan.nextInt();
        if (choice==1){
            //изменения в базе данных
        }
        else if (choice==2){
            //изменения в базе данных
        }
        else if (choice==3){
            //изменения в базе данных
        }
        else if (choice==4){
            profile_page(email, password);
        }
    }
}
