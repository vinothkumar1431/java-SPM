/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pn_plate_projects;

/**
 *
 * @author vinot
 */
public class Users_full_Detials_pojo {
    
    private int Serial;
    private String UserName;
    private String PassWord;
    private String FirstName;
    private String LestName;
    private String Email;
    private Long MobileNumber;
    private String Date;
    private String Time;

    public Users_full_Detials_pojo(int serial , String UserName, String PassWord, String FirstName, String LestName, String Email, Long MobileNumber, String Date, String Time) {
        
        this.Serial = serial;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.FirstName = FirstName;
        this.LestName = LestName;
        this.Email = Email;
        this.MobileNumber = MobileNumber;
        this.Date = Date;
        this.Time = Time;
    }

    public Users_full_Detials_pojo() {
    }
    
     public int getSerial() {
        return Serial;
    }

    public void setSerial(int Serial) {
        this.Serial = Serial;
    }
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLestName() {
        return LestName;
    }

    public void setLestName(String LestName) {
        this.LestName = LestName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(Long MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    
    
}
