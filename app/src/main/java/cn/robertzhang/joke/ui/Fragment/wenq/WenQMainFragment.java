package cn.robertzhang.joke.ui.Fragment.wenq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.joke.ui.Fragment.SimpleBaseFragment;
import cn.robertzhang.joke.ui.activity.BaseActivity;
import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/2/17.
 * email: robertzhangsh@gmail.com
 */
public class WenQMainFragment extends BaseFragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tab_menu)
    RadioGroup tab_menu;

    SimpleBaseFragment wenQHomeFragment = null; // 主页
    SimpleBaseFragment wenQArticleFragment = null; // 文章
    SimpleBaseFragment wenQQuestionFragment = null; // 问题
    SimpleBaseFragment wenQThingFragment = null; // 东西
    SimpleBaseFragment mCurrentFragment = null; // 当前显示的fragment

    public static WenQMainFragment newInstance() {
        return new WenQMainFragment();
    }

    public static WenQMainFragment newInstance(int centerX, int centerY, boolean appBarExpanded) {
        Bundle args = new Bundle();
        args.putInt(ARG_CX, centerX);
        args.putInt(ARG_CY, centerY);
        args.putBoolean(ARG_SHOULD_EXPAND, appBarExpanded);

        WenQMainFragment frag = newInstance();
        frag.setArguments(args);

        return frag;
    }

    public SimpleBaseFragment getCurrentFragment() {
        return mCurrentFragment;
    }

    @Override
    public int getTheme() {
        return R.style.WenQingAppThemeLight;
    }

    @Override
    public String getTagString() {
        return "wenqing";
    }

    @Override
    protected boolean isAppBarExpanded() {
        return false;
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
        return ButterKnife.findById(getActivity(), R.id.wenqin_content);
    }

    @Override
    protected void initViewsAndEvents() {
        ((BaseActivity)mContext).setSupportActionBar(toolbar);
        ((BaseActivity)mContext).getSupportActionBar().setTitle(getResources().getString(R.string.wenq_title));

        if (wenQHomeFragment == null){
            wenQHomeFragment = new WenQHomeFragment();
        }
        mCurrentFragment = wenQHomeFragment;
        switchContent(mCurrentFragment);

        tab_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.menu_home:
                        if (wenQHomeFragment == null){
                            wenQHomeFragment = new WenQHomeFragment();
                        }
                        mCurrentFragment = wenQHomeFragment;
                        break;
                    case R.id.menu_article:
                        if (wenQArticleFragment == null) {
                            wenQArticleFragment = new WenQArticleFragment();
                        }
                        mCurrentFragment = wenQArticleFragment;
                        break;
                    case R.id.menu_thing:
                        if (wenQThingFragment == null){
                            wenQThingFragment = new WenQThingFragment();
                        }
                        mCurrentFragment = wenQThingFragment;
                        break;
                    case R.id.menu_question:
                        if (wenQQuestionFragment == null) {
                            wenQQuestionFragment = new WenQQuestionFragment();
                        }
                        mCurrentFragment = wenQQuestionFragment;
                        break;
                }
                switchContent(mCurrentFragment);
            }
        });
    }

    //切换Fragment
    public void switchContent(Fragment fragment) {
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.wenqin_content, fragment, getTagString())
                .commit();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_wenq;
    }


    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
