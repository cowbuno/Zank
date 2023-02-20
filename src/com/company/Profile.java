package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Profile {
    public static void profilePage() {
        Scanner scan = new Scanner(System.in);
        DbFunction db = new DbFunction();
        Connection conn = db.connect_to_db("postgres", "postgres", "12345678");
        Index ind = new Index();

        System.out.println("Your Data:");
        db.read_data(conn,"consumer");
        System.out.println("Do you want to change your data?");
        String choose = scan.nextLine();
        if (choose.toLowerCase()=="yes"){

        }
        else if (choose.toLowerCase()=="no"){
            System.out.println("Your data hasn't changed");
            ind.indexPage();

        }
    }

    public static void changeData(){
        Scanner scan = new Scanner(System.in);
        DbFunction db = new DbFunction();
        Connection conn = db.connect_to_db("postgres", "postgres", "12345678");
        System.out.println("1.e-mail");
        System.out.println("2.uin");
        System.out.println("3.password");
        System.out.println("4.cancel");
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
            profilePage();
        }

    }


    }
