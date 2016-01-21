package cn.robertzhang.libraries.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class SharePreferenceUtils {

    private String sp_file_name = "JokeAndroidClient_SP";

    private static SharePreferenceUtils mSharePreferenceUtils = null;
    private SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor = null;

    public SharePreferenceUtils(Context context){
        sharedPreferences = context.getSharedPreferences(sp_file_name, Context.MODE_PRIVATE); //私有数据
    }

    public static synchronized SharePreferenceUtils CreateSharePreferenceFile(Context context){
        if (mSharePreferenceUtils == null) {
            mSharePreferenceUtils = new SharePreferenceUtils(context);
        }
        return mSharePreferenceUtils;
    }

    public SharePreferenceUtils edit() {
        if (sharedPreferences == null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        editor = sharedPreferences.edit();
        return mSharePreferenceUtils;
    }

    public SharePreferenceUtils putInt(String str, int mint){
        editor.putInt(str, mint);
        return mSharePreferenceUtils;
    }

    public SharePreferenceUtils putString(String key, String value){
        editor.putString(key, value);
        return mSharePreferenceUtils;
    }

    public SharePreferenceUtils putBoolean(String key, boolean value){
        editor.putBoolean(key, value);
        return mSharePreferenceUtils;
    }

    public SharePreferenceUtils putFloat(String key, float value){
        editor.putFloat(key, value);
        return mSharePreferenceUtils;
    }

    public SharePreferenceUtils putLong(String key, long value){
        editor.putLong(key, value);
        return mSharePreferenceUtils;
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, -100);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0.0f);
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, 0L);
    }

    public void commit(){
        editor.commit();
    }
}
