package example.pojo;

public class Yuyuepingjia {
    private Integer id;

    private String xyyiliaopaibanyuyue;

    private Integer xyyiliaopaibanyuyueid;

    private String pingcontent;

    private String type;

    private String xyyiliaoyh;

    private Integer xyyiliaoyhid;

    private String pingjiashijian;

    private String xiaoyuanyisheng;

    private Integer xiaoyuanyishengid;

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

    public String getPingcontent() {
        return pingcontent;
    }

    public void setPingcontent(String pingcontent) {
        this.pingcontent = pingcontent == null ? null : pingcontent.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getPingjiashijian() {
        return pingjiashijian;
    }

    public void setPingjiashijian(String pingjiashijian) {
        this.pingjiashijian = pingjiashijian == null ? null : pingjiashijian.trim();
    }

    public String getXiaoyuanyisheng() {
        return xiaoyuanyisheng;
    }

    public void setXiaoyuanyisheng(String xiaoyuanyisheng) {
        this.xiaoyuanyisheng = xiaoyuanyisheng == null ? null : xiaoyuanyisheng.trim();
    }

    public Integer getXiaoyuanyishengid() {
        return xiaoyuanyishengid;
    }

    public void setXiaoyuanyishengid(Integer xiaoyuanyishengid) {
        this.xiaoyuanyishengid = xiaoyuanyishengid;
    }

    private String pingjiafenshu;

    public String getPingjiafenshu() {
        return pingjiafenshu;
    }

    public void setPingjiafenshu(String pingjiafenshu) {
        this.pingjiafenshu = pingjiafenshu == null ? null : pingjiafenshu.trim();
    }
}