package cn.robertzhang.joke.presenter.wenq;

import cn.robertzhang.joke.config.APIContants;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public class WenQThingPresenter extends WenQPresenter{
    @Override
    public String getModuleURL() {
        return APIContants.URL_THING_ONE;
    }

    @Override
    public void onLoadSucc(String jsonStr) {

    }

    @Override
    public void onLoadFail(String jsonStr) {

    }
}
