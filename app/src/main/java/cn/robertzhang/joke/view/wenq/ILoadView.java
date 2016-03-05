package cn.robertzhang.joke.view.wenq;

/**
 * Created by robertzhang on 16/2/29.
 * email: robertzhangsh@gmail.com
 */
public interface ILoadView<T>{
    /**
     * type表示针对不同动作做不同的刷新
     */
    void refreshUI(T m, int type);
    void loadError(int type);
}
