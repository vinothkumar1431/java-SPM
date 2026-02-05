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
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vinot
 */
public class User_full_Detials_Dao {
    
public ObservableList<Users_full_Detials_pojo> blockList() {

    int count = 1;

    ObservableList<Users_full_Detials_pojo> list = FXCollections.observableArrayList();

    String sql = "SELECT username, password, first_name, least_name, " +
                 "email, moblie_number, date, time FROM id_black";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Users_full_Detials_pojo users =
                    new Users_full_Detials_pojo();

            users.setSerial(count++); 
            users.setUserName(rs.getString("username"));
            users.setPassWord(rs.getString("password"));
            users.setFirstName(rs.getString("first_name"));   
            users.setLestName(rs.getString("least_name"));    
            users.setEmail(rs.getString("email"));
            users.setMobileNumber(rs.getLong("moblie_number"));
            users.setDate(rs.getString("date"));
            users.setTime(rs.getString("time"));

            list.add(users);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

public ObservableList<Users_full_Detials_pojo> UsersDetials() {

    int count = 1;

    ObservableList<Users_full_Detials_pojo> list = FXCollections.observableArrayList();

    String sql = "SELECT f_name, l_name, email, mob, username, password, date, time FROM pn_sign";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Users_full_Detials_pojo users = new Users_full_Detials_pojo();

            users.setSerial(count++); 
            users.setFirstName(rs.getString("f_name"));
            users.setLestName(rs.getString("l_name"));
            users.setEmail(rs.getString("email"));   
            users.setMobileNumber(rs.getLong("mob"));
            users.setUserName(rs.getString("username"));
            users.setPassWord(rs.getString("password"));    
            users.setDate(rs.getString("date"));
            users.setTime(rs.getString("time"));

            list.add(users);
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
public ObservableList<Users_full_Detials_pojo> DeleteingList() {

    int count = 1;

    ObservableList<Users_full_Detials_pojo> list = FXCollections.observableArrayList();

    String sql = "SELECT username, password, first_name, least_name, " +
                 "email, moblie_number, date, time FROM users_delete";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Users_full_Detials_pojo users =
                    new Users_full_Detials_pojo();

            users.setSerial(count++); 
            users.setUserName(rs.getString("username"));
            users.setPassWord(rs.getString("password"));
            users.setFirstName(rs.getString("first_name"));   
            users.setLestName(rs.getString("least_name"));    
            users.setEmail(rs.getString("email"));
            users.setMobileNumber(rs.getLong("moblie_number"));
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
   
