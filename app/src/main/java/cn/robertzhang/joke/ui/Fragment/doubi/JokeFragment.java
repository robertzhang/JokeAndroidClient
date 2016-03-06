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

    public void setIndex(int position) {
        current_index = position;
    }

    // -------- extends BaseFragment
    @Override
    protected void onFirstUserVisible() {
        View mFooterView = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_footer,null);
        View mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_footer,null);
        ((TextView)mHeaderView.findViewById(R.id.loading_msg)).setText(R.string.refresh_str);

        list = new ArrayList<Item>();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        fragment_list_rv.setLayoutManager(llm);
        fragment_list_rv.setOverScrollMode(View.OVER_SCROLL_NEVER);// 不显示滚动到边界的阴影（减少绘制）
        fragment_list_rv.setItemAnimator(new DefaultItemAnimator());

        mAdpter = new JokeRVAdapter(getActivity(),list);

        ExRcvAdapterWrapper adapterWrapper = new ExRcvAdapterWrapper<>(mAdpter, llm);
        adapterWrapper.setFooterView(mFooterView);
        adapterWrapper.setHeaderView(mHeaderView);

        fragment_list_rv.setAdapter(adapterWrapper);

        EventBus.getDefault().post(new JokeLoadDataMessageEvent(Contants.REFRESH, current_index));
    }

    public List<Item> getData(){
        List<Item> list = new ArrayList<Item>();
        Item a = new Item(1L);
        a.setContent("demo demo demo demo demo demo demo ");
        list.add(a);
        Item a1 = new Item(2L);
        a1.setContent("demo demo  ");
        list.add(a1);
        Item a2 = new Item(2L);
        a2.setContent("demo demo demo demo  ");
        list.add(a2);
        Item a3 = new Item(3L);
        a3.setContent("demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo demo");
        list.add(a3);
        Item a4 = new Item(4L);
        a4.setContent("demo  ");
        list.add(a4);
        Item a5 = new Item(5L);
        a5.setContent("demo demo demo demo demo demo demo ");
        list.add(a5);
        return list;
    }

    @Override
    protected void initViewsAndEvents() {
        fragment_list_rv.addOnScrollListener(new OnRcvScrollListener() {
            @Override
            public void onScrollUp() {}
            @Override
            public void onScrollDown() {}
            @Override
            public void onBottom() {}

            @Override
            public void onTop() {
                // 刷新操作
                EventBus.getDefault().post(new JokeLoadDataMessageEvent(Contants.REFRESH, current_index));
            }

            @Override
            public void onScrolled(int distanceX, int distanceY) {
                // 加载更多操作
                EventBus.getDefault().post(new JokeLoadDataMessageEvent(Contants.LOADMORE, current_index));
            }
        });
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
        if (em.getEventCode() == Contants.REFRESH) {
            fragment_list_rv.scrollToPosition(1);
            if (mAdpter != null) {
                mAdpter.refreshData(em.getData());
            }
        } else if (em.getEventCode() == Contants.LOADMORE) {
            if (mAdpter != null) {
                mAdpter.addData(em.getData());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadError(JokeErrorMessageEvent em) {
        //根据操作，做出相应的错误处理
        if (em.getEventCode() == Contants.REFRESH) {
            fragment_list_rv.scrollToPosition(1);
            showToast("服务器挂了，稍候再试....");
        } else if (em.getEventCode() == Contants.LOADMORE) {
            if (mAdpter != null) {
                fragment_list_rv.scrollToPosition(mAdpter.getItemCount());
            }
            showToast("没有更多内容....");
        }
    }

}
