package cn.robertzhang.joke.ui.Fragment.wenq;

import java.util.List;

import cn.robertzhang.joke.model.entities.one.Question;
import cn.robertzhang.joke.presenter.wenq.WenQLoadDataPresenter;
import cn.robertzhang.joke.presenter.wenq.WenQQuestionPresenter;
import cn.robertzhang.joke.ui.adapter.wenq.WenQBaseAdapter;
import cn.robertzhang.joke.ui.adapter.wenq.WenQQuestionAdapter;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public class WenQQuestionFragment extends WenQBaseFragment<Question>{

    @Override
    protected WenQBaseAdapter getWenQAdapter(List<Question> mList) {
        return new WenQQuestionAdapter(mList);
    }

    @Override
    protected WenQLoadDataPresenter getWenQPresenter() {
        return new WenQQuestionPresenter(this);
    }
}

