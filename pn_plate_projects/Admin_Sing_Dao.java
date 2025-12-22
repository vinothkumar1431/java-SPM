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
import java.time.Year;
import java.util.Locale;

/**
 *
 * @author vinot
 */


public class Admin_Sing_Dao {
    
 

    
    public void admin_sing(String f_name,String l_name ,String email,long mob,String u_name,String pass,String C_pass,String Admin) throws Exception{
        
       Class.forName(PN_Dao_Paroperty.driver);
       
      Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
      PreparedStatement ps = con.prepareStatement("insert into admin_data values(?,?,?,?,?,?,?,?)");
      
      ps.setString(1, f_name);
      ps.setString(2, l_name);
      ps.setString(3, email);
      ps.setLong(4, mob);
      ps.setString(5,u_name);
      ps.setString(6, pass);
      ps.setString(7, C_pass);
      ps.setString(8, Admin);
      
      int num = ps.executeUpdate();
      
      if(num>0){
          
//          int nextSequenceNumber = lastUsedSequenceNumber + 1;
//          
//          String prefix = "ADMIN";
//          
//          String currentYear = String.valueOf(Year.now()).substring(2);
//          
//          String sequence = String.format("%03d", nextSequenceNumber);
//          
//          adminId = prefix+"-"+currentYear+"-"+sequence;
//
//          System.out.println(adminId);
//          
          
           System.out.println("Inserted");
          
          
         }
      else{
     
  
        System.out.println("Not inserted");
     }
         
    }
//    public String generateAdminId() throws Exception {
//
//    Class.forName(PN_Dao_Paroperty.driver);
//
//    Connection con = DriverManager.getConnection(
//            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
//            PN_Dao_Paroperty.user,
//            PN_Dao_Paroperty.pass);
//
//    // LAST ADMIN ID FETCH
//    String getLastIdQuery = "SELECT admin_id FROM admin_data ORDER BY admin_id DESC LIMIT 1";
//    PreparedStatement psLast = con.prepareStatement(getLastIdQuery);
//    ResultSet rs = psLast.executeQuery();   // ✔ FIXED
//
//    int lastSeq = 0;
//
//    if (rs.next()) {
//        String lastId = rs.getString(1); // Example: ADMIN-25-051
//        String[] parts = lastId.split("-"); 
//        lastSeq = Integer.parseInt(parts[2]);  // 51
//    }
//
//    // NEXT SEQUENCE
//    int nextSequenceNumber = lastSeq + 1;
//
//    String prefix = "ADMIN";
//    String year = String.valueOf(Year.now()).substring(2);
//    String sequence = String.format("%03d", nextSequenceNumber);
//
//    // READY ID
//     adminId = prefix + "-" + year + "-" + sequence;
//    
//            System.out.println(adminId);
//
//
//    return null;
//    
//}
    
    public String admin_create() throws Exception{
        
      Class.forName(PN_Dao_Paroperty.driver);
       
      Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
      PreparedStatement ps = con.prepareStatement("insert into admin_data values()");
 ;
      
      int num = ps.executeUpdate();
      
      if(num>0){ 
    
    
      }
    
           return null;
    }
}




         
     



    

