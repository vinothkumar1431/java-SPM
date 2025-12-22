
package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class User_Dao {
    
     public void save(String Usname,String pass,String conpass) throws Exception{
        
       Class.forName(PN_Dao_Paroperty.driver);
       
      Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
      PreparedStatement ps = con.prepareStatement("insert into users_pass values(?,?,?)");
      
      ps.setString(1, Usname);
      ps.setString(2, pass);
      ps.setString(3, conpass);
      
      int num = ps.executeUpdate();
      
      if(num>0){
      
          System.out.println("inserted");
      
      }
      else{
      
          System.out.println("Not inserted");
      }
     } 
    
}
