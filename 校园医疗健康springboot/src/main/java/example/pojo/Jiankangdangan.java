package example.pojo;

public class Jiankangdangan {
    private Integer id;

    private String shijian;

    private String height;

    private String weight;

    private String bmi;

    private String zuoyanshili;

    private String youyanshili;

    private String feihuoliang;

    private String lidingtiaoyuan;

    private String yibaimi;

    private String xyyiliaoyh;

    private Integer xyyiliaoyhid;


    private String zongfen;
    private String zuoweitiqianqu;
    private String yintixiangshang;
    private String wushimi;
    private String yiqianmi;

    public String getZongfen(){return zongfen;}
    public void setZongfen(String zongfen){this.zongfen=zongfen;}
    public String getZuoweitiqianqu(){return zuoweitiqianqu;}
    public void setZuoweitiqianqu(String zongfen){this.zuoweitiqianqu=zongfen;}
    public String getYintixiangshang(){return yintixiangshang;}
    public void setYintixiangshang(String zongfen){this.yintixiangshang=zongfen;}
    public String getWushimi(){return wushimi;}
    public void setWushimi(String z){this.wushimi=z;}
    public String getYiqianmi(){return yiqianmi;}
    public void setYiqianmi(String z){this.yiqianmi=z;}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian == null ? null : shijian.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi == null ? null : bmi.trim();
    }

    public String getZuoyanshili() {
        return zuoyanshili;
    }

    public void setZuoyanshili(String zuoyanshili) {
        this.zuoyanshili = zuoyanshili == null ? null : zuoyanshili.trim();
    }

    public String getYouyanshili() {
        return youyanshili;
    }

    public void setYouyanshili(String youyanshili) {
        this.youyanshili = youyanshili == null ? null : youyanshili.trim();
    }

    public String getFeihuoliang() {
        return feihuoliang;
    }

    public void setFeihuoliang(String feihuoliang) {
        this.feihuoliang = feihuoliang == null ? null : feihuoliang.trim();
    }

    public String getLidingtiaoyuan() {
        return lidingtiaoyuan;
    }

    public void setLidingtiaoyuan(String lidingtiaoyuan) {
        this.lidingtiaoyuan = lidingtiaoyuan == null ? null : lidingtiaoyuan.trim();
    }

    public String getYibaimi() {
        return yibaimi;
    }

    public void setYibaimi(String yibaimi) {
        this.yibaimi = yibaimi == null ? null : yibaimi.trim();
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
}