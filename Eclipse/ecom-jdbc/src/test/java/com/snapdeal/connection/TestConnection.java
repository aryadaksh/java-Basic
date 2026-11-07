package com.snapdeal.connection;

import java.sql.Connection;

import com.snapdeal.util.DBConnection;

public class TestConnection {

    public static void main(String[] args)
            throws Exception {

        Connection con =
                DBConnection.getConnection();

        System.out.println(
                "Connected Successfully");

        con.close();
    }
}
