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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vinot
 */
public class NewStock_Dao {
 
    
    public ObservableList<NewStock_Detials_pojo> NEWSTOCk_SELECTED() throws Exception {

    ObservableList<NewStock_Detials_pojo> list = FXCollections.observableArrayList();

    String sql = "SELECT serial_number ,Productname,model,size,price,discount,openingstock,"
            + "newstock,insertdate,inserttime FROM product_newstock ";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            NewStock_Detials_pojo users = new NewStock_Detials_pojo();

            users.setSerial(rs.getInt("serial_number"));
            users.setProductName(rs.getString("Productname"));
            users.setModel(rs.getString("model"));
            users.setSize(rs.getString("size"));
            users.setPrice(rs.getDouble("price"));
            users.setDiscount(rs.getDouble("discount"));
            users.setOldStock(rs.getInt("openingstock")); 
            users.setNewStock(rs.getInt("newstock"));
            users.setDate(rs.getString("insertdate"));
            users.setTime(rs.getString("inserttime"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
public void STOCK_DELETE(int serialNumber)throws Exception{


    String sql = "DELETE FROM product_newstock WHERE serial_number = ?";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, serialNumber);
        ps.executeUpdate();
    }
}


}    

