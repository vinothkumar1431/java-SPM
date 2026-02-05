package pn_plate_projects;

public class User_detials_pojo {

    private int serial;
    private String firstName;
    private String lestName;
    private String email;
    private long mobile;
    private String username;
    private String password;
    private String date;
    private String time;

    public User_detials_pojo(int serial, String firstName, String lestName, String email, long mobile, String username, String password, String date, String time) {
        this.serial = serial;
        this.firstName = firstName;
        this.lestName = lestName;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.date = date;
        this.time = time;
    }
    
    

    public User_detials_pojo() {
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLestName() {
        return lestName;
    }

    public void setLestName(String lestName) {
        this.lestName = lestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
