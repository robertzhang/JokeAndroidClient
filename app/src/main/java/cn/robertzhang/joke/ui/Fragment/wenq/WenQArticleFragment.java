package cn.robertzhang.joke.ui.Fragment.wenq;


import java.util.List;

import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.presenter.wenq.WenQArticlePresenter;
import cn.robertzhang.joke.presenter.wenq.WenQLoadDataPresenter;
import cn.robertzhang.joke.ui.adapter.wenq.WenQArticleAdapter;
import cn.robertzhang.joke.ui.adapter.wenq.WenQBaseAdapter;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public class WenQArticleFragment extends WenQBaseFragment<Article>{

    @Override
    protected WenQBaseAdapter getWenQAdapter(List<Article> mList) {
        return new WenQArticleAdapter(mList);
    }

    @Override
    protected WenQLoadDataPresenter getWenQPresenter() {
        return new WenQArticlePresenter(this);
    }
}
