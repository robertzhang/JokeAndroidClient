package cn.robertzhang.joke.presenter.wenq;

import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.joke.view.wenq.ILoadView;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public class WenQHomePresenter extends WenQLoadDataPresenter<Home> {

    public WenQHomePresenter(ILoadView mIView) {
        super(mIView);
    }

    @Override
    public String getModuleURL() {
        return APIContants.URL_HOME_ONE;
    }
}
