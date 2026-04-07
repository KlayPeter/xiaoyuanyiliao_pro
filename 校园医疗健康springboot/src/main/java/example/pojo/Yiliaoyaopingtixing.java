package example.pojo;

public class Yiliaoyaopingtixing {
    private Integer id;

    private String caigout;

    private String caigoucontent;

    private String addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaigout() {
        return caigout;
    }

    public void setCaigout(String caigout) {
        this.caigout = caigout == null ? null : caigout.trim();
    }

    public String getCaigoucontent() {
        return caigoucontent;
    }

    public void setCaigoucontent(String caigoucontent) {
        this.caigoucontent = caigoucontent == null ? null : caigoucontent.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}