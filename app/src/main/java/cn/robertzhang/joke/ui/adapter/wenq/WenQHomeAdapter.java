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
import cn.robertzhang.joke.model.entities.one.Home;
import cn.robertzhang.libraries.utils.TimeUtil;

/**
 * Created by robertzhang on 16/3/2.
 * email: robertzhangsh@gmail.com
 */
public class WenQHomeAdapter extends WenQBaseAdapter<Home> {


    public WenQHomeAdapter(List<Home> mList) {
        super(mList);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_wenq_home;
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder vh = (ViewHolder) holder;
        vh.sayingTitle.setText(mList.get(position).getStrHpTitle());
        vh.textDay.setText(TimeUtil.getDay(mList.get(position).getStrMarketTime()));
        vh.textMonth.setText(TimeUtil.getMonthAndYear(mList.get(position).getStrMarketTime()));
        vh.textIllustrationAuthor.setText(mList.get(position).getStrAuthor().replace("&", "\n"));
        vh.textSaying.setText(mList.get(position).getStrContent());

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
                vh.dvIllustrator.setAspectRatio(rate);
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(mList.get(position).getStrThumbnailUrl()))
                .setControllerListener(controllerListener)
        .build();
        vh.dvIllustrator.setController(controller);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.saying_title)
        TextView sayingTitle;
        @Bind(R.id.dv_illustrator)
        SimpleDraweeView dvIllustrator;
        @Bind(R.id.text_illustration_author)
        TextView textIllustrationAuthor;
        @Bind(R.id.text_day)
        TextView textDay;
        @Bind(R.id.text_month)
        TextView textMonth;
        @Bind(R.id.text_saying)
        TextView textSaying;

        public ViewHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
        }
    }
}
