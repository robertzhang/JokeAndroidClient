package cn.robertzhang.libraries.volley;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public interface VolleyCallBack {

    public void onVolleyResponseSucc(String jsonStr);

    public void onVolleyResponseFail(String error);
}
