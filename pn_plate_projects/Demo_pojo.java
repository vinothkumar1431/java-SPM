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
public class Demo_pojo {
    
    private String username;
    
    private String userpass;

    public Demo_pojo(String username, String userpass) {
        this.username = username;
        this.userpass = userpass;
    }

    public Demo_pojo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    
    
    
}
