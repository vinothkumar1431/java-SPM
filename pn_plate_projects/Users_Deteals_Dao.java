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
public class Users_Deteals_Dao {
    
    private String user;
    private String pass;
    private String out_time;
    private String out_date;
    
    
public ObservableList<Users_Bills_pojo> UsersBills_Detials() {

    ObservableList<Users_Bills_pojo> list = FXCollections.observableArrayList();

    int count = 0;

String sql = "SELECT username, password, billId, billing_time, billing_amount " +
             "FROM user_working " +
             "WHERE billing_amount > 0";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            count++;

            Users_Bills_pojo users = new Users_Bills_pojo();

            users.setSerial(count);
            users.setUsername(rs.getString("username"));
            users.setPassword(rs.getString("password"));
            users.setBillId(rs.getInt("billId"));
            users.setBillingTime(rs.getString("billing_time"));
            users.setBillingAmount(rs.getDouble("billing_amount"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

public ObservableList<Users_Working_pojo> Working_Detials() {

    ObservableList<Users_Working_pojo> list = FXCollections.observableArrayList();
    int count = 0;

    String sql =
        "SELECT username, password, " +
        "MAX(in_time) AS in_time, " +
        "MAX(in_date) AS in_date, " +
        "MAX(out_time) AS out_time, " +
        "MAX(out_date) AS out_date " +
        "FROM user_working " +
        "GROUP BY username, password";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            count++;

            Users_Working_pojo users = new Users_Working_pojo();
            users.setSerial(count);
            users.setUserName(rs.getString("username"));
            users.setPassWord(rs.getString("password"));
            users.setInTime(rs.getString("in_time"));
            users.setInDate(rs.getString("in_date"));
            users.setOutTime(rs.getString("out_time"));
            users.setOutDate(rs.getString("out_date"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
 public ObservableList<users_counttotal_pojo> users_count()throws Exception{
     
 
 ObservableList<users_counttotal_pojo> list = FXCollections.observableArrayList();
      
  String sql ="select username,password from pn_sign";
  int count= 0;

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            count++;
            
            users_counttotal_pojo demo = new users_counttotal_pojo();
            
            demo.setSerial(count);
            demo.setUsername(rs.getString("username"));
            demo.setPassword(rs.getString("password"));
          

            list.add(demo);
        }     
        
        return list;
}
 }
}


    

