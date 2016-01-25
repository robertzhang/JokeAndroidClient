package cn.robertzhang.joke.utils;

import cn.robertzhang.joke.model.entities.joke.JokeResult;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.joke.model.entities.one.Question;
import cn.robertzhang.joke.model.entities.one.Thing;
import cn.robertzhang.libraries.utils.GsonUtils;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class JsonParserUtils {

    // 糗事百科返回数据解析
    public static JokeResult parseJokeResponse(String str) {
        JokeResult result = GsonUtils.parseJson(str, JokeResult.class);
        return result;
    }

    // one 返回数据解析
    public static Article parseArticleResponse(String str) {
        Article result = GsonUtils.parseJson(str, Article.class);
        return result;
    }

    public static Home parseHomeResponse(String str) {
        Home result = GsonUtils.parseJson(str, Home.class);
        return result;
    }

    public static Question parseQuestionResponse(String str) {
        Question result = GsonUtils.parseJson(str, Question.class);
        return result;
    }

    public static Thing parseThingResponse(String str) {
        Thing result = GsonUtils.parseJson(str, Thing.class);
        return result;
    }
}
