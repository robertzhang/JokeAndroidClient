package cn.robertzhang.joke.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.Bind;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.joke.ui.Fragment.doubi.JokeMainFragment;
import cn.robertzhang.joke.ui.Fragment.wenq.WenQMainFragment;
import cn.robertzhang.joke.view.MainActivityInterface;
import cn.robertzhang.libraries.eventbus.EventMessage;
import cn.robertzhang.libraries.netstatus.NetStateReceiver;
import cn.robertzhang.libraries.utils.NetUtils;

/**
 * Created by robertzhang on 16/2/16.
 * email: robertzhangsh@gmail.com
 */
public class MainActivity extends BaseActivity implements MainActivityInterface{

    @Bind(R.id.app_container)
    FrameLayout app_container;

    private BaseFragment fragment_doubi = null;
    private BaseFragment fragment_wenqing = null;
    private BaseFragment fragment_current;

    private static long DOUBLE_CLICK_TIME = 0L; //用于计算KEYCODE_BACK的点击次数

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_change_role:
                fragment_current.onSideSwitch(app_container);
                break;
            case R.id.action_about:

                break;
            case R.id.action_github:

                break;
        }
        return super.onOptionsItemSelected(item);
    }


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
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) { // 屏蔽menu键
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // ------ implements MainActivityInterface
    @Override
    public void goToSide(int cx, int cy, boolean appBarExpanded, String side) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BaseFragment fragment;
        switch(side) {
            case "doubi":
                fragment_doubi = JokeMainFragment.newInstance(cx,cy,appBarExpanded);
                fragment = fragment_doubi;
                break;
            case "wenqing":
                fragment_wenqing = WenQMainFragment.newInstance(cx, cy, appBarExpanded);
                fragment = fragment_wenqing;
                break;
            default:
                throw new IllegalStateException();
        }
        ft.replace(R.id.app_container,fragment,side).commit();

        fragment_current = fragment;
    }



    @Override
    public void removeAllFragmentExcept(@Nullable String tag) {
        List<Fragment> frags = getSupportFragmentManager().getFragments();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment frag;
        for (int i = 0; i < frags.size(); i++) {
            frag = frags.get(i);
            if (frag == null) {
                continue;
            }
            if (tag == null || !tag.equals(frag.getTag())) {
                ft.remove(frag);
            }
        }
        ft.commit();
    }

    // ------ extends BaseActivity
    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComming(EventMessage eventMessage) {

    }

    @Override
    protected View getLoadingTargetView() {
        return app_container;
    }

    @Override
    protected void initViewsAndEvents() {
        fragment_doubi = JokeMainFragment.newInstance();
//        fragment_wenqing = WenQMainFragment.newInstance();
        fragment_current = fragment_doubi;
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fade_in, 0)
                .replace(R.id.app_container, fragment_current, "wenqing")
                .commit();
    }

// -------如果需要监听网络情况，可以开放注释
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NetStateReceiver.registerNetworkStateReceiver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetStateReceiver.unRegisterNetworkStateReceiver(this);
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {
        if (type != NetUtils.NetType.WIFI) {
            showToast(getString(R.string.wifi_state_warming));
        }

        // 网络恢复后，可以做一些操作
    }

    @Override
    protected void onNetworkDisConnected() { // 提示当前网络异常
        if (fragment_current.getTagString() == "doubi") {
            showNetError();
        } else {
            fragment_current.showNetError();
        }
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
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
