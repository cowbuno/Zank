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
        System.out.print("Your IIN");
        String IIN = scan.next();
        System.out.print("Your password");
        String password = scan.next();


        DbFunction.insert_row(conn,"consumer", name,surname, email, IIN ,password);
    }

//    public static boolean checkLogin(){
//        System.out.print("\nLOGIN FORM:\n");
//        System.out.print("Your Name:");
//        String name = scan.next();
//        System.out.print("Your Surname:");
//        String surname = scan.next();
//        System.out.print("Enter your password:");
//        Integer password = scan.nextInt();
//
//        //Dbfunctions.login(conn,"person",name,surname,password);
//        boolean isLoginSuccessful = Dbfunctions.login(conn,"person",name,surname,password);
//        if (isLoginSuccessful) {
//            int cashofperson = db.get_cash_person(conn,"person",name,surname,password);
//            System.out.println("YOUR CASH NOW: " + cashofperson);
//            SearchByCountry.searchByCountry();
//
//            System.out.println("WRITE ID OF HOTEL:");
//            Integer write_id_hotel = scan.nextInt();
//            scan.nextLine();
//            int priceofhotel = db.get_price_hotel(conn, "tur", write_id_hotel);
//            System.out.println("THE PRICE OF THIS HOTEl: " + priceofhotel + " AND YOU HAVE:" + cashofperson);
//
//            System.out.println("\nDO YOU CONFIRM YOUR HOTEL? YES==1/NO==2");
//            int confirm = scan.nextInt();
//            if(confirm == 1){
//                if(priceofhotel>cashofperson){
//                    System.out.println("YOU HAVE LESS MONEY, SORRY");
//                }
//                else if(priceofhotel<cashofperson){
//                    int remains = cashofperson - priceofhotel;
//                    db.update_cash(conn, remains, cashofperson, name,surname,password);
//                    System.out.println("YOU SUCCESSFULLY BOUGHT");
//                }
//                else {
//                    System.out.println("ERROR 404");
//                }
//            }
//            else {
//                System.out.println("Ok, see you soon");
//            }
//        }
//        else{
//            System.out.println("MAYBE YOUR NAME/SURNAME/PASSWORD IS WRONG");
//        }
//        return isLoginSuccessful;
//    }
}