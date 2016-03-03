package cn.robertzhang.joke.ui.Fragment.wenq;

import android.view.View;

import java.util.List;

import cn.robertzhang.joke.model.entities.one.Thing;
import cn.robertzhang.joke.presenter.wenq.WenQLoadDataPresenter;
import cn.robertzhang.joke.presenter.wenq.WenQThingPresenter;
import cn.robertzhang.joke.ui.Fragment.SimpleBaseFragment;
import cn.robertzhang.joke.ui.adapter.wenq.WenQBaseAdapter;
import cn.robertzhang.joke.ui.adapter.wenq.WenQThingAdapter;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public class WenQThingFragment extends WenQBaseFragment<Thing> {


    @Override
    protected WenQBaseAdapter getWenQAdapter(List<Thing> mList) {
        return new WenQThingAdapter(mList);
    }

    @Override
    protected WenQLoadDataPresenter getWenQPresenter() {
        return new WenQThingPresenter(this);
    }
}
