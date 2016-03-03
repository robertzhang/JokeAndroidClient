package cn.robertzhang.joke.ui.Fragment.doubi;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.presenter.doubi.JokePresenter;
import cn.robertzhang.joke.presenter.doubi.Presenter;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.joke.ui.activity.BaseActivity;
import cn.robertzhang.joke.ui.adapter.doubi.JokeFragmentVPAdapter;
import cn.robertzhang.joke.view.JokeView;
import cn.robertzhang.libraries.base.BaseLazyFragment;
import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/2/16.
 * email: robertzhangsh@gmail.com
 */
public class JokeMainFragment extends BaseFragment implements JokeView{

    @Bind(R.id.header)
    ImageView header;

    @Bind(R.id.common_toolbar)
    Toolbar common_toolbar;

    @Bind(R.id.viewpage)
    ViewPager viewpage;

    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsing_toolbar_layout;

    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;

    @Bind(R.id.smart_tab_layout)
    SmartTabLayout smart_tab_layout;

    private Presenter jokePresenter;

    public static JokeMainFragment newInstance() {
        return new JokeMainFragment();
    }

    public static JokeMainFragment newInstance(int centerX, int centerY, boolean appBarExpanded) {
        Bundle args = new Bundle();
        args.putInt(ARG_CX, centerX);
        args.putInt(ARG_CY, centerY);
        args.putBoolean(ARG_SHOULD_EXPAND, appBarExpanded);

        JokeMainFragment frag = newInstance();
        frag.setArguments(args);

        return frag;
    }

    // 返回fragment对应的style
    @Override
    public int getTheme() {
        return R.style.DouBiAppThemeDark;
    }

    @Override
    public String getTagString() {
        return "doubi";
    }


    // implements JokeView
    @Override
    public void initializeViews(List<BaseLazyFragment> fragments) {
        ((BaseActivity) mContext).setSupportActionBar(common_toolbar);
        ((BaseActivity)mContext).getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        viewpage.setOffscreenPageLimit(((JokePresenter) jokePresenter).jokeCategoryArray.length);
        viewpage.setAdapter(new JokeFragmentVPAdapter(getChildFragmentManager(),
                ((JokePresenter) jokePresenter).jokeCategoryArray));

        smart_tab_layout.setViewPager(viewpage);
        smart_tab_layout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                JokeFragment fragment = (JokeFragment)viewpage.
                        getAdapter().instantiateItem(viewpage, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // extends BaseFragment
    protected boolean isAppBarExpanded() {
        return mAppBarLayout != null && mAppBarLayout.getBottom() == mAppBarLayout.getHeight();
    }

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
//        return null;
        return ButterKnife.findById(getActivity(), R.id.viewpage);
    }

    @Override
    protected void initViewsAndEvents() {
        jokePresenter = new JokePresenter(this);
        jokePresenter.initialized();
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

}
