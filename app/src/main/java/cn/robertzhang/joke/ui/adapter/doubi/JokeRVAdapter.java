package cn.robertzhang.joke.ui.adapter.doubi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.robertzhang.joke.R;
import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.libraries.recyclerview.AutoRVAdapter;
import cn.robertzhang.libraries.recyclerview.BaseViewHolder;
import cn.robertzhang.libraries.utils.TimeUtil;

/**
 * Created by robertzhang on 16/2/1.
 * email: robertzhangsh@gmail.com
 */
public class JokeRVAdapter extends AutoRVAdapter<Item>{

    public JokeRVAdapter(Context context, List<Item> list) {
        super(context, list);
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.list_item;
    }

    @Override
    public void onBindBaseViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = (Item)list.get(position);
        BaseViewHolder bvh = (BaseViewHolder)holder;

        bvh.getTextView(R.id.cardview_avator_tv).setText(item.getUser().getLogin());
        bvh.getImageView(R.id.cardview_avator_iv).setImageResource(R.mipmap.ic_launcher);
        bvh.getImageView(R.id.cardview_siv).setImageResource(R.mipmap.ic_launcher);
        bvh.getTextView(R.id.cardview_tv).setText(item.getContent());
        bvh.getTextView(R.id.cardview_data).setText(TimeUtil.getDate(item.getCreated_at().toString()));
    }

    public void addData(List<Item> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void refreshData(List<Item> data) {
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

}
