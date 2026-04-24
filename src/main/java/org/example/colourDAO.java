package org.example;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

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

}
