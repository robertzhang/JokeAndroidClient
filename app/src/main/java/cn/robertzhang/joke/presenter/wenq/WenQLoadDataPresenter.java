package cn.robertzhang.joke.presenter.wenq;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import cn.robertzhang.joke.config.Contants;
import cn.robertzhang.joke.utils.JsonParserUtils;
import cn.robertzhang.joke.utils.VelloyUtils;
import cn.robertzhang.joke.view.ILoadView;
import cn.robertzhang.libraries.utils.LogUtils;
import cn.robertzhang.libraries.utils.TimeUtil;
import cn.robertzhang.libraries.volley.VolleyCallBack;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */

/******************************
 *
 *  在这里WenQ里并没有用 - EventBus
 *
 *  使用的是最基本的回调，也就是最原始MVP结构
 *
 * ****************************
 */
public abstract class WenQLoadDataPresenter<T> implements VolleyCallBack{

    protected int index = 1; // 加载页数

    public ILoadView<T> mIView;// IView回调视图的接口

    List<T> mList = null;// 数据

    public WenQLoadDataPresenter(ILoadView mIView) {
        mList = new ArrayList<T>();
        this.mIView = mIView;
    }

    protected abstract String getModuleURL();

    public List<T> getData(){
        return mList;
    }


    // -------- user action
    public void onLoadMore(){
        String strDate = TimeUtil.getDate();
        String strRow = String.valueOf(index + 1);
        VelloyUtils.getWenQData(this, strDate, strRow, getModuleURL(), Contants.LOADMORE);
    }

    public void onRefrest(){
        String strDate = TimeUtil.getDate();
        String strRow = String.valueOf(1);
        VelloyUtils.getWenQData(this, strDate, strRow, getModuleURL(), Contants.REFRESH);
    }

    // ----------- refresh UI
    protected void onLoadSucc(int type, String jsonStr) {
        /**
         *  获取T.class的值
         */
        Class<T> cls = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        T item = JsonParserUtils.parseOneResponse(jsonStr, cls);
        if (item == null) {
            mIView.loadError(type);
        } else {
            mIView.refreshUI(item, type);
        }
    }

    private void onLoadFail(int type, String jsonStr) {
        mIView.loadError(type);
    }

    // ---------   implements VolleyCallBack 接受结果
    @Override
    public void onVolleyResponseSucc(int type, String jsonStr) {
        switch (type) {
            case Contants.REFRESH:
                index = 1;
                break;
            case Contants.LOADMORE:
                index++;
                break;
        }
        onLoadSucc(type, jsonStr);
    }

    @Override
    public void onVolleyResponseFail(int type, String error) {
        onLoadFail(type, error);
    }
}
