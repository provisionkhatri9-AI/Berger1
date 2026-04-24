package org.example;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class colourDAO {

    private Connection con;

    public colourDAO(Connection con){
        this.con = con;
    }

    public void insertColour(Colour c){

        String sql = "INSERT INTO colour(type, color_name, litre_per_bucket, volume, base_name, price,stock) values (?,?,?,?,?,?,?)";
        try{
            int i = 1;
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, c.getType());
            ps.setString(2,c.getName());
            ps.setInt(3,c.getlitrePerBucket());
            ps.setInt(4,c.getVolume());
            ps.setString(5,c.getBaseName());
            ps.setInt(6,c.getPrice());
            ps.setInt(7,c.getStock());

            ps.executeUpdate();
            System.out.print("SucessFUlly uploaded");

        }
        catch (Exception e){
            System.out.print("fial");
            throw new RuntimeException(e);
        }
    }


    public void updateDB(Colour c){
        String sql;

        String opertation = "add";

        if(opertation.equals("add")){
            sql = "UPDATE colour SET stock = stock + ?, volume = volume + ? WHERE color_name = ? AND base_name=? AND litre_per_bucket= ?";
        }
        else {
            sql = "UPDATE colour SET stock = stock - ?,  volume = volume-?  WHERE color_name= ? AND base_name = ? AND litre_per_bucket=?";
        }


        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getStock());
            ps.setInt(2,c.getVolume());
            ps.setString(3, c.getName());
            ps.setString(4, c.getBaseName());
            ps.setInt(5,c.getlitrePerBucket());


            ps.executeUpdate();

        }
        catch (Exception e){
            System.out.print("error");
        }
    }
    public void getInfo(){
        String sql = "SELECT * FROM colour ORDER BY id";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("color_name");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");

                System.out.print(id+""+name+""+type+""+price+""+stock);

            }

        }
        catch (Exception e){
            System.out.print("Error");
        }
    }


}

