package cn.robertzhang.joke.model.helper;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.model.dao.UserDao;
import cn.robertzhang.joke.model.entities.joke.User;
import cn.robertzhang.libraries.greendao.GreenDaoUtilsAbs;

/**
 * Created by robertzhang on 16/1/23.
 * email: robertzhangsh@gmail.com
 */
public class UserDaoHelper extends GreenDaoUtilsAbs<User, UserDao> {

    public static UserDaoHelper getInstance() {
        return new UserDaoHelper();
    }

    @Override
    protected void setDao() {
        dao = JokeApplication.getDaoSession().getUserDao();
    }
}
