package cn.robertzhang.joke.ui.Fragment.wenq;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.config.Contants;
import cn.robertzhang.joke.presenter.wenq.WenQLoadDataPresenter;
import cn.robertzhang.joke.ui.Fragment.SimpleBaseFragment;
import cn.robertzhang.joke.ui.adapter.wenq.WenQBaseAdapter;
import cn.robertzhang.joke.view.wenq.ILoadView;
import cn.robertzhang.joke.widget.recyclerviewloadmore.ExRcvAdapterWrapper;
import cn.robertzhang.joke.widget.recyclerviewloadmore.OnRcvScrollListener;

/**
 * Created by robertzhang on 16/3/3.
 * email: robertzhangsh@gmail.com
 */
public abstract class WenQBaseFragment<T> extends SimpleBaseFragment implements ILoadView<T>{

    @Bind(R.id.wenqin_list_rv)
    RecyclerView wenqin_list_rv;

    WenQBaseAdapter mAdpter;

    protected WenQLoadDataPresenter mPresenter;


    protected abstract WenQBaseAdapter getWenQAdapter(List<T> mList);

    protected abstract WenQLoadDataPresenter getWenQPresenter();


    @Override
    protected void initData() {
        mPresenter = getWenQPresenter();
    }

    @Override
    protected void initView() {
        View mFooterView = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_footer,null);
        View mHeaderView = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_footer,null);
        ((TextView)mHeaderView.findViewById(R.id.loading_msg)).setText(R.string.refresh_str);

        // 设置recycleview
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());// 设置布局管理器
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        wenqin_list_rv.setLayoutManager(llm);
        wenqin_list_rv.setOverScrollMode(View.OVER_SCROLL_NEVER);// 不显示滚动到边界的阴影（减少绘制）

        mAdpter = getWenQAdapter(mPresenter.getData());
        ExRcvAdapterWrapper adapterWrapper = new ExRcvAdapterWrapper<>(mAdpter, llm);
        adapterWrapper.setFooterView(mFooterView);
        adapterWrapper.setHeaderView(mHeaderView);

        wenqin_list_rv.setAdapter(adapterWrapper);// 设置适配器

        mPresenter.onRefrest();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_wenq_content;
    }

    @Override
    protected void initListener() {
        wenqin_list_rv.addOnScrollListener(new OnRcvScrollListener(){
            @Override
            public void onScrollUp() {}
            @Override
            public void onScrollDown() {}
            @Override
            public void onScrolled(int distanceX, int distanceY) {}

            @Override
            public void onTop(){
                /**在这里添加，刷新的请求*/
                mPresenter.onRefrest();
            }

            @Override
            public void onBottom() {
                /** 在这里添加，加载更多的请求*/
                mPresenter.onLoadMore();
            }
        });
    }

    @Override
    protected View getLoadingTargetView() {
        return wenqin_list_rv;
    }

    // 刷新数据后，更新UI
    protected void refreshSucc(T data) {
        wenqin_list_rv.scrollToPosition(1);
        mAdpter.refreshData(data);
    }

    // 加载更多数据后，跟新UI
    protected void loadMoreSucc(T data){
        mAdpter.addData(data);
    }

    // -----------  implement ILoadView ------------
    @Override
    public void refreshUI(T m, int type) {
        if (type == Contants.REFRESH) {
            refreshSucc(m);
        } else if (type == Contants.LOADMORE) {
            loadMoreSucc(m);
        }
    }

    @Override
    public void loadError(int type) {
        //根据操作，做出相应的错误处理
        if (type == Contants.REFRESH) {
            wenqin_list_rv.scrollToPosition(1);
            showToast("服务器挂了，稍候再试....");
        } else if (type == Contants.LOADMORE) {
            wenqin_list_rv.scrollToPosition(mAdpter.getItemCount());
            showToast("没有更多内容....");
        }
    }
}
