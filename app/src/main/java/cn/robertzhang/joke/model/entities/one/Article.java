package cn.robertzhang.joke.model.entities.one;

/**
 * Created by robertzhang on 16/1/24.
 * email: robertzhangsh@gmail.com
 */
public class Article {

    /**
     * strLastUpdateDate : 2016-01-14 22:45:47
     * strContent :
     * sWebLk : http://m.wufazhuce.com/article/2016-01-15
     * wImgUrl : http://image.wufazhuce.com/Fuv3BabyCJEsUMQWOueIZp9Gzr9u
     * sRdNum : 366884
     * strPraiseNumber : 13113
     * strContDayDiffer :
     * strContentId : 1282
     * strContTitle : 鍒嗘墜淇�
     * strContAuthor : 鐜嬩箤涔�
     * strContAuthorIntroduce : 锛堣矗浠荤紪杈戯細鍗ぉ鎴愶級
     * strContMarketTime : 2016-01-15
     * sGW : 浜轰滑鎬诲枩娆㈣鐖辨儏鍦ㄧ幇瀹為潰鍓嶈剢寮卞緱涓嶅牚涓€鍑伙紝浣嗗湪閭ｄ竴鍒绘垜绐佺劧鎰忚瘑鍒板叾瀹炰笉鏄埍鎯呰剢寮憋紝鐖辨儏寰堝
     * sAuth : 鐜嬩箤涔岋紝闈掑勾浣滆€呫€�
     * sWbN : @鐜嬩箤涔屽湪瓒婄嫳
     * subTitle :
     */

    private Long id;
    private String strLastUpdateDate;
    private String strContent;
    private String sWebLk;
    private String wImgUrl;
    private String sRdNum;
    private String strPraiseNumber;
    private String strContDayDiffer;
    private String strContentId;
    private String strContTitle;
    private String strContAuthor;
    private String strContAuthorIntroduce;
    private String strContMarketTime;
    private String sGW;
    private String sAuth;
    private String sWbN;
    private String subTitle;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(Long id, String strLastUpdateDate, String strContent, String sWebLk, String wImgUrl, String sRdNum, String strPraiseNumber, String strContDayDiffer, String strContentId, String strContTitle, String strContAuthor, String strContAuthorIntroduce, String strContMarketTime, String sGW, String sAuth, String sWbN, String subTitle) {
        this.id = id;
        this.strLastUpdateDate = strLastUpdateDate;
        this.strContent = strContent;
        this.sWebLk = sWebLk;
        this.wImgUrl = wImgUrl;
        this.sRdNum = sRdNum;
        this.strPraiseNumber = strPraiseNumber;
        this.strContDayDiffer = strContDayDiffer;
        this.strContentId = strContentId;
        this.strContTitle = strContTitle;
        this.strContAuthor = strContAuthor;
        this.strContAuthorIntroduce = strContAuthorIntroduce;
        this.strContMarketTime = strContMarketTime;
        this.sGW = sGW;
        this.sAuth = sAuth;
        this.sWbN = sWbN;
        this.subTitle = subTitle;
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

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }

    public String getSWebLk() {
        return sWebLk;
    }

    public void setSWebLk(String sWebLk) {
        this.sWebLk = sWebLk;
    }

    public String getWImgUrl() {
        return wImgUrl;
    }

    public void setWImgUrl(String wImgUrl) {
        this.wImgUrl = wImgUrl;
    }

    public String getSRdNum() {
        return sRdNum;
    }

    public void setSRdNum(String sRdNum) {
        this.sRdNum = sRdNum;
    }

    public String getStrPraiseNumber() {
        return strPraiseNumber;
    }

    public void setStrPraiseNumber(String strPraiseNumber) {
        this.strPraiseNumber = strPraiseNumber;
    }

    public String getStrContDayDiffer() {
        return strContDayDiffer;
    }

    public void setStrContDayDiffer(String strContDayDiffer) {
        this.strContDayDiffer = strContDayDiffer;
    }

    public String getStrContentId() {
        return strContentId;
    }

    public void setStrContentId(String strContentId) {
        this.strContentId = strContentId;
    }

    public String getStrContTitle() {
        return strContTitle;
    }

    public void setStrContTitle(String strContTitle) {
        this.strContTitle = strContTitle;
    }

    public String getStrContAuthor() {
        return strContAuthor;
    }

    public void setStrContAuthor(String strContAuthor) {
        this.strContAuthor = strContAuthor;
    }

    public String getStrContAuthorIntroduce() {
        return strContAuthorIntroduce;
    }

    public void setStrContAuthorIntroduce(String strContAuthorIntroduce) {
        this.strContAuthorIntroduce = strContAuthorIntroduce;
    }

    public String getStrContMarketTime() {
        return strContMarketTime;
    }

    public void setStrContMarketTime(String strContMarketTime) {
        this.strContMarketTime = strContMarketTime;
    }

    public String getSGW() {
        return sGW;
    }

    public void setSGW(String sGW) {
        this.sGW = sGW;
    }

    public String getSAuth() {
        return sAuth;
    }

    public void setSAuth(String sAuth) {
        this.sAuth = sAuth;
    }

    public String getSWbN() {
        return sWbN;
    }

    public void setSWbN(String sWbN) {
        this.sWbN = sWbN;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

}
