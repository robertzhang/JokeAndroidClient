package cn.robertzhang.joke.model.helper;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.model.dao.ArticleDao;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.libraries.greendao.GreenDaoUtilsAbs;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class ArticleDaoHelper extends GreenDaoUtilsAbs<Article, ArticleDao> {

    public static ArticleDaoHelper getInstance(){
        return new ArticleDaoHelper();
    }

    @Override
    protected void setDao() {
        dao = JokeApplication.getDaoSession().getArticleDao();
    }

}
