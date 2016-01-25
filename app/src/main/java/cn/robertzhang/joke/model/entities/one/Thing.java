package cn.robertzhang.joke.model.entities.one;

/**
 * Created by robertzhang on 16/1/24.
 * email: robertzhangsh@gmail.com
 */
public class Thing {

    /**
     * strLastUpdateDate : 2016-01-20 13:10:42
     * strPn : 0
     * strBu : http://pic.yupoo.com/hanapp/FgytKYlm/QJV6.jpg
     * strTm : 2016-01-24
     * strWu : http://m.wufazhuce.com/thing/2016-01-24
     * strId : 749
     * strTt : 破花瓶中的Fairy Garden
     * strTc : 破碎的花瓶里也有春天。
     */

    private Long id;
    private String strLastUpdateDate;
    private String strPn;
    private String strBu;
    private String strTm;
    private String strWu;
    private String strId;
    private String strTt;
    private String strTc;

    public Thing() {
    }

    public Thing(Long id) {
        this.id = id;
    }

    public Thing(Long id, String strLastUpdateDate, String strPn, String strBu, String strTm, String strWu, String strId, String strTt, String strTc) {
        this.id = id;
        this.strLastUpdateDate = strLastUpdateDate;
        this.strPn = strPn;
        this.strBu = strBu;
        this.strTm = strTm;
        this.strWu = strWu;
        this.strId = strId;
        this.strTt = strTt;
        this.strTc = strTc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrLastUpdateDate() {
        return strLastUpdateDate;
    }

    public void setStrLastUpdateDate(String strLastUpdateDate) {
        this.strLastUpdateDate = strLastUpdateDate;
    }

    public String getStrPn() {
        return strPn;
    }

    public void setStrPn(String strPn) {
        this.strPn = strPn;
    }

    public String getStrBu() {
        return strBu;
    }

    public void setStrBu(String strBu) {
        this.strBu = strBu;
    }

    public String getStrTm() {
        return strTm;
    }

    public void setStrTm(String strTm) {
        this.strTm = strTm;
    }

    public String getStrWu() {
        return strWu;
    }

    public void setStrWu(String strWu) {
        this.strWu = strWu;
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    public String getStrTt() {
        return strTt;
    }

    public void setStrTt(String strTt) {
        this.strTt = strTt;
    }

    public String getStrTc() {
        return strTc;
    }

    public void setStrTc(String strTc) {
        this.strTc = strTc;
    }

}
