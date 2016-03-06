package cn.robertzhang.joke.presenter.doubi;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.config.Contants;
import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.joke.utils.JsonParserUtils;
import cn.robertzhang.joke.utils.VelloyUtils;
import cn.robertzhang.joke.view.doubi.JokeErrorMessageEvent;
import cn.robertzhang.joke.view.doubi.JokeLoadDataMessageEvent;
import cn.robertzhang.joke.view.doubi.JokeResponseEventMessage;
import cn.robertzhang.joke.view.doubi.JokeJsonStrEventMessage;
import cn.robertzhang.libraries.volley.VolleyCallBack;

/**
 * Created by robertzhang on 16/3/4.
 * email: robertzhangsh@gmail.com
 */
public class JokePresenter implements Presenter, VolleyCallBack{

    /**
     * 不同页面对应的当前刷新索引
     */
    private int hotIndex = 1;
    private int newstIndex = 1;
    private int truthIndex = 1;

    /**
     * 加载类型
     */
    public final static int HOT_TAG = 0;
    public final static int NEWST_TAG = 1;
    public final static int TRUTH_TAG = 2;

    private volatile static JokePresenter mInstances;

    public JokePresenter(){
        initialized();
    }

    public static JokePresenter getInstance() {
        if (mInstances == null) {
            synchronized (JokePresenter.class) {
                if (mInstances == null) {
                    mInstances = new JokePresenter();
                }
            }
        }

        return mInstances;
    }


    @Override
    public void initialized() {
        EventBus.getDefault().register(this);
    }

    public void finsh() {
        EventBus.getDefault().unregister(this);
    }

    // -------- user action
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void action(JokeLoadDataMessageEvent jme) {
        if (jme.getEventCode() == Contants.LOADMORE) {
            onLoadMore(jme.getData());
        } else if (jme.getEventCode() == Contants.REFRESH) {
            onRefresh(jme.getData());
        }
    }
    private void onLoadMore(int tag){
        int index = 0;
        String url = null;
        switch (tag) {
            case HOT_TAG:
                index = hotIndex;
                url = APIContants.URL_HOT_JOKE;
                break;
            case NEWST_TAG:
                index = newstIndex;
                url = APIContants.URL_NEWST_JOKE;
                break;
            case TRUTH_TAG:
                index = truthIndex;
                url = APIContants.URL_TRUTH_JOKE;
                break;
            default:
                return;
        }
        String page = String.valueOf(index + 1);
        VelloyUtils.getJokeData(this, page, url, Contants.LOADMORE);
    }

    private void onRefresh(int tag){
        String url = null;
        switch (tag) {
            case HOT_TAG:
                hotIndex = 1;
                url = APIContants.URL_HOT_JOKE;
                break;
            case NEWST_TAG:
                newstIndex = 1;
                url = APIContants.URL_NEWST_JOKE;
                break;
            case TRUTH_TAG:
                truthIndex = 1;
                url = APIContants.URL_TRUTH_JOKE;
                break;
            default:
                return;
        }
        String page = String.valueOf(1);
        VelloyUtils.getJokeData(this, page, url, Contants.REFRESH);
    }

    // --------- implements VolleyCallBack
    @Override
    public void onVolleyResponseSucc(int type, String jsonStr) {
        EventBus.getDefault().post(new JokeJsonStrEventMessage(type, jsonStr));
    }

    @Override
    public void onVolleyResponseFail(int type, String error) {
        onLoadFail(type);
    }

    // ----------- refresh UI
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onLoadSucc(JokeJsonStrEventMessage em) {
        List<Item> items = JsonParserUtils.parseJokeResponse(em.getData()).getItems();
        if (items == null || items.size() <= 0) {
            onLoadFail(em.getEventCode());
//            mIView.loadError(type);
        } else {
            EventBus.getDefault().post(new JokeResponseEventMessage(em.getEventCode(), items));
//            mIView.refreshUI(items, type);
        }
    }

    private void onLoadFail(int type) {
        EventBus.getDefault().post(new JokeErrorMessageEvent(type));
    }


}
