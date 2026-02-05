/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vinot
 */
public class Product_insert_Dao {
    
   private int serial_number;

public void insertProduct(Product_insert_pojo p) throws Exception {
    
   countInsert();
   

        LocalTime time = LocalTime.now();
        String currentTime =
            time.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        LocalDate date = LocalDate.now();
        String currentDate =
            date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Class.forName(PN_Dao_Paroperty.driver);

        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);

             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO product_insert " +
                "(id,product_name, model, size, price, discount, opening_stock, date, time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, serial_number);
            ps.setString(2, p.getProdectName());
            ps.setString(3, p.getModel());
            ps.setString(4, p.getSize());
            ps.setDouble(5, p.getPrice());
            ps.setDouble(6, p.getDiscount());
            ps.setInt(7, p.getOpeningProduct());
            ps.setString(8, currentDate);
            ps.setString(9, currentTime);

            int data = ps.executeUpdate();
            
           if(data >0){}
           
           String insert = "INSERT SUCCESSFUL";
           
           Product_insertController daos = new Product_insertController();
           
           daos.insert(insert);
        }
    }

public void countInsert()throws Exception{

Class.forName(PN_Dao_Paroperty.driver);

    String sql = "SELECT MAX(id) AS id FROM product_insert";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        int lastSerial = 0;

        if (rs.next()) {
            lastSerial = rs.getInt("id");

            // table empty case
            if (rs.wasNull()) {
                lastSerial = 0;
            }
        }

        serial_number= lastSerial + 001; // ✅ correct place
        System.out.println("Next Serial Number : " + serial_number);    
    
}
}
}
