package cn.robertzhang.joke.ui.Fragment.doubi;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.config.Contants;
import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.joke.ui.adapter.doubi.JokeRVAdapter;
import cn.robertzhang.joke.view.doubi.JokeErrorMessageEvent;
import cn.robertzhang.joke.view.doubi.JokeLoadDataMessageEvent;
import cn.robertzhang.joke.view.doubi.JokeResponseEventMessage;
import cn.robertzhang.joke.widget.recyclerviewloadmore.ExRcvAdapterWrapper;
import cn.robertzhang.joke.widget.recyclerviewloadmore.OnRcvScrollListener;
import cn.robertzhang.libraries.eventbus.EventMessage;
import cn.robertzhang.libraries.utils.LogUtils;

/**
 * Created by robertzhang on 16/1/29.
 * email: robertzhangsh@gmail.com
 */
public class JokeFragment extends BaseFragment{

    @Bind(R.id.fragment_list_rv)
    RecyclerView fragment_list_rv;

    List<Item> list;

    JokeRVAdapter mAdpter;

    private int current_index = 0;

    private int action = Contants.NONE;

    public void setIndex(int position) {
        current_index = position;
    }

    // -------- extends BaseFragment
    @Override
    protected void onFirstUserVisible() {
        View mFooterView = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_footer,null);
//        View mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_footer,null);
//        ((TextView)mHeaderView.findViewById(R.id.loading_msg)).setText(R.string.refresh_str);

        list = new ArrayList<Item>();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        fragment_list_rv.setLayoutManager(llm);
        fragment_list_rv.setOverScrollMode(View.OVER_SCROLL_NEVER);// 不显示滚动到边界的阴影（减少绘制）
        fragment_list_rv.setItemAnimator(new DefaultItemAnimator());

        mAdpter = new JokeRVAdapter(getActivity(),list);

        ExRcvAdapterWrapper adapterWrapper = new ExRcvAdapterWrapper<>(mAdpter, llm);
        adapterWrapper.setFooterView(mFooterView);
//        adapterWrapper.setHeaderView(mHeaderView);

        fragment_list_rv.setAdapter(adapterWrapper);

        onLoadData(Contants.REFRESH, current_index);
    }

    @Override
    protected void initViewsAndEvents() {
        fragment_list_rv.addOnScrollListener(new OnRcvScrollListener() {
            @Override
            public void onScrollUp() {}
            @Override
            public void onScrollDown() {}
            @Override
            public void onScrolled(int distanceX, int distanceY) {
            }
            @Override
            public void onBottom() {
                // 加载更多操作
                onLoadData(Contants.LOADMORE, current_index);
            }

            @Override
            public void onTop() {
                // 刷新操作
//                EventBus.getDefault().post(new JokeLoadDataMessageEvent(Contants.REFRESH, current_index));
            }
        });
    }

    private void onLoadData(int action, int index) {
        if (this.action == Contants.NONE) {
            EventBus.getDefault().post(new JokeLoadDataMessageEvent(action, index));
            this.action = action;
        } else {
            showToast("正在加载，请耐心等待！");
        }
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(getActivity(), R.id.fragment_list_rv);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_vp_content;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return true;
    }

    @Override
    public int getTheme() {
        return R.style.DouBiAppThemeDark;
    }

    @Override
    public String getTagString() {
        return "doubi";
    }

    @Override
    protected boolean isAppBarExpanded() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshUI(JokeResponseEventMessage em) {
        if (em.getEventCode() == current_index  && action != Contants.NONE) {
            if (action == Contants.REFRESH) {
                if (mAdpter != null) {
                    //fragment_list_rv.scrollToPosition(1);
                    mAdpter.refreshData(em.getData());
                }
            } else if (action == Contants.LOADMORE) {
                if (mAdpter != null) {
                    mAdpter.addData(em.getData());
                }
            }
            action = Contants.NONE;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadError(JokeErrorMessageEvent em) {
        //根据操作，做出相应的错误处理
        if (action == Contants.REFRESH) {
            fragment_list_rv.scrollToPosition(1);
            showToast("服务器挂了，稍候再试....");
        } else if (action == Contants.LOADMORE) {
            if (mAdpter != null) {
                fragment_list_rv.scrollToPosition(mAdpter.getItemCount());
            }
            showToast("没有更多内容....");
        }
    }

}
