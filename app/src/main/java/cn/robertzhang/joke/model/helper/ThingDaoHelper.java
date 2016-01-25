package cn.robertzhang.joke.model.helper;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.model.dao.ThingDao;
import cn.robertzhang.joke.model.entities.one.Thing;
import cn.robertzhang.libraries.greendao.GreenDaoUtilsAbs;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class ThingDaoHelper extends GreenDaoUtilsAbs<Thing, ThingDao> {

    public static ThingDaoHelper getInstance(){
        return new ThingDaoHelper();
    }

    @Override
    protected void setDao() {
        dao = JokeApplication.getDaoSession().getThingDao();
    }
}
