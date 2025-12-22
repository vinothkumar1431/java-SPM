
package pn_plate_projects;

public class sign_Pojo {
    
  private String fname;
  private String lname;
  private String email;
  private long mob;

    public sign_Pojo(String fname, String lname, String email, long mob) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mob = mob;
    }

    public sign_Pojo() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMob() {
        return mob;
    }

    public void setMob(long mob) {
        this.mob = mob;
    }
  
  
  
    
}
