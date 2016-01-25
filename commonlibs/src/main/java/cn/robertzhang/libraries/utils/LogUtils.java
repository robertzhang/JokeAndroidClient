package cn.robertzhang.libraries.utils;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class LogUtils {

    public static boolean isLog = true;


    /**
     * Error Log
     * @param str
     */
    public static void E(String Tag,String str){
        if(isLog){
            android.util.Log.e(Tag, str);
        }
    }

    public static void E(String str) {
        E("zhangchao",str);
    }

    /**
     * DeBug Log
     * @param str
     */
    public static void D(String Tag,String str){
        if(isLog)
            android.util.Log.d(Tag, str);
    }

    /**
     * Info Log
     * @param str
     */
    public static void I(String Tag,String str){
        if(isLog)
            android.util.Log.i(Tag, str);
    }

    /**
     * Warn Log
     * @param str
     */
    public static void W(String Tag,String str){
        if(isLog)
            android.util.Log.w(Tag, str);
    }
}
