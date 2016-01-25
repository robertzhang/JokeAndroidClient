package cn.robertzhang.joke.model.entities.one;

/**
 * Created by robertzhang on 16/1/24.
 * email: robertzhangsh@gmail.com
 */
public class Home {

    /**
     * strLastUpdateDate : 2016-01-12 17:18:06
     * strDayDiffer :
     * strHpId : 1222
     * strHpTitle : VOL.1201
     * strThumbnailUrl : http://image.wufazhuce.com/FrI0HJi0nofr1kXIv_u7SF0IJXVm
     * strOriginalImgUrl : http://image.wufazhuce.com/FrI0HJi0nofr1kXIv_u7SF0IJXVm
     * strAuthor : 现世安好—dfg&邱丹丹 作品
     * strContent : 青春期的小姑娘对于爱情幻想的太满，往往因为得到的太寥寥而攒下失望。但是我从未后悔。直到现在我也觉得那些我日复一日写的关于他的日记，牵手时的汗滴，拥抱过后的别离，都是青春给我为数不多的糖。 by 山支
     * strMarketTime : 2016-01-21
     * sWebLk : http://m.wufazhuce.com/one/2016-01-21
     * strPn : 23438
     * wImgUrl :
     */

    private Long id;
    private String strLastUpdateDate;
    private String strDayDiffer;
    private String strHpId;
    private String strHpTitle;
    private String strThumbnailUrl;
    private String strOriginalImgUrl;
    private String strAuthor;
    private String strContent;
    private String strMarketTime;
    private String sWebLk;
    private String strPn;
    private String wImgUrl;

    public Home() {
    }

    public Home(Long id) {
        this.id = id;
    }

    public Home(Long id, String strLastUpdateDate, String strDayDiffer, String strHpId, String strHpTitle, String strThumbnailUrl, String strOriginalImgUrl, String strAuthor, String strContent, String strMarketTime, String sWebLk, String strPn, String wImgUrl) {
        this.id = id;
        this.strLastUpdateDate = strLastUpdateDate;
        this.strDayDiffer = strDayDiffer;
        this.strHpId = strHpId;
        this.strHpTitle = strHpTitle;
        this.strThumbnailUrl = strThumbnailUrl;
        this.strOriginalImgUrl = strOriginalImgUrl;
        this.strAuthor = strAuthor;
        this.strContent = strContent;
        this.strMarketTime = strMarketTime;
        this.sWebLk = sWebLk;
        this.strPn = strPn;
        this.wImgUrl = wImgUrl;
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

    public String getStrDayDiffer() {
        return strDayDiffer;
    }

    public void setStrDayDiffer(String strDayDiffer) {
        this.strDayDiffer = strDayDiffer;
    }

    public String getStrHpId() {
        return strHpId;
    }

    public void setStrHpId(String strHpId) {
        this.strHpId = strHpId;
    }

    public String getStrHpTitle() {
        return strHpTitle;
    }

    public void setStrHpTitle(String strHpTitle) {
        this.strHpTitle = strHpTitle;
    }

    public String getStrThumbnailUrl() {
        return strThumbnailUrl;
    }

    public void setStrThumbnailUrl(String strThumbnailUrl) {
        this.strThumbnailUrl = strThumbnailUrl;
    }

    public String getStrOriginalImgUrl() {
        return strOriginalImgUrl;
    }

    public void setStrOriginalImgUrl(String strOriginalImgUrl) {
        this.strOriginalImgUrl = strOriginalImgUrl;
    }

    public String getStrAuthor() {
        return strAuthor;
    }

    public void setStrAuthor(String strAuthor) {
        this.strAuthor = strAuthor;
    }

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }

    public String getStrMarketTime() {
        return strMarketTime;
    }

    public void setStrMarketTime(String strMarketTime) {
        this.strMarketTime = strMarketTime;
    }

    public String getSWebLk() {
        return sWebLk;
    }

    public void setSWebLk(String sWebLk) {
        this.sWebLk = sWebLk;
    }

    public String getStrPn() {
        return strPn;
    }

    public void setStrPn(String strPn) {
        this.strPn = strPn;
    }

    public String getWImgUrl() {
        return wImgUrl;
    }

    public void setWImgUrl(String wImgUrl) {
        this.wImgUrl = wImgUrl;
    }


}

