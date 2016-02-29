package cn.robertzhang.joke.view;

/**
 * Created by robertzhang on 16/2/16.
 * email: robertzhangsh@gmail.com
 */
public interface MainActivityInterface {
    void goToSide(int cx, int cy, boolean appBarExpanded, String side);
    void removeAllFragmentExcept(String tag);
}
