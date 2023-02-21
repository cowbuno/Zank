package com.company.database;
import java.sql.Connection;

public interface IDatabase {

    public void createTable(Connection conn, String table_name);

    public void insertRow(Connection conn, String table_name, String name, String surname, String email, String IIN, String password);

    public boolean checkAccount(Connection conn, String table_name, String email, String password);

    public void user_info(Connection conn, String table_name, String email, String password);

    public void update_iin(Connection conn, String table_name, String new_iin, String old_iin);

    public void update_email(Connection conn, String table_name, String new_email, String old_email);
    public void update_password(Connection conn, String table_name, String new_password, String old_password);

}
