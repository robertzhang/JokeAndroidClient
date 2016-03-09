package cn.robertzhang.joke.ui.adapter.doubi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import cn.robertzhang.joke.config.Contants;
import cn.robertzhang.joke.ui.Fragment.doubi.JokeFragment;
import cn.robertzhang.libraries.utils.LogUtils;

/**
 * Created by robertzhang on 16/1/30.
 * email: robertzhangsh@gmail.com
 */
public class JokeFragmentVPAdapter extends FragmentStatePagerAdapter {

    private String[] titles = null;

    private JokeFragment mHotFragment = null;

    private JokeFragment mNewstFragment = null;

    private JokeFragment mTruthFragment = null;

    protected JokeFragment mCurrentFragment = null;

    public JokeFragmentVPAdapter(FragmentManager fm, String[] title) {
        super(fm);
        titles = title;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (mHotFragment == null) {
                    mHotFragment = new JokeFragment();
                    mHotFragment.setIndex(0);
                }
                mCurrentFragment = mHotFragment;
                break;
            case 1:
                if (mNewstFragment == null) {
                    mNewstFragment = new JokeFragment();
                    mNewstFragment.setIndex(1);
                }
                mCurrentFragment = mNewstFragment;
                break;
            case 2:
                if (mTruthFragment == null) {
                    mTruthFragment = new JokeFragment();
                    mTruthFragment.setIndex(2);
                }
                mCurrentFragment = mTruthFragment;
                break;
        }
        return mCurrentFragment;
    }

    @Override
    public int getCount() {
        return null != titles ? titles.length : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null != titles ? titles[position] : null;
    }

}
