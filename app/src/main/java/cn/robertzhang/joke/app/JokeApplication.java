package cn.robertzhang.joke.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.robertzhang.joke.model.dao.DaoMaster;
import cn.robertzhang.joke.model.dao.DaoSession;
import cn.robertzhang.libraries.base.BaseAppManager;

/**
 * Created by robertzhang on 16/1/23.
 * email: robertzhangsh@gmail.com
 */
public class JokeApplication extends Application{

    private static Context mContext;

    /**
     * #- GreenDao 使用
     * GreenDao的Session需要在每个DB实例对象的工具类中使用
     */
    private static DaoSession mDaoSession;

    // 数据的名称
    private static String DB_NAME = "JOKE_DB";

    public void onCreate(){
        super.onCreate();
        JokeApplication.mContext = getApplicationContext();
        init();
    }

    private void init(){
        Fresco.initialize(mContext);
    }

    public static Context getAppContext(){
        return mContext;
    }

    /**
     * #- GreenDao 使用
     * @return
     */
    public static DaoSession getDaoSession() {
        if (null == mDaoSession) {
            DaoMaster.DevOpenHelper devHelper = new DaoMaster.DevOpenHelper(mContext,DB_NAME,null);
            DaoMaster daoMaster = new DaoMaster(devHelper.getWritableDatabase());
            mDaoSession = daoMaster.newSession();
        }
        return mDaoSession;
    }

    /**
     * 退出程序
     */
    public void exitApp() {
        BaseAppManager.getInstance().clear();
        System.exit(0);
        System.gc();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
 }
