package cn.robertzhang.joke.presenter.wenq;

import java.util.ArrayList;
import java.util.List;

import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.utils.JsonParserUtils;
import cn.robertzhang.joke.view.ILoadView;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public class WenQArticlePresenter extends WenQPresenter{

    List<Article> articleList = null;

    public WenQArticlePresenter(ILoadView iView){
        articleList = new ArrayList<Article>();
        mIView = iView;
    }

    @Override
    public String getModuleURL() {
        return APIContants.URL_ARTICLE_ONE;
    }

    @Override
    public void onLoadSucc( String jsonStr) {
        Article item = JsonParserUtils.parseOneResponse(jsonStr, Article.class);
        if (item == null) {
            mIView.loadError();
        } else {
            articleList.add(item);
            mIView.refreshUI();
        }
    }

    @Override
    public void onLoadFail(String jsonStr) {
        mIView.loadError();
    }
}
