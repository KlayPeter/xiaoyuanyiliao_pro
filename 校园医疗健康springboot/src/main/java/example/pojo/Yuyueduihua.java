package example.pojo;

public class Yuyueduihua {
    private Integer id;

    private String xyyiliaopaibanyuyue;

    private Integer xyyiliaopaibanyuyueid;

    private String message;

    private String duihuauser;

    private Integer duihuauserid;

    private String duihuauserrole;

    private String duihuauserimg;

    private String duihuauseraddtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXyyiliaopaibanyuyue() {
        return xyyiliaopaibanyuyue;
    }

    public void setXyyiliaopaibanyuyue(String xyyiliaopaibanyuyue) {
        this.xyyiliaopaibanyuyue = xyyiliaopaibanyuyue == null ? null : xyyiliaopaibanyuyue.trim();
    }

    public Integer getXyyiliaopaibanyuyueid() {
        return xyyiliaopaibanyuyueid;
    }

    public void setXyyiliaopaibanyuyueid(Integer xyyiliaopaibanyuyueid) {
        this.xyyiliaopaibanyuyueid = xyyiliaopaibanyuyueid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getDuihuauser() {
        return duihuauser;
    }

    public void setDuihuauser(String duihuauser) {
        this.duihuauser = duihuauser == null ? null : duihuauser.trim();
    }

    public Integer getDuihuauserid() {
        return duihuauserid;
    }

    public void setDuihuauserid(Integer duihuauserid) {
        this.duihuauserid = duihuauserid;
    }

    public String getDuihuauserrole() {
        return duihuauserrole;
    }

    public void setDuihuauserrole(String duihuauserrole) {
        this.duihuauserrole = duihuauserrole == null ? null : duihuauserrole.trim();
    }

    public String getDuihuauserimg() {
        return duihuauserimg;
    }

    public void setDuihuauserimg(String duihuauserimg) {
        this.duihuauserimg = duihuauserimg == null ? null : duihuauserimg.trim();
    }

    public String getDuihuauseraddtime() {
        return duihuauseraddtime;
    }

    public void setDuihuauseraddtime(String duihuauseraddtime) {
        this.duihuauseraddtime = duihuauseraddtime == null ? null : duihuauseraddtime.trim();
    }
}