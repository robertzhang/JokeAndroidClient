package cn.robertzhang.joke.ui.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import cn.robertzhang.libraries.loadingview.LoadingViewHelperController;
import cn.robertzhang.libraries.utils.CommonUtils;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public abstract class SimpleBaseFragment extends Fragment {

    private Context mContext;

    private LoadingViewHelperController mLoadingViewHelperController = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null != getLoadingTargetView()) {
            mLoadingViewHelperController = new LoadingViewHelperController(getLoadingTargetView());
        }

        View view =inflater.inflate(getContentViewLayoutID(), null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initView();
        initListener();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
//        EventBus.getDefault().unregister(this);
    }

    /**
     * init data in onCreate()
     *
     * initData()->initView()->initListener()
     */
    protected abstract void initData();

    /**
     * init view in onCreateView()
     *
     * initData()->initView()->initListener()
     * @return
     */
    protected abstract void initView();

    protected abstract int getContentViewLayoutID();

    /**
     * init Listener in onCreateView()
     *
     * initData()->initView()->initListener()
     */
    protected abstract void initListener();

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }


    //获取设置的loading view
    protected abstract View getLoadingTargetView();

    // 辅助方法，用来处理loading，error，网络错误等
    /**
     * show toast
     *
     * @param msg
     */
    protected void showToast(String msg) {
        if (null != msg && !CommonUtils.isEmpty(msg)) {
            Snackbar.make(((Activity) mContext).getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT).show();
        }
    }

    /**
     * toggle show loading
     *
     * @param toggle
     */
    protected void toggleShowLoading(boolean toggle, String msg) {
        if (null == mLoadingViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mLoadingViewHelperController.showLoading(msg);
        } else {
            mLoadingViewHelperController.restore();
        }
    }

    /**
     * toggle show empty
     *
     * @param toggle
     */
    protected void toggleShowEmpty(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mLoadingViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mLoadingViewHelperController.showEmpty(msg, onClickListener);
        } else {
            mLoadingViewHelperController.restore();
        }
    }

    /**
     * toggle show error
     *
     * @param toggle
     */
    protected void toggleShowError(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mLoadingViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mLoadingViewHelperController.showError(msg, onClickListener);
        } else {
            mLoadingViewHelperController.restore();
        }
    }

    /**
     * toggle show network error
     *
     * @param toggle
     */
    protected void toggleNetworkError(boolean toggle, View.OnClickListener onClickListener) {
        if (null == mLoadingViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mLoadingViewHelperController.showNetworkError(onClickListener);
        } else {
            mLoadingViewHelperController.restore();
        }
    }
}
