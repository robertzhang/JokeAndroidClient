package cn.robertzhang.libraries.volley;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

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

import cn.robertzhang.libraries.utils.LogUtils;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public class VolleyHelper {

    private static VolleyHelper mInstance = null;

    public static RequestQueue mRequestQueue;

    public Context mContext;

    public VolleyCallBack mCallback;

    public static VolleyHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyHelper(context);
        }
        return mInstance;
    }

    public VolleyHelper(Context context) {
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
                mCallback.onVolleyResponseSucc(response);
                LogUtils.E("getNetData:" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mCallback.onVolleyResponseFail(error.getMessage());
                LogUtils.E("message:"+error.getMessage() +", error: "+ error);
            }
        });
        mRequestQueue.add(strRequest);
    }

    // Volley处理post请求
    public void postNetData(String url, final Map<String,String> map,final String succ){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        mCallback.onVolleyResponseSucc(response);
                        LogUtils.E("postNetData:"+response);
                        Toast.makeText(mContext, succ+"成功", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                mCallback.onVolleyResponseFail(error.getMessage());
                LogUtils.E("postNetData errormessage:" + error.getMessage() + ";error:" + error);
                Toast.makeText(mContext, succ+"失败", Toast.LENGTH_SHORT).show();
//                Snackbar.make(getLoadingTargetView(), succ+"失败", Snackbar.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() {
                return map;
            }
        };
        mRequestQueue.add(stringRequest);
    }

    // Volley处理delete请求
    public void deleteNetData(String url,final String succ){
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE,url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        mCallback.onVolleyResponseSucc(response);
                        LogUtils.E("deleteNetData:"+response);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                mCallback.onVolleyResponseFail(error.getMessage());
                LogUtils.E("deleteNetData:"+ error.getMessage()+";error:"+error);
                Toast.makeText(mContext, succ+"失败", Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(stringRequest);
    }

    // Volley处理JsonObject请求
    public void JsonStringObejectRequest(String url,String json) {
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
                mCallback.onVolleyResponseSucc(response.toString());
                LogUtils.E("jsonObjectRequestPostSuccess===="+response);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse != null) {
                    mCallback.onVolleyResponseFail(error.getMessage());
                    LogUtils.E("jsonObjectRequestPostSuccess===error==" + error.networkResponse.statusCode);
                    Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        mRequestQueue.add(jsonObjectRequest);
    }
}
