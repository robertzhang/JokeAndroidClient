package cn.robertzhang.joke.model.entities.one;

/**
 * Created by robertzhang on 16/1/24.
 * email: robertzhangsh@gmail.com
 */
public class Question {

    /**
     * entQNCmt : {"strId":"","strD":"","strCnt":"","pNum":"","upFg":""}
     * strLastUpdateDate : 2016-01-24 00:02:22
     * strDayDiffer :
     * sWebLk : http://m.wufazhuce.com/question/2016-01-15
     * strPraiseNumber : 8963
     * strQuestionId : 1226
     * strQuestionTitle : 濂冲悓瀛﹀浣曞洖搴斿勾杞诲皬浼欏じ寮犵殑绀虹埍姣旇緝濂斤紵
     * strQuestionContent : 鎴愪簡鏃佽鑰呬滑鐨勭瑧鏌勶紝杩欏彲鎬庝箞鍔炲憖锛�
     * strAnswerTitle : @钄¤瑕佽涓嶅悆鑽� 绛旀尝鍏版柉濂筹細
     * strAnswerContent : 鐪嬪埌杩欎釜闂
     * strQuestionMarketTime : 2016-01-15
     * sEditor : 锛堣矗浠荤紪杈戯細濂借阿缈旓級
     */

    private Long id;
    private String strLastUpdateDate;
    private String strDayDiffer;
    private String sWebLk;
    private String strPraiseNumber;
    private String strQuestionId;
    private String strQuestionTitle;
    private String strQuestionContent;
    private String strAnswerTitle;
    private String strAnswerContent;
    private String strQuestionMarketTime;
    private String sEditor;

    public Question() {
    }

    public Question(Long id) {
        this.id = id;
    }

    public Question(Long id, String strLastUpdateDate, String strDayDiffer, String sWebLk, String strPraiseNumber, String strQuestionId, String strQuestionTitle, String strQuestionContent, String strAnswerTitle, String strAnswerContent, String strQuestionMarketTime, String sEditor) {
        this.id = id;
        this.strLastUpdateDate = strLastUpdateDate;
        this.strDayDiffer = strDayDiffer;
        this.sWebLk = sWebLk;
        this.strPraiseNumber = strPraiseNumber;
        this.strQuestionId = strQuestionId;
        this.strQuestionTitle = strQuestionTitle;
        this.strQuestionContent = strQuestionContent;
        this.strAnswerTitle = strAnswerTitle;
        this.strAnswerContent = strAnswerContent;
        this.strQuestionMarketTime = strQuestionMarketTime;
        this.sEditor = sEditor;
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

    public String getSWebLk() {
        return sWebLk;
    }

    public void setSWebLk(String sWebLk) {
        this.sWebLk = sWebLk;
    }

    public String getStrPraiseNumber() {
        return strPraiseNumber;
    }

    public void setStrPraiseNumber(String strPraiseNumber) {
        this.strPraiseNumber = strPraiseNumber;
    }

    public String getStrQuestionId() {
        return strQuestionId;
    }

    public void setStrQuestionId(String strQuestionId) {
        this.strQuestionId = strQuestionId;
    }

    public String getStrQuestionTitle() {
        return strQuestionTitle;
    }

    public void setStrQuestionTitle(String strQuestionTitle) {
        this.strQuestionTitle = strQuestionTitle;
    }

    public String getStrQuestionContent() {
        return strQuestionContent;
    }

    public void setStrQuestionContent(String strQuestionContent) {
        this.strQuestionContent = strQuestionContent;
    }

    public String getStrAnswerTitle() {
        return strAnswerTitle;
    }

    public void setStrAnswerTitle(String strAnswerTitle) {
        this.strAnswerTitle = strAnswerTitle;
    }

    public String getStrAnswerContent() {
        return strAnswerContent;
    }

    public void setStrAnswerContent(String strAnswerContent) {
        this.strAnswerContent = strAnswerContent;
    }

    public String getStrQuestionMarketTime() {
        return strQuestionMarketTime;
    }

    public void setStrQuestionMarketTime(String strQuestionMarketTime) {
        this.strQuestionMarketTime = strQuestionMarketTime;
    }

    public String getSEditor() {
        return sEditor;
    }

    public void setSEditor(String sEditor) {
        this.sEditor = sEditor;
    }


}
