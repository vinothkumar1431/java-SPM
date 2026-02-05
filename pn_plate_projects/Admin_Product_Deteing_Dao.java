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
public class Admin_Product_Deteing_Dao {
    
    public ObservableList<Admin_Product_Deteing_pojo> Admin_Product_Deteals() {

    ObservableList<Admin_Product_Deteing_pojo> list = FXCollections.observableArrayList();

    int count = 0;

String sql = "SELECT product_name, model, size, price, discount,opening_stock,date,time " +
             "FROM product_insert " ;

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            count++;

            Admin_Product_Deteing_pojo users = new Admin_Product_Deteing_pojo();

            users.setSerial(count);
            users.setProductName(rs.getString("product_name"));
            users.setPriductModel(rs.getString("model"));
            users.setProductSize(rs.getString("size"));
            users.setPrice(rs.getDouble("price"));
            users.setDiscount(rs.getDouble("discount"));
            users.setOpeningStock(rs.getInt("opening_stock"));
            users.setDate(rs.getString("date"));
            users.setTime(rs.getString("time"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
 
    
    public ObservableList<Admin_Product_Deteing_pojo> Admin_Product_BlockDetials() {

    ObservableList<Admin_Product_Deteing_pojo> list = FXCollections.observableArrayList();

    int count = 0;

String sql = "SELECT Productname, model, size, price, discount,openingstock,date,time " +
             "FROM product_blocks " ;

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            count++;

            Admin_Product_Deteing_pojo users = new Admin_Product_Deteing_pojo();

            users.setSerial(count);
            users.setProductName(rs.getString("Productname"));
            users.setPriductModel(rs.getString("model"));
            users.setProductSize(rs.getString("size"));
            users.setPrice(rs.getDouble("price"));
            users.setDiscount(rs.getDouble("discount"));
            users.setOpeningStock(rs.getInt("openingstock"));
            users.setDate(rs.getString("date"));
            users.setTime(rs.getString("time"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
    
  public ObservableList<Admin_Product_Deteing_pojo> Admin_Product_DeleteingDetials() {

    ObservableList<Admin_Product_Deteing_pojo> list = FXCollections.observableArrayList();

    int count = 0;

String sql = "SELECT Productname, model, size, price, discount,openingstock,date,time " +
             "FROM product_deleteing " ;

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            count++;

            Admin_Product_Deteing_pojo users = new Admin_Product_Deteing_pojo();

            users.setSerial(count);
            users.setProductName(rs.getString("Productname"));
            users.setPriductModel(rs.getString("model"));
            users.setProductSize(rs.getString("size"));
            users.setPrice(rs.getDouble("price"));
            users.setDiscount(rs.getDouble("discount"));
            users.setOpeningStock(rs.getInt("openingstock"));
            users.setDate(rs.getString("date"));
            users.setTime(rs.getString("time"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}   
  
}
   

