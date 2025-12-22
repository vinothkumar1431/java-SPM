
package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class PN_Dao {
    

       
    
   public PN_Pojo login(String uname,String upass) throws Exception{
       
       Class.forName(PN_Dao_Paroperty.driver);
       
       Connection con = DriverManager.getConnection(PN_Dao_Paroperty.url+PN_Dao_Paroperty.db,PN_Dao_Paroperty.user,PN_Dao_Paroperty.pass);
       
       PreparedStatement ps = con.prepareStatement("select username,password from users_pass  where  username=? and password=?");
       
       ps.setString(1, uname);
       ps.setString(2, upass);
       
       ResultSet rs = ps.executeQuery();
       
       
       PN_Pojo obj = new PN_Pojo();
       
       Demo_pojo obj1 =new Demo_pojo();
       
       
       
       String name ="";
       String pass1="";
       

       while(rs.next()){
              
          name = rs.getString(1);
          pass1 = rs.getString(2);
          
       }
       
       if(name.equals(uname)){
       
       if(pass1.equals(upass)){
       
         obj.setUname(name);
         obj.setPass(pass1);

         PNController pnc =new PNController();
         
         pnc.nextPage();
       
       }  
        else{
         errorpassword();
       }
       }
       else{
          errorusername();
           }
   /*   if(name.equals(uname) && pass1.equals(upass)){
         
         obj.setUname(name);
         obj.setPass(pass1);

         PNController pnc =new PNController();
         
         pnc.nextPage();
      }
      else{
              
        Alert alert =new Alert(Alert.AlertType.ERROR);
        
        alert.setTitle("Alert!");
        
        alert.setContentText("This is an aalert");
        
        Optional<ButtonType>result = alert.showAndWait();
        
       if (result.isPresent()) {
           
    if (result.get() == ButtonType.OK) {
        
        System.out.println("OK clicked!");
        
    } else if (result.get() == ButtonType.CANCEL) {
        
        System.out.println("Cancel clicked!");
        
    } else {
        
        System.out.println("Alert closed without button!");
    }
}
    

     
   }*/
      
       
   
  
return obj;  
   }
   public void errorusername(){
 
 Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Password Alert!");
alert.setContentText("❌Invalid username!");

alert.getDialogPane().setStyle(
        
 "-fx-background-color: linear-gradient(to bottom, #0078D7, #005A9E);" +  // Gradient blue
"-fx-text-fill: white;" +
"-fx-font-weight: bold;" +
"-fx-font-size: 15px;" +
"-fx-font-family: 'Segoe UI Semibold';" +  // Professional system font
"-fx-background-radius: 8;" +
"-fx-padding: 8 18 8 18;" +
"-fx-cursor: hand;" +
"-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 3, 0, 0, 1);" +
"-fx-border-color: transparent;" +
"-fx-border-radius: 8;"   
    /* "-fx-background-color: #0078D7;" +       // Microsoft blue tone
    "-fx-text-fill: white;" +
    "-fx-font-weight: bold;" +
    "-fx-background-radius: 6;" +
    "-fx-cursor: hand;"   */
);
alert.showAndWait();
 
 }
 public void errorpassword(){
 
 Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Password Alert!");
alert.setContentText("Invalid password!");

alert.getDialogPane().setStyle(
        
"-fx-background-color: linear-gradient(to bottom, #0078D7, #005A9E);" +  // Gradient blue
"-fx-text-fill: white;" +
"-fx-font-weight: bold;" +
"-fx-font-size: 15px;" +
"-fx-font-family: 'Segoe UI Semibold';" +  // Professional system font
"-fx-background-radius: 8;" +
"-fx-padding: 8 18 8 18;" +
"-fx-cursor: hand;" +
"-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 3, 0, 0, 1);" +
"-fx-border-color: transparent;" +
"-fx-border-radius: 8;"      
   /* "-fx-background-color: #ffe6e6;" +
    "-fx-border-color: red;" +
    "-fx-border-width: 2px;" + 
    "-fx-font-size: 14px;" +
    "-fx-font-family: 'Latha';" +
    "-fx-text-fill: #b30000;"*/
);
alert.showAndWait();
 
 }  
       }
   
   
    
   
