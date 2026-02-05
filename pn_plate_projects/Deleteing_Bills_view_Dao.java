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
public class Deleteing_Bills_view_Dao {
   
     public ObservableList<Deleteing_Bills_view_pojo> Deleteing_Bills_Deteals() throws Exception{
         
             ObservableList<Deleteing_Bills_view_pojo> list = FXCollections.observableArrayList();


    String sql =
        "SELECT billid, customername, moblieNumber, date, time,amount, " +
        "paidamount, subtotal, receied, tolal, balance, udeletedate, deletetime " +
        "FROM usert_bill_delete";

    Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);

    PreparedStatement ps = con.prepareStatement(sql);
    
        ResultSet rs = ps.executeQuery();
    
        while (rs.next()) {


            Deleteing_Bills_view_pojo users = new Deleteing_Bills_view_pojo();

            users.setBillid(rs.getInt("billid"));
            users.setCastomerName(rs.getString("customername"));
            users.setMobileNumber(rs.getLong("moblieNumber"));
            users.setDate(rs.getString("date"));
            users.setTime(rs.getString("time"));
            users.setAmount(rs.getDouble("amount"));
            users.setPaidAmount(rs.getDouble("paidamount"));
            users.setSubTotal(rs.getDouble("subtotal"));
            users.setReceied(rs.getDouble("receied"));
            users.setTotal(rs.getDouble("tolal"));
            users.setBalance(rs.getDouble("balance"));
            users.setDeleteingDate(rs.getString("udeletedate"));
            users.setDeleteingTime(rs.getString("deletetime"));

            list.add(users);

}

    return list;
}
 

}
