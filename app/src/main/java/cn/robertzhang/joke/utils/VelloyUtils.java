package cn.robertzhang.joke.utils;

import java.util.HashMap;
import java.util.Map;

import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.libraries.volley.VolleyCallBack;
import cn.robertzhang.libraries.volley.VolleyHelper;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class VelloyUtils {

//    public static void getHomeData(VolleyCallBack volleyCallBack, String strDate, String strRow) {
//        getWenQData(volleyCallBack,strDate,strRow,APIContants.URL_HOME_ONE);
//    }
//
//    public static void getArticleData(VolleyCallBack volleyCallBack, String strDate, String strRow){
//        getWenQData(volleyCallBack, strDate, strRow, APIContants.URL_ARTICLE_ONE);
//    }
//
//    public static void getQuestionData(VolleyCallBack volleyCallBack, String strDate, String strRow){
//        getWenQData(volleyCallBack, strDate, strRow, APIContants.URL_QUESTION_ONE);
//    }
//
//    public static void getThingData(VolleyCallBack volleyCallBack, String strDate, String strRow){
//        getWenQData(volleyCallBack, strDate, strRow, APIContants.URL_THING_ONE);
//    }

    public static void getWenQData(VolleyCallBack volleyCallBack, String strDate, String strRow,String url){
        Map<String,String> map = new HashMap<String, String>();
        map.put("strDate",strDate);
        map.put("strRow",strRow);
        VolleyHelper.getInstance(JokeApplication.getAppContext()).setVolleyCallBack(volleyCallBack).
                postNetData(url, map, "success");
    }

}
