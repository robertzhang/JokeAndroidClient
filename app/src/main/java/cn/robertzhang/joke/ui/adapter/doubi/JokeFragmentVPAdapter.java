package cn.robertzhang.joke.ui.adapter.doubi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cn.robertzhang.joke.ui.Fragment.doubi.JokeFragment;

/**
 * Created by robertzhang on 16/1/30.
 * email: robertzhangsh@gmail.com
 */
public class JokeFragmentVPAdapter extends FragmentPagerAdapter{

    private String[] titles = null;

    public JokeFragmentVPAdapter(FragmentManager fm, String[] title) {
        super(fm);
        titles = title;
    }

    @Override
    public Fragment getItem(int position) {
        JokeFragment jokeFragment = new JokeFragment();
        jokeFragment.setIndex(position);
        return jokeFragment;
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
