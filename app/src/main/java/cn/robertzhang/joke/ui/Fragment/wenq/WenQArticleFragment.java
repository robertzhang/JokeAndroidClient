package cn.robertzhang.joke.ui.Fragment.wenq;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.ui.Fragment.SimpleBaseFragment;
import cn.robertzhang.joke.ui.adapter.wenq.WenQArticleAdapter;
import cn.robertzhang.libraries.utils.LogUtils;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public class WenQArticleFragment extends SimpleBaseFragment{

    @Bind(R.id.wenqin_list_rv)
    RecyclerView wenqin_list_rv;

    LinearLayoutManager llm;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_wenq_content;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        LogUtils.E("zhangchao","==WenQArticleFragment==");
        // 设置布局管理器
        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        wenqin_list_rv.setLayoutManager(llm);

        // 设置适配器
        wenqin_list_rv.setAdapter(new WenQArticleAdapter(getData()));
        wenqin_list_rv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = llm.findFirstVisibleItemPosition();
                int lastVisibleItem = llm.findLastVisibleItemPosition();
                int totalItemCount = llm.getItemCount();

                if (firstVisibleItem == 0 && dy < 0) {
                    // 当显示的第一个item为数据的第一个时，表示在header
                    // 刷新界面
                    LogUtils.E("zhangchao", "刷新开始");
                } else if (lastVisibleItem == totalItemCount - 1 && dy > 0) { // dy>0表示屏幕向下滑动
                    // 显示最后一个的时候加载更多
                    LogUtils.E("zhangchao", "加载更多");
                } else {
                    // do noting
                }
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected View getLoadingTargetView() {
        return wenqin_list_rv;
    }

    // 测试用
    private List<Article> getData() {
        List<Article> articles = new ArrayList<Article>();
        articles.add(new Article(1L,"2016-02-26","w未知1","w未知2","w未知3","w未知4","w未知5","w未知6","w未知7","w未知8","w未知9","w未知10","2016-02-26","w未知12","w未知13","w未知14","w未知15"));
        articles.add(new Article(2L,"2016-02-27","w未知2","w未知2","w未知","w未知","w未知","w未知","w未知","w未知","w未知","w未知","2016-02-26","w未知","w未知","w未知","w未知"));
        articles.add(new Article(3L,"2016-02-28","w未知3","w未知3","w未知","w未知","w未知","w未知","w未知","w未知","w未知","w未知","2016-02-26","w未知","w未知","w未知","w未知"));
//        articles.add(new Article((long)2));
        return articles;
    }
}
