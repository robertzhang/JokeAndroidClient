package cn.robertzhang.joke.ui.adapter.doubi;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import java.util.List;

import cn.robertzhang.joke.R;
import cn.robertzhang.joke.config.APIContants;
import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.libraries.recyclerview.AutoRVAdapter;
import cn.robertzhang.libraries.recyclerview.BaseViewHolder;
import cn.robertzhang.libraries.utils.LogUtils;
import cn.robertzhang.libraries.utils.TimeUtil;
import cn.robertzhang.libraries.utils.ViewUtils;

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

        if (item != null) {
            if (item.getUser() != null) {
                bvh.getTextView(R.id.cardview_avator_tv).setText(item.getUser().getLogin());

                final SimpleDraweeView cardview_avator_iv = (SimpleDraweeView)bvh.getImageView(R.id.cardview_avator_iv);
                ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        super.onFailure(id, throwable);
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
                        cardview_avator_iv.setAspectRatio(rate);
                    }
                };
                String userid = item.getUser().getId().toString();
                String userimageurl = APIContants.URL_AVATAR_JOKE + userid.substring(0,userid.length()-4) +
                        "/"+userid+"/medium/"+item.getUser().getIcon();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(userimageurl))
                        .setControllerListener(controllerListener)
                        .build();
                cardview_avator_iv.setController(controller);
            } else {
                bvh.getTextView(R.id.cardview_avator_tv).setText("");
                bvh.getImageView(R.id.cardview_avator_iv).setImageResource(R.drawable.icon_contact_list_default_round_photo);
            }

            final SimpleDraweeView cardview_siv = (SimpleDraweeView)bvh.getImageView(R.id.cardview_siv);
            if (item.getImage() == null) {
                ViewUtils.hideView(cardview_siv);
            } else {
                ViewUtils.showView(cardview_siv);
                ControllerListener controllerListener1 = new BaseControllerListener<ImageInfo>() {
                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        super.onFailure(id, throwable);
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
                        cardview_siv.setAspectRatio(rate);
                    }
                };
                String imageid = item.getId().toString();
                String imageurl = APIContants.URL_IMG_JOKE + imageid.substring(0, imageid.length() - 4) +
                        "/"+ imageid+"/medium/"+item.getImage();
                        DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(imageurl))
                        .setControllerListener(controllerListener1)
                        .build();
                cardview_siv.setController(controller1);
            }

            bvh.getTextView(R.id.cardview_tv).setText(item.getContent());
//            bvh.getTextView(R.id.cardview_data).setText(TimeUtil.getDate(item.getCreated_at().toString()));
        }
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
