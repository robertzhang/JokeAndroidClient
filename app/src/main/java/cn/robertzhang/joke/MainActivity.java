package cn.robertzhang.joke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.HashMap;
import java.util.Map;

import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.model.entities.joke.JokeResult;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.joke.utils.JsonParserUtils;
import cn.robertzhang.libraries.utils.LogUtils;
import cn.robertzhang.libraries.volley.VolleyCallBack;
import cn.robertzhang.libraries.volley.VolleyHelper;

public class MainActivity extends AppCompatActivity implements VolleyCallBack{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String,String> map = new HashMap<String, String>();
        map.put("strDate","2016-01-22");
        map.put("strRow","1");
        VolleyHelper.getInstance(getApplicationContext()).setVolleyCallBack(this).
                postNetData(APIContants.URL_HOME_ONE, map, "success");
//        VolleyHelper.getInstance(getApplicationContext()).setVolleyCallBack(this)
//                .getNetData(APIContants.HOT_JOKE+"1");
    }

    @Override
    public void onVolleyResponseSucc(String jsonStr) {
        LogUtils.E("------onVolleyResponseSucc-------");
//        Article joke = JsonParserUtils.parseArticleResponse(jsonStr);
        Article joke = JsonParserUtils.parseOneResponse(jsonStr, Article.class);
        LogUtils.E("------onVolleyResponseSucc-------");
        LogUtils.E("MainActivity --"+ joke.getStrLastUpdateDate());
//        LogUtils.E("MainActivity --"+ joke.getStrHpId());
    }

    @Override
    public void onVolleyResponseFail(String error) {
        LogUtils.E("------onVolleyResponseFail-------"+error);
    }


}
