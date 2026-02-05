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
public class Full_detials_pojo {
    
    private String UserName;
    private String PassWord;
    private String FirstName;
    private String LastName;
    private String Email;
    private long MobileNumber;
    private String Date;
    private String Time;

    public Full_detials_pojo(String UserName, String PassWord, String FirstName, String LastName, String Email, long MobileNumber, String Date, String Time) {
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.MobileNumber = MobileNumber;
        this.Date = Date;
        this.Time = Time;
    }

    public Full_detials_pojo() {
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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(long MobileNumber) {
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
