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
public class Admin_pojo {
    
    private String U_name;
    private String P_word;
    private String Admin;

    public Admin_pojo(String U_name, String P_word, String Admin) {
        this.U_name = U_name;
        this.P_word = P_word;
        this.Admin = Admin;
    }

    public Admin_pojo() {
    }

    public String getU_name() {
        return U_name;
    }

    public void setU_name(String U_name) {
        this.U_name = U_name;
    }

    public String getP_word() {
        return P_word;
    }

    public void setP_word(String P_word) {
        this.P_word = P_word;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }
    
    
    
}
