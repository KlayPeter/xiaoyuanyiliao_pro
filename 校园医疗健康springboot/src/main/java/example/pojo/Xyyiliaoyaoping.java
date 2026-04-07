package example.pojo;

public class Xyyiliaoyaoping {
    private Integer id;

    private String drugname;

    private String shengchanchangjia;

    private String danwei;

    private String yaopingfenlei;

    private String kucun;

    private String price;

    private String tixingkucun;

    private String shuoming;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname == null ? null : drugname.trim();
    }

    public String getShengchanchangjia() {
        return shengchanchangjia;
    }

    public void setShengchanchangjia(String shengchanchangjia) {
        this.shengchanchangjia = shengchanchangjia == null ? null : shengchanchangjia.trim();
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei == null ? null : danwei.trim();
    }

    public String getYaopingfenlei() {
        return yaopingfenlei;
    }

    public void setYaopingfenlei(String yaopingfenlei) {
        this.yaopingfenlei = yaopingfenlei == null ? null : yaopingfenlei.trim();
    }

    public String getKucun() {
        return kucun;
    }

    public void setKucun(String kucun) {
        this.kucun = kucun == null ? null : kucun.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTixingkucun() {
        return tixingkucun;
    }

    public void setTixingkucun(String tixingkucun) {
        this.tixingkucun = tixingkucun == null ? null : tixingkucun.trim();
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming == null ? null : shuoming.trim();
    }
}