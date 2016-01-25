package cn.robertzhang.joke.model.helper;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.model.dao.HomeDao;
import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.libraries.greendao.GreenDaoUtilsAbs;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class HomeDaoHelper extends GreenDaoUtilsAbs<Home, HomeDao> {

    public static HomeDaoHelper getInstance(){
        return new HomeDaoHelper();
    }

    @Override
    protected void setDao() {
        dao = JokeApplication.getDaoSession().getHomeDao();
    }
}
