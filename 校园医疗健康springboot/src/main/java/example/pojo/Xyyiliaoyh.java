package example.pojo;

public class Xyyiliaoyh {
    private Integer id;

    private String username;

    private String password;

    private String xyyiliaoyhname;

    private String xyyiliaoyhsex;

    private String xyyiliaoyhage;

    private String xyyiliaoyhphone;

    private String xyyiliaoyhimg;

    private String college;
    private String xuehao;

    public String getXuehao() { return xuehao; }
    public void setXuehao(String xuehao) { this.xuehao = xuehao; }
    private String guominshi;

    public String getGuominshi() { return guominshi; }
    public void setGuominshi(String guominshi) { this.guominshi = guominshi; }



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

    public String getXyyiliaoyhname() {
        return xyyiliaoyhname;
    }

    public void setXyyiliaoyhname(String xyyiliaoyhname) {
        this.xyyiliaoyhname = xyyiliaoyhname == null ? null : xyyiliaoyhname.trim();
    }

    public String getXyyiliaoyhsex() {
        return xyyiliaoyhsex;
    }

    public void setXyyiliaoyhsex(String xyyiliaoyhsex) {
        this.xyyiliaoyhsex = xyyiliaoyhsex == null ? null : xyyiliaoyhsex.trim();
    }

    public String getXyyiliaoyhage() {
        return xyyiliaoyhage;
    }

    public void setXyyiliaoyhage(String xyyiliaoyhage) {
        this.xyyiliaoyhage = xyyiliaoyhage == null ? null : xyyiliaoyhage.trim();
    }

    public String getXyyiliaoyhphone() {
        return xyyiliaoyhphone;
    }

    public void setXyyiliaoyhphone(String xyyiliaoyhphone) {
        this.xyyiliaoyhphone = xyyiliaoyhphone == null ? null : xyyiliaoyhphone.trim();
    }

    public String getXyyiliaoyhimg() {
        return xyyiliaoyhimg;
    }

    public void setXyyiliaoyhimg(String xyyiliaoyhimg) {
        this.xyyiliaoyhimg = xyyiliaoyhimg == null ? null : xyyiliaoyhimg.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }
}