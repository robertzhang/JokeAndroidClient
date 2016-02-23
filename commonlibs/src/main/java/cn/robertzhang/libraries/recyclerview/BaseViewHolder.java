package cn.robertzhang.libraries.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by robertzhang on 16/2/1.
 * email: robertzhangsh@gmail.com
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> viewHolder;
    private View view;

    public static BaseViewHolder getViewHolder(View view){
        BaseViewHolder viewHolder = (BaseViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new BaseViewHolder(view);
            view.setTag(viewHolder);
        }
        return viewHolder;
    }

    public BaseViewHolder getViewHolder() {
        return this;
    }
    private BaseViewHolder(View view) {
        super(view);
        this.view = view;
        viewHolder = new SparseArray<View>();
        view.setTag(viewHolder);
    }
    public <T extends View> T get(int id) {
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    public View getConvertView() {
        return view;
    }

    public TextView getTextView(int id) {

        return get(id);
    }
    public Button getButton(int id) {

        return get(id);
    }

    public ImageView getImageView(int id) {
        return get(id);
    }

    public void setTextView(int  id,CharSequence charSequence){
        getTextView(id).setText(charSequence);
    }

}
