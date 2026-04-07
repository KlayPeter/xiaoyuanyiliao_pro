package example.pojo;

public class Xiaoyuanyisheng {
    private Integer id;

    private String username;

    private String password;

    private String schoolyishengname;

    private String schoolyssex;

    private String schoolysage;

    private String schoolysphone;

    private String schoolysavaator;

    private String schoolysjianjie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSchoolyishengname() {
        return schoolyishengname;
    }

    public void setSchoolyishengname(String schoolyishengname) {
        this.schoolyishengname = schoolyishengname == null ? null : schoolyishengname.trim();
    }

    public String getSchoolyssex() {
        return schoolyssex;
    }

    public void setSchoolyssex(String schoolyssex) {
        this.schoolyssex = schoolyssex == null ? null : schoolyssex.trim();
    }

    public String getSchoolysage() {
        return schoolysage;
    }

    public void setSchoolysage(String schoolysage) {
        this.schoolysage = schoolysage == null ? null : schoolysage.trim();
    }

    public String getSchoolysphone() {
        return schoolysphone;
    }

    public void setSchoolysphone(String schoolysphone) {
        this.schoolysphone = schoolysphone == null ? null : schoolysphone.trim();
    }

    public String getSchoolysavaator() {
        return schoolysavaator;
    }

    public void setSchoolysavaator(String schoolysavaator) {
        this.schoolysavaator = schoolysavaator == null ? null : schoolysavaator.trim();
    }

    public String getSchoolysjianjie() {
        return schoolysjianjie;
    }

    public void setSchoolysjianjie(String schoolysjianjie) {
        this.schoolysjianjie = schoolysjianjie == null ? null : schoolysjianjie.trim();
    }
}