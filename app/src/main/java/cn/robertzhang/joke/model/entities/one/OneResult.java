package cn.robertzhang.joke.model.entities.one;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class OneResult {

    private String rs;
    private Thing entTg;
    private Question questionAdEntity;
    private Home hpEntity;
    private Article contentEntity;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public Thing getEntTg() {
        return entTg;
    }

    public void setEntTg(Thing entTg) {
        this.entTg = entTg;
    }

    public Question getQuestionAdEntity() {
        return questionAdEntity;
    }

    public void setQuestionAdEntity(Question questionAdEntity) {
        this.questionAdEntity = questionAdEntity;
    }

    public Home getHpEntity() {
        return hpEntity;
    }

    public void setHpEntity(Home hpEntity) {
        this.hpEntity = hpEntity;
    }

    public Article getContentEntity() {
        return contentEntity;
    }

    public void setContentEntity(Article contentEntity) {
        this.contentEntity = contentEntity;
    }
}
