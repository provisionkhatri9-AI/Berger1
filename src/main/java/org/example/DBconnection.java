package org.example;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/paint_info";
    private static final String USER = "postgres";
    private static final String PASSWORD = "provision12";

    public static  Connection getConnection(){
       try{
           Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
           System.out.print("database Connnected");
           return con;

       }
       catch (Exception e){
           System.out.print("error"+ e.getMessage());
           throw new RuntimeException(e);

       }

    }

}
