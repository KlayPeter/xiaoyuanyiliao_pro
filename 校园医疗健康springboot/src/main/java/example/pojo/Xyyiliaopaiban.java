package example.pojo;

public class Xyyiliaopaiban {
    private Integer id;

    private String yuefen;

    private String xiaoyuanyisheng;

    private Integer xiaoyuanyishengid;

    private String remark;

    private String chuangjiantime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYuefen() {
        return yuefen;
    }

    public void setYuefen(String yuefen) {
        this.yuefen = yuefen == null ? null : yuefen.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getChuangjiantime() {
        return chuangjiantime;
    }

    public void setChuangjiantime(String chuangjiantime) {
        this.chuangjiantime = chuangjiantime == null ? null : chuangjiantime.trim();
    }
}