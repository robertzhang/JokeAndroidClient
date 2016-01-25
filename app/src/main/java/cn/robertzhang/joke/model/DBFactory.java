package cn.robertzhang.joke.model;

import android.content.Context;

import cn.robertzhang.joke.model.helper.ArticleDaoHelper;
import cn.robertzhang.joke.model.helper.HomeDaoHelper;
import cn.robertzhang.joke.model.helper.ItemDaoHelper;
import cn.robertzhang.joke.model.helper.QuestionDaoHelper;
import cn.robertzhang.joke.model.helper.ThingDaoHelper;
import cn.robertzhang.joke.model.helper.UserDaoHelper;
import cn.robertzhang.libraries.greendao.GreenDaoUtils;

/**
 * Created by robertzhang on 16/1/22.
 * email: robertzhangsh@gmail.com
 */
public class DBFactory {
    /*
    * 1.Factory使用工厂模式
    * 2.Factory用来创建GreenDaoUtilsAbs的子对象，
    * 这些子对象是dao数据的实际操作对象。
    */

    public static final int Joke_User 					= 1;
    public static final int Joke_Itemd					= 2;
    public static final int Joke_Votes			        = 3;
    public static final int One_Article                 = 4;
    public static final int One_Home                    = 5;
    public static final int One_Question                = 6;
    public static final int One_Thing                   = 7;

    /**
     * 创建相应的Data工具
     * @param context
     * @param dao
     * @return
     */
    public static GreenDaoUtils builder(Context context, int dao){
        GreenDaoUtils db = null;
        switch (dao) {
            case Joke_User:
                db = UserDaoHelper.getInstance();
                break;
            case Joke_Itemd:
                db = ItemDaoHelper.getInstance();
                break;
            case Joke_Votes:
//                db = VotDaoHelper.getInstance();
                break;
            case One_Article:
                db = ArticleDaoHelper.getInstance();
                break;
            case One_Home:
                db = HomeDaoHelper.getInstance();
                break;
            case One_Question:
                db = QuestionDaoHelper.getInstance();
                break;
            case One_Thing:
                db = ThingDaoHelper.getInstance();
                break;
        }
        return db;
    }
}
