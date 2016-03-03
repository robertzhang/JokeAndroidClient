package cn.robertzhang.joke.ui.Fragment.wenq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.joke.presenter.wenq.WenQHomePresenter;
import cn.robertzhang.joke.presenter.wenq.WenQLoadDataPresenter;
import cn.robertzhang.joke.ui.Fragment.SimpleBaseFragment;
import cn.robertzhang.joke.ui.adapter.wenq.WenQBaseAdapter;
import cn.robertzhang.joke.ui.adapter.wenq.WenQHomeAdapter;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public class WenQHomeFragment extends WenQBaseFragment<Home>{
    @Override
    protected WenQBaseAdapter getWenQAdapter(List<Home> mList) {
        return new WenQHomeAdapter(mList);
    }

    @Override
    protected WenQLoadDataPresenter getWenQPresenter() {
        return new WenQHomePresenter(this);
    }
}
