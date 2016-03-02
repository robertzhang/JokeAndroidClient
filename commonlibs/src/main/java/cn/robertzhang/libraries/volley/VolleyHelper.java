package cn.robertzhang.libraries.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class VolleyHelper {

    private static VolleyHelper mInstance = null;

    public static RequestQueue mRequestQueue;

    private Context mContext;

    private VolleyCallBack mCallback;

    public static VolleyHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyHelper(context);
        }
        return mInstance;
    }

    private VolleyHelper(Context context) {
        mContext = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public VolleyHelper setVolleyCallBack(VolleyCallBack callBack) {
        mCallback = callBack;
        return mInstance;
    }

    // Volley处理get请求
    public void getNetData(String url) {
        //通过URL获取对应的数据
        StringRequest strRequest = new StringRequest(url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mCallback.onVolleyResponseSucc(-1, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mCallback.onVolleyResponseFail(-1, error.getMessage());
            }
        });
        mRequestQueue.add(strRequest);
    }

    // Volley处理post请求
    public void postNetData(String url, final Map<String,String> map,final int type){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        mCallback.onVolleyResponseSucc(type, response);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                mCallback.onVolleyResponseFail(type, error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                return map;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    // Volley处理delete请求
    public void deleteNetData( String url,final int type){
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE,url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        mCallback.onVolleyResponseSucc(type, response);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                mCallback.onVolleyResponseFail(type, error.getMessage());
            }
        });
        mRequestQueue.add(stringRequest);
    }

    // Volley处理JsonObject请求
    public void JsonStringObejectRequest( String url,String json) {
        JSONObject params = null;
        try {
            params = new JSONObject(json);//需要注意的是，这里的json必须是对象的形式。
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url,params,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mCallback.onVolleyResponseSucc(-1, response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse != null) {
                    mCallback.onVolleyResponseFail(-1, error.getMessage());
                }
            }
        });
        mRequestQueue.add(jsonObjectRequest);
    }
}
