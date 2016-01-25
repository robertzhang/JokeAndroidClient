package cn.robertzhang.joke.model.helper;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.model.dao.ItemDao;
import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.libraries.greendao.GreenDaoUtilsAbs;

/**
 * Created by robertzhang on 16/1/23.
 * email: robertzhangsh@gmail.com
 */
public class ItemDaoHelper extends GreenDaoUtilsAbs<Item, ItemDao>{

    public static ItemDaoHelper getInstance(){
        return new ItemDaoHelper();
    }

    @Override
    protected void setDao() {
        dao = JokeApplication.getDaoSession().getItemDao();
    }
}
