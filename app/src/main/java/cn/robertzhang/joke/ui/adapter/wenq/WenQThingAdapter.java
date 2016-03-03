package cn.robertzhang.joke.ui.adapter.wenq;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.model.entities.one.Thing;
import cn.robertzhang.libraries.utils.TimeUtil;

/**
 * Created by robertzhang on 16/3/3.
 * email: robertzhangsh@gmail.com
 */
public class WenQThingAdapter extends WenQBaseAdapter<Thing> {

    public WenQThingAdapter(List<Thing> mList) {
        super(mList);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_wenq_thing;
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder vh = (ViewHolder) holder;
        vh.textThingDate.setText(TimeUtil.getEngDate(mList.get(position).getStrTm()));
        vh.textThingName.setText(mList.get(position).getStrTt());
        vh.textThingIntro.setText(mList.get(position).getStrTc());
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
//                TextToast.shortShow("加载失败:" + throwable.toString());
            }

            @Override
            public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
                super.onIntermediateImageSet(id, imageInfo);
            }

            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (imageInfo == null) {
                    return;
                }
                float rate = (float) imageInfo.getWidth() / (float) imageInfo.getHeight();
                vh.dvThing.setAspectRatio(rate);
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(mList.get(position).getStrBu()))
                .setControllerListener(controllerListener)
                .build();
        vh.dvThing.setController(controller);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_thing_date)
        TextView textThingDate;
        @Bind(R.id.dv_thing)
        SimpleDraweeView dvThing;
        @Bind(R.id.text_thing_name)
        TextView textThingName;
        @Bind(R.id.text_thing_intro)
        TextView textThingIntro;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
