package cn.robertzhang.joke.ui.Fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import butterknife.ButterKnife;
import cn.robertzhang.joke.ui.activity.MainActivity2;
import cn.robertzhang.joke.view.BaseView;
import cn.robertzhang.joke.widget.ClipRevealFrame;
import cn.robertzhang.libraries.base.BaseLazyFragment;
import cn.robertzhang.libraries.utils.LogUtils;

/**
 * Author:  Tau.Chen
 * Email:   1076559197@qq.com | tauchen1990@gmail.com
 * Date:    15/7/22
 * Description:
 */
public abstract class BaseFragment extends BaseLazyFragment implements BaseView {

    public static final String ARG_CX = "cx";
    public static final String ARG_CY = "cy";
    public static final String ARG_SHOULD_EXPAND = "should expand";
    protected static final long ANIM_DURATION = 500L;
    protected float mRadius;

    private View mRootView;

    public abstract @StyleRes int getTheme();
    public abstract String getTagString();

    //切换动画效果
    protected Animator createCheckoutRevealAnimator(final ClipRevealFrame view, int x, int y, float startRadius, float endRadius) {
        setMenuVisibility(false);
        Animator retAnimator;
        mRadius = endRadius;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            retAnimator = ViewAnimationUtils.createCircularReveal(view, x, y, startRadius, endRadius);
        } else {
            view.setClipOutLines(true);
            view.setClipCenter(x, y);
            view.setClipRadius(startRadius);

            retAnimator = ObjectAnimator.ofFloat(view, "clipRadius", startRadius, endRadius);
        }
        retAnimator.setDuration(ANIM_DURATION);
        retAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setClipOutLines(false);
                removeOldSideFragment();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        retAnimator.setInterpolator(new AccelerateInterpolator(2.0f));
        return retAnimator;
    }

    private void removeOldSideFragment() {
        LogUtils.E("zhangchao","===removeOldSideFragment==="+getTagString());
        ((MainActivity2) mContext).removeAllFragmentExcept(getTagString());
    }

    public void onSideSwitch(View v) {
        Rect rect = new Rect();
        v.getGlobalVisibleRect(rect);
        final int cy = rect.centerY() - getStatusBarHeight();
//        final int halfThumbWidth = v.getThumbDrawable().getIntrinsicWidth() / 2;
        final int cx = rect.centerX();

        if (getTagString().equals("doubi")) {
            postGoToSide(cy,cx,"wenqing");
        } else {
            postGoToSide(cy,cx,"doubi");
        }

//        if (this instanceof JokeMainFragment && v.isChecked()) {
//            cx = rect.right - halfThumbWidth;
//            postGoToSide(cy, cx, "doubi");
//        } else if (!v.isChecked()){
//            cx = rect.left + halfThumbWidth;
//            postGoToSide(cy, cx, "wenqing");
//        }
    }

    private void postGoToSide(final int cy, final int cx, final String side) {
        new android.os.Handler().post(new Runnable() {
            @Override
            public void run() {
                ((MainActivity2)mContext).goToSide(cx, cy, isAppBarExpanded(), side);
            }
        });
    }

    protected abstract boolean isAppBarExpanded();

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.cloneInContext(new ContextThemeWrapper(getContext(), getTheme()))
                .inflate(getContentViewLayoutID(), container, false);
        final Bundle args = getArguments();
        if (args != null) {
            mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop,
                                           int oldRight, int oldBottom) {
                    v.removeOnLayoutChangeListener(this);
                    int cx = args.getInt("cx");
                    int cy = args.getInt("cy");
                    // get the hypothenuse so the mRadius is from one corner to the other
                    float radius = (float) Math.hypot(right, bottom);

                    // Hardware-supported clipPath()
                    // http://developer.android.com/guide/topics/graphics/hardware-accel.html
                    if (Build.VERSION.SDK_INT >= 18) {
                        Animator reveal = createCheckoutRevealAnimator((ClipRevealFrame) v, cx, cy, 28f, radius);
                        reveal.start();
                    } else {
                        removeOldSideFragment();
                    }
                }
            });
        }

        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    // implements BaseView
    @Override
    public void showError(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showException(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showLoading(String msg) {
        toggleShowLoading(true, null);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false, null);
    }

}
