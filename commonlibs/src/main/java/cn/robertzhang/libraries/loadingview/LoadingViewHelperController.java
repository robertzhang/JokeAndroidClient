package cn.robertzhang.libraries.loadingview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.robertzhang.libraries.R;
import cn.robertzhang.libraries.utils.CommonUtils;

/**
 * Created by robertzhang on 16/1/21.
 * email: robertzhangsh@gmail.com
 */
public class LoadingViewHelperController {

    private ILoadingViewHelper helper;

    public LoadingViewHelperController(View view) {
        this(new LoadingViewHelper(view));
    }

    public LoadingViewHelperController(ILoadingViewHelper helper) {
        super();
        this.helper = helper;
    }

    public void showNetworkError(View.OnClickListener onClickListener) {
        View layout = helper.inflate(R.layout.message);
        TextView textView = (TextView) layout.findViewById(R.id.message_info);
        textView.setText(helper.getContext().getResources().getString(R.string.common_no_network_msg));

        ImageView imageView = (ImageView) layout.findViewById(R.id.message_icon);
        imageView.setImageResource(R.drawable.ic_exception);

        if (null != onClickListener) {
            layout.setOnClickListener(onClickListener);
        }

        helper.showLayout(layout);
    }

    public void showError(String errorMsg, View.OnClickListener onClickListener) {
        View layout = helper.inflate(R.layout.message);
        TextView textView = (TextView) layout.findViewById(R.id.message_info);
        if (!CommonUtils.isEmpty(errorMsg)) {
            textView.setText(errorMsg);
        } else {
            textView.setText(helper.getContext().getResources().getString(R.string.common_error_msg));
        }

        ImageView imageView = (ImageView) layout.findViewById(R.id.message_icon);
        imageView.setImageResource(R.drawable.ic_error);

        if (null != onClickListener) {
            layout.setOnClickListener(onClickListener);
        }

        helper.showLayout(layout);
    }

    public void showEmpty(String emptyMsg, View.OnClickListener onClickListener) {
        View layout = helper.inflate(R.layout.message);
        TextView textView = (TextView) layout.findViewById(R.id.message_info);
        if (!CommonUtils.isEmpty(emptyMsg)) {
            textView.setText(emptyMsg);
        } else {
            textView.setText(helper.getContext().getResources().getString(R.string.common_empty_msg));
        }

        ImageView imageView = (ImageView) layout.findViewById(R.id.message_icon);
        imageView.setImageResource(R.drawable.ic_exception);

        if (null != onClickListener) {
            layout.setOnClickListener(onClickListener);
        }

        helper.showLayout(layout);
    }

    public void showLoading(String msg) {
        View layout = helper.inflate(R.layout.loading);
        if (!CommonUtils.isEmpty(msg)) {
            TextView textView = (TextView) layout.findViewById(R.id.loading_msg);
            textView.setText(msg);
        }
        helper.showLayout(layout);
    }

    public void restore() {
        helper.restoreView();
    }
}
