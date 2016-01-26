package cn.robertzhang.libraries.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class GsonUtils {

    // JsonString to List
    /**
     * 使用模板类型来构建方法，解析json数据
     * @param <T>
     * @return
     */
    public static <T> List<T> parseJsonToList(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray Jarray = parser.parse(jsonString).getAsJsonArray();
            for(JsonElement obj : Jarray ){
                T cse = gson.fromJson(obj , cls);
                list.add(cse);
            }
        } catch (Exception e) {}
        return list;
    }

    public static <T> T parseJson(String jsonString, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(jsonString, cls);
        } catch (Exception e) {}
        return t;
    }

    public static <T> List<T> parseJsonToList2(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {}
        return list;
    }

    public static List<Map<String, Object>> listKeyMaps(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Map<String, Object>>>() {
                    }.getType());
        } catch (Exception e) {}
        return list;
    }

    //Object or List to JsonString
    public static String objectToJson(Object root){//返回的是一个JsonObject字符串
        String json = null;
        Gson gson = new Gson();
        json = gson.toJson(root);
        return json;
    }

    public static <T> String listToJson(List<T> root){//返回的是JsonArray字符串
        String json = null;
        Gson gson = new Gson();
        json = gson.toJson(root);
        return json;
    }
}

