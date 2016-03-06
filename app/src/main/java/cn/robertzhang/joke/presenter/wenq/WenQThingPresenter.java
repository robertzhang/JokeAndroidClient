package cn.robertzhang.joke.presenter.wenq;

import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.model.entities.one.Thing;
import cn.robertzhang.joke.view.wenq.ILoadView;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public class WenQThingPresenter extends WenQLoadDataPresenter<Thing> {

    public WenQThingPresenter(ILoadView mIView) {
        super(mIView);
    }

    @Override
    public String getModuleURL() {
        return APIContants.URL_THING_ONE;
    }
}
