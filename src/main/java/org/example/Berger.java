package org.example;

import java.sql.Connection;
import java.util.*;





public class Berger {
    public static  void main(String[] args){

        Input input = new Input();
        Colour info = input.inputField();
        info.totalLitre();
        System.out.print(info.getName());

        Connection con = DBconnection.getConnection();

        colourDAO dao = new colourDAO(con);
        dao.insertColour(info);





    }
}