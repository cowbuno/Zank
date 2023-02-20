package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Profile {
    public static void profilePage() {
        Scanner scan = new Scanner(System.in);
        DbFunction db = new DbFunction();
        Connection conn = db.connect_to_db("postgres", "postgres", "12345678");
        System.out.println("Your Data:");

    ;

}
