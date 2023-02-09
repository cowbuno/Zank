package com.company;

import java.sql.Connection;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        DbFunciton db=new DbFunciton();
        Connection conn=db.connect_to_db("postgres","postgres","12345678");
        //db.createTable(conn,"employee");
        //db.insert_row(conn,"employee","Rajat","India");
        //db.update_name(conn,"employee","Rahul","Raj");
        //db.search_by_name(conn,"employee","abhishek");
        //db.delete_row_by_name(conn,"employee","abhishek");
        //db.delete_row_by_id(conn,"employee",4);
        //db.read_data(conn,"employee");
        // write your code here
    }
}
