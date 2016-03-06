package cn.robertzhang.libraries.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by robertzhang on 16/2/1.
 * email: robertzhangsh@gmail.com
 */
public abstract class AutoRVAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    public List<T> list;

    private Context context;

    public AutoRVAdapter(Context context, List<T> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(onCreateViewLayoutID(viewType), null);

        return BaseViewHolder.getViewHolder(view);
    }

    public abstract int onCreateViewLayoutID(int viewType);


    @Override
    public void onViewRecycled(final BaseViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {

        onBindBaseViewHolder(holder.getViewHolder(), position);
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(null, v, holder.getPosition(), holder.getItemId());
                }
            });
        }

    }

    public abstract void onBindBaseViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return list.size();
    }

    private AdapterView.OnItemClickListener onItemClickListener;

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
