package cn.robertzhang.joke.ui.adapter.wenq;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.robertzhang.joke.R;

/**
 * Created by robertzhang on 16/3/2.
 * email: robertzhangsh@gmail.com
 */
public abstract class WenQBaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    protected List<T> mList;

    public WenQBaseAdapter(List<T> mList) {
        this.mList = mList;
    }


    protected abstract int getContentViewLayoutID();

    protected abstract RecyclerView.ViewHolder getViewHolder(View view);

    protected List<T> getListData(){
        return mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getContentViewLayoutID(), null);
        return getViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    // --------- 更新操作
    public void addDatas(List<T> data) {
        getListData().addAll(data);
        notifyDataSetChanged();
    }

    public void addData(T data) {
        getListData().add(data);
        notifyDataSetChanged();
    }

    public void refreshData(T data) {
        getListData().clear();
        getListData().add(data);
        notifyDataSetChanged();
    }

    public void refreshDatas(List<T> data){
        getListData().clear();
        getListData().addAll(data);
        notifyDataSetChanged();
    }
}
