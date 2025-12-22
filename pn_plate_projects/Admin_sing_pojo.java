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
public class Admin_sing_pojo {
    
    private String F_Name;
    private String L_Name;
    private String Email;
    private Long Mobile;
    private String U_name;
    private String Pass;
    private String C_pass;

    public Admin_sing_pojo(String F_Name, String L_Name, String Email, Long Mobile, String U_name, String Pass, String C_pass) {
        this.F_Name = F_Name;
        this.L_Name = L_Name;
        this.Email = Email;
        this.Mobile = Mobile;
        this.U_name = U_name;
        this.Pass = Pass;
        this.C_pass = C_pass;
    }

    public Admin_sing_pojo() {
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String F_Name) {
        this.F_Name = F_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String L_Name) {
        this.L_Name = L_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Long getMobile() {
        return Mobile;
    }

    public void setMobile(Long Mobile) {
        this.Mobile = Mobile;
    }

    public String getU_name() {
        return U_name;
    }

    public void setU_name(String U_name) {
        this.U_name = U_name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getC_pass() {
        return C_pass;
    }

    public void setC_pass(String C_pass) {
        this.C_pass = C_pass;
    }
    
    
    
}
