package cn.robertzhang.joke.presenter.wenq;

import cn.robertzhang.joke.utils.VelloyUtils;
import cn.robertzhang.joke.view.ILoadView;
import cn.robertzhang.libraries.utils.TimeUtil;
import cn.robertzhang.libraries.volley.VolleyCallBack;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public abstract class WenQPresenter implements VolleyCallBack{

    protected int index = 1;

    public ILoadView mIView;

    public abstract String getModuleURL();

    public abstract void onLoadSucc(String jsonStr);

    public abstract void onLoadFail(String jsonStr);

    public void onLoadMore(int index){
        String strDate = TimeUtil.getDate();
        String strRow = String.valueOf(index + 1);
        VelloyUtils.getWenQData(this, strDate, strRow, getModuleURL());
    }

    public void onUpdate(){
        onLoadMore(0);
    }

    // implements VolleyCallBack 接受结果
    @Override
    public void onVolleyResponseSucc(String jsonStr) {
        index++;
        onLoadSucc(jsonStr);
    }

    @Override
    public void onVolleyResponseFail(String error) {
        onLoadFail(error);
    }
}
