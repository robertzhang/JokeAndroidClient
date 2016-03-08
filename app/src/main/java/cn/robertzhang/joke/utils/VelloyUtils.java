package cn.robertzhang.joke.utils;

import java.util.HashMap;
import java.util.Map;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.libraries.utils.LogUtils;
import cn.robertzhang.libraries.volley.VolleyCallBack;
import cn.robertzhang.libraries.volley.VolleyHelper;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class VelloyUtils {

    public static void getJokeData(VolleyCallBack volleyCallBack, String page, String url, int flag){
        String urlStr = url+"?page="+page;
        VolleyHelper.getInstance(JokeApplication.getAppContext()).setVolleyCallBack(volleyCallBack).
                getNetData(urlStr, flag);
    }

    public static void getWenQData(VolleyCallBack volleyCallBack, String strDate, String strRow,String url, int flag){
        Map<String,String> map = new HashMap<String, String>();
        map.put("strDate",strDate);
        map.put("strRow",strRow);
        VolleyHelper.getInstance(JokeApplication.getAppContext()).setVolleyCallBack(volleyCallBack).
                postNetData(url, map, flag);
    }

}
