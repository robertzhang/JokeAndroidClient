package cn.robertzhang.joke.ui.Fragment.doubi;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.presenter.doubi.JokePresenter;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.joke.ui.activity.BaseActivity;
import cn.robertzhang.joke.ui.adapter.doubi.JokeFragmentVPAdapter;
import cn.robertzhang.libraries.utils.LogUtils;

/**
 * Created by robertzhang on 16/2/16.
 * email: robertzhangsh@gmail.com
 */
public class JokeMainFragment extends BaseFragment{

    @Bind(R.id.header)
    ImageView header;

    @Bind(R.id.common_toolbar)
    Toolbar common_toolbar;

    @Bind(R.id.viewpage)
    ViewPager viewpage;

    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;

    @Bind(R.id.smart_tab_layout)
    SmartTabLayout smart_tab_layout;

    private JokeFragmentVPAdapter jfvpa;

    private JokePresenter mJokePresenter;
    public JokeMainFragment() {
        super();
        mJokePresenter = JokePresenter.getInstance();
    }

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
    public void onDestroy() {
        mJokePresenter.finsh();
        super.onDestroy();
    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(getActivity(), R.id.viewpage);
    }

    @Override
    protected void initViewsAndEvents() {
        String[] array = JokeApplication.getAppContext().
                getResources().getStringArray(R.array.joke_tab_list);
        ((BaseActivity)mContext).setSupportActionBar(common_toolbar);
        ((BaseActivity)mContext).getSupportActionBar().setTitle(getResources().getString(R.string.doubi_title));

        header.setImageResource(setHeaderResId());

        viewpage.setOffscreenPageLimit(array.length);
        jfvpa = new JokeFragmentVPAdapter(getChildFragmentManager(), array);
        viewpage.setAdapter(jfvpa);

        smart_tab_layout.setViewPager(viewpage);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_joke;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    private int setHeaderResId(){
        TypedArray headerimage = getResources().obtainTypedArray(R.array.header_image);
        int id = (int)(Math.random()*6);//随机生成获取一个0到5的数组
        return headerimage.getResourceId(id, 1);
    }

}
