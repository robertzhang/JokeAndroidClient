package cn.robertzhang.joke.presenter.wenq;

import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.joke.view.wenq.ILoadView;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public class WenQArticlePresenter extends WenQLoadDataPresenter<Article> {

    public WenQArticlePresenter(ILoadView iView){
        super(iView);
    }

    @Override
    public String getModuleURL() {
        return APIContants.URL_ARTICLE_ONE;
    }
}
