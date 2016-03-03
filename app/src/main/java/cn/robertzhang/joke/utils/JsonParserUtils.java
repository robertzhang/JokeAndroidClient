package cn.robertzhang.joke.utils;

import java.io.UnsupportedEncodingException;

import cn.robertzhang.joke.model.entities.joke.JokeResult;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.joke.model.entities.one.OneResult;
import cn.robertzhang.joke.model.entities.one.Question;
import cn.robertzhang.joke.model.entities.one.Thing;
import cn.robertzhang.libraries.utils.GsonUtils;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class JsonParserUtils {

    // “糗事百科”返回数据解析
    public static JokeResult parseJokeResponse(String str) {
        JokeResult result = GsonUtils.parseJson(str, JokeResult.class);
        return result;
    }

    // “One一个”返回数据解析
    public static <T> T parseOneResponse(String str, Class<T> mClass) {
        String s = null;
        // 对字符集进行转码
        try {
            if (mClass == Question.class || mClass == Article.class) {
                s = new String(str.getBytes("ISO-8859-1"), "UTF-8");
            } else {
                s = str;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        OneResult result = GsonUtils.parseJson(s, OneResult.class);
        T parse = null;
        if (result.getResult() != null && (result.getResult().equals("SUCCESS"))
                || (result.getRs() != null && result.getRs().equals("SUCCESS"))) {
            if (mClass == Home.class) {
                parse = (T) result.getHpEntity();
            } else if (mClass == Article.class) {
                parse = (T) result.getContentEntity();
            } else if (mClass == Question.class) {
                parse = (T) result.getQuestionAdEntity();
            } else if (mClass == Thing.class) {
                parse = (T) result.getEntTg();
            }
        }
        return parse;
    }
}
