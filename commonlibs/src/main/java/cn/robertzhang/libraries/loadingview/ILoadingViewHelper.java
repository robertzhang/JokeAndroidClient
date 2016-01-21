package cn.robertzhang.libraries.loadingview;

import android.content.Context;
import android.view.View;

/**
 * Created by robertzhang on 16/1/21.
 * email: robertzhangsh@gmail.com
 */
public interface ILoadingViewHelper {

    public abstract View getCurrentLayout();

    public abstract void restoreView();

    public abstract void showLayout(View view);

    public abstract View inflate(int layoutId);

    public abstract Context getContext();

    public abstract View getView();

}
