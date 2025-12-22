/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinot
 */
public class Databaces_paroperty {
    
    public void create()throws Exception{
    
          String query = "create table emp1(id int not null)";
            
            Class.forName(PN_Dao_Paroperty.driver);
            
            Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
            
            PreparedStatement ps =con.prepareStatement(query);
            
            boolean ans = ps.execute();
            
            if(ans){
            
                System.out.println("Create Table");
            }
            else{
            
                System.out.println("Table Not Create");
            
            }
    
    
    
    }
    
     public void insert(String f_name,String l_name ,long mob,String user_name,String pass,String cpass) throws Exception{
        
        Class.forName(PN_Dao_Paroperty.driver);
       
        Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
         PreparedStatement ps = con.prepareStatement("insert into pn_sign valuse(?,?,?,?,?)");
         
         ps.setString(1, f_name);
         ps.setString(2, l_name);
         ps.setLong(3, mob);
         ps.setString(4, user_name);
         ps.setString(5, pass);
         ps.setString(6, cpass);
        
         int num = ps.executeUpdate();
         
         if(num>0){
             
             System.out.println("Inserted");
            
         }
          
             else{
                    System.out.println("Not Inserted"); 
                     
                     } 
         
         
   }
     
     public void delete() throws Exception{
     
            
            Class.forName(PN_Dao_Paroperty.driver);
            
            Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
            
            PreparedStatement ps =con.prepareStatement("create from table_name");
            
            boolean ans = ps.execute();
            
            if(ans){
            
                System.out.println("Create Table");
            }
            else{
            
                System.out.println("Table Not Create");
            
            }
     
     }
     
     public void select(String name) throws Exception{
        
        Class.forName(PN_Dao_Paroperty.driver);
       
        Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
         PreparedStatement ps = con.prepareStatement("insert into pn_sign valuse(?)");
         
         ps.setString(1, name);
        
        
         int num = ps.executeUpdate();
         
         if(num>0){
             
             System.out.println("Inserted");
            
         }
          
             else{
                    System.out.println("Not Inserted"); 
                     
                     } 
     
     
     
     }
     
   
    
    
}
