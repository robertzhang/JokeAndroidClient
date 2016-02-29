package cn.robertzhang.joke.ui.Fragment.doubi;

import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.Bind;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/1/30.
 * email: robertzhangsh@gmail.com
 */
public class JokeContentFragment extends BaseFragment {
    @Bind(R.id.viewpage)
    ViewPager viewpager;
    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return viewpager;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_joke;
    }

    @Override
    protected void onEventComming(EventMessage eventMessage) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    public int getTheme() {
        return 0;
    }

    @Override
    public String getTagString() {
        return null;
    }

    @Override
    protected boolean isAppBarExpanded() {
        return false;
    }
}
