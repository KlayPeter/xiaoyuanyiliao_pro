package example.pojo;

public class Xyggao {
    private Integer id;

    private String xytitle;

    private String xycontent;

    private String xyimg;

    private String xyaddtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXytitle() {
        return xytitle;
    }

    public void setXytitle(String xytitle) {
        this.xytitle = xytitle == null ? null : xytitle.trim();
    }

    public String getXycontent() {
        return xycontent;
    }

    public void setXycontent(String xycontent) {
        this.xycontent = xycontent == null ? null : xycontent.trim();
    }

    public String getXyimg() {
        return xyimg;
    }

    public void setXyimg(String xyimg) {
        this.xyimg = xyimg == null ? null : xyimg.trim();
    }

    public String getXyaddtime() {
        return xyaddtime;
    }

    public void setXyaddtime(String xyaddtime) {
        this.xyaddtime = xyaddtime == null ? null : xyaddtime.trim();
    }
}