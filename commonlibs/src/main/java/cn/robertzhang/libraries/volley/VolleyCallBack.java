package cn.robertzhang.libraries.volley;

/**
 * Created by robertzhang on 16/1/25.
 * email: robertzhangsh@gmail.com
 */
public interface VolleyCallBack {

    /**
     *  type用来标记是哪个请求动作
     *
     *  如果不需要type，则默认值为：-1
     */
    public void onVolleyResponseSucc(int type, String jsonStr);

    public void onVolleyResponseFail(int type, String error);
}
