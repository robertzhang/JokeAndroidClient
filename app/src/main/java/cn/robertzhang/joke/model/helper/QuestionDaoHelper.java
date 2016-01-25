package cn.robertzhang.joke.model.helper;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.model.dao.QuestionDao;
import cn.robertzhang.joke.model.entities.one.Question;
import cn.robertzhang.libraries.greendao.GreenDaoUtilsAbs;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class QuestionDaoHelper extends GreenDaoUtilsAbs<Question, QuestionDao> {

    public static QuestionDaoHelper getInstance(){
        return new QuestionDaoHelper();
    }

    @Override
    protected void setDao() {
        dao = JokeApplication.getDaoSession().getQuestionDao();
    }
}
