
package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class sign_Dao {
    
     public void next(String f_name,String l_name ,String email,long mob) throws Exception{
        
       Class.forName(PN_Dao_Paroperty.driver);
       
      Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
      PreparedStatement ps = con.prepareStatement("insert into pn_sign values(?,?,?,?)");
      
      ps.setString(1, f_name);
      ps.setString(2, l_name);
      ps.setString(3, email);
      ps.setLong(4, mob);
      
      int num = ps.executeUpdate();
      
      if(num>0){
          BtController obj =new BtController();
          
          obj.nextPage1();
      }
      else{
     
          System.out.println("Not inserted");
     }
         
     }  
}
