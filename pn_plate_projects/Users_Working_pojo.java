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
public class Users_Working_pojo {
   
  private int Serial;
  private String UserName;
  private String PassWord;
  private String InTime;
  private String InDate;
  private String OutTime;
  private String OutDate;

    public Users_Working_pojo(int Serial, String UserName, String PassWord, String InTime, String InDate, String OutTime, String OutDate) {
        this.Serial = Serial;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.InTime = InTime;
        this.InDate = InDate;
        this.OutTime = OutTime;
        this.OutDate = OutDate;
    }

    public Users_Working_pojo() {
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

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String InTime) {
        this.InTime = InTime;
    }

    public String getInDate() {
        return InDate;
    }

    public void setInDate(String InDate) {
        this.InDate = InDate;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String OutTime) {
        this.OutTime = OutTime;
    }

    public String getOutDate() {
        return OutDate;
    }

    public void setOutDate(String OutDate) {
        this.OutDate = OutDate;
    }
  
  
}
