package cn.robertzhang.joke.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.presenter.JokePresenter;
import cn.robertzhang.joke.presenter.Presenter;
import cn.robertzhang.joke.ui.Fragment.doubi.JokeFragment;
import cn.robertzhang.joke.ui.adapter.doubi.JokeFragmentVPAdapter;
import cn.robertzhang.joke.view.JokeView;
import cn.robertzhang.libraries.base.BaseLazyFragment;
import cn.robertzhang.libraries.eventbus.EventMessage;
import cn.robertzhang.libraries.utils.NetUtils;

/**
 * Created by robertzhang on 16/1/28.
 * email: robertzhangsh@gmail.com
 */
public class JokeActivity extends BaseActivity implements JokeView{

    @Bind(R.id.header)
    ImageView header;

    @Bind(R.id.common_toolbar)
    Toolbar common_toolbar;

    @Bind(R.id.viewpage)
    ViewPager viewpage;

    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsing_toolbar_layout;

    @Bind(R.id.smart_tab_layout)
    SmartTabLayout smart_tab_layout;


    private Presenter jokePresenter;

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_joke;
    }

    @Override
    protected void onEventComming(EventMessage eventMessage) {

    }

    @Override
    protected View getLoadingTargetView() { //Snackbar需要用的
        return ButterKnife.findById(this, R.id.viewpage);
    }

    @Override
    protected void initViewsAndEvents() {
        jokePresenter = new JokePresenter(this);
        jokePresenter.initialized();
    }

    @Override
    public void initializeViews(List<BaseLazyFragment> fragments) {

        setSupportActionBar(common_toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        viewpage.setOffscreenPageLimit(((JokePresenter) jokePresenter).jokeCategoryArray.length);
        viewpage.setAdapter(new JokeFragmentVPAdapter(getSupportFragmentManager(),
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:

                break;
            case R.id.action_github:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private static long DOUBLE_CLICK_TIME = 0L;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //按back键退出程序
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME) > 2000) {
                showToast(getString(R.string.double_click_exit));
                DOUBLE_CLICK_TIME = System.currentTimeMillis();
            } else {
                ((JokeApplication)getApplication()).exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

}
