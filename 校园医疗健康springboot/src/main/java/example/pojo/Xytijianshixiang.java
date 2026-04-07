package example.pojo;

public class Xytijianshixiang {
    private Integer id;

    private String tijiant;

    private String tijiancontent;

    private String tijianzhuyi;

    private String tijianadress;

    private String tijiantime;

    private String tijianimg;

    private String xiaoyuanyisheng;

    private Integer xiaoyuanyishengid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTijiant() {
        return tijiant;
    }

    public void setTijiant(String tijiant) {
        this.tijiant = tijiant == null ? null : tijiant.trim();
    }

    public String getTijiancontent() {
        return tijiancontent;
    }

    public void setTijiancontent(String tijiancontent) {
        this.tijiancontent = tijiancontent == null ? null : tijiancontent.trim();
    }

    public String getTijianzhuyi() {
        return tijianzhuyi;
    }

    public void setTijianzhuyi(String tijianzhuyi) {
        this.tijianzhuyi = tijianzhuyi == null ? null : tijianzhuyi.trim();
    }

    public String getTijianadress() {
        return tijianadress;
    }

    public void setTijianadress(String tijianadress) {
        this.tijianadress = tijianadress == null ? null : tijianadress.trim();
    }

    public String getTijiantime() {
        return tijiantime;
    }

    public void setTijiantime(String tijiantime) {
        this.tijiantime = tijiantime == null ? null : tijiantime.trim();
    }

    public String getTijianimg() {
        return tijianimg;
    }

    public void setTijianimg(String tijianimg) {
        this.tijianimg = tijianimg == null ? null : tijianimg.trim();
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
}