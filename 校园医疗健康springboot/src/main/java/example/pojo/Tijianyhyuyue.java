package example.pojo;

public class Tijianyhyuyue {
    private Integer id;

    private String xytijianshixiang;

    private Integer xytijianshixiangid;

    private String xyyiliaoyh;

    private Integer xyyiliaoyhid;

    private String address;

    private String shijian;

    private String img;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXytijianshixiang() {
        return xytijianshixiang;
    }

    public void setXytijianshixiang(String xytijianshixiang) {
        this.xytijianshixiang = xytijianshixiang == null ? null : xytijianshixiang.trim();
    }

    public Integer getXytijianshixiangid() {
        return xytijianshixiangid;
    }

    public void setXytijianshixiangid(Integer xytijianshixiangid) {
        this.xytijianshixiangid = xytijianshixiangid;
    }

    public String getXyyiliaoyh() {
        return xyyiliaoyh;
    }

    public void setXyyiliaoyh(String xyyiliaoyh) {
        this.xyyiliaoyh = xyyiliaoyh == null ? null : xyyiliaoyh.trim();
    }

    public Integer getXyyiliaoyhid() {
        return xyyiliaoyhid;
    }

    public void setXyyiliaoyhid(Integer xyyiliaoyhid) {
        this.xyyiliaoyhid = xyyiliaoyhid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian == null ? null : shijian.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}