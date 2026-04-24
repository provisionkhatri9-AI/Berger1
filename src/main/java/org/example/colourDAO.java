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

        String sql = "INSERT INTO colour(type, color_name, litre_per_bucket, no_of_bucket, volume, base_name, price, stock) values (?,?,?,?,?,?,?,?)";
        try{

            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, c.getType());
            ps.setString(2,c.getName());
            ps.setInt(3,c.getlitrePerBucket());
            ps.setInt(4,c.getnoOfBuckets());
            ps.setInt(5,c.getVolume());
            ps.setString(6,c.getBaseName());
            ps.setInt(7,c.getPrice());
            ps.setInt(8,c.getStock());

            ps.executeUpdate();
            System.out.print("SucessFUlly uploaded");

        }
        catch (Exception e){
            System.out.print("fial");
            throw new RuntimeException(e);
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

    public void updateDB(Colour c){
        String sql;

        String opertation = "add";

        if(opertation.equals("add")){
            sql = "UPDATE colour SET stock = stock + ? WHERE color_name = ? AND base_name=?";
        }
        else {
            sql = "UPDATE colour SET stock = stock - ? WHERE color_name= ? AND base_name = ?";
        }


        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getStock());
            ps.setString(2, c.getName());
            ps.setString(3, c.getBaseName());

            ps.executeUpdate();

        }
        catch (Exception e){
            System.out.print("error");
        }
    }

}

