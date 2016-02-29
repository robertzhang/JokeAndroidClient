package cn.robertzhang.joke.ui.Fragment.doubi;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.joke.ui.Fragment.BaseFragment;
import cn.robertzhang.joke.ui.adapter.doubi.JokeRVAdapter;
import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/1/29.
 * email: robertzhangsh@gmail.com
 */
public class JokeFragment extends BaseFragment {

    @Bind(R.id.fragment_list_rv)
    RecyclerView fragment_list_rv;

    List<Item> list;

    @Override
    protected void onFirstUserVisible() {
        list = new ArrayList<Item>();

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
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        fragment_list_rv.setLayoutManager(llm);
        fragment_list_rv.setItemAnimator(new DefaultItemAnimator());
        fragment_list_rv.setAdapter(new JokeRVAdapter(getActivity(),list));

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
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_vp_content;
    }

    @Override
    protected void onEventComming(EventMessage eventMessage) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
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
}
