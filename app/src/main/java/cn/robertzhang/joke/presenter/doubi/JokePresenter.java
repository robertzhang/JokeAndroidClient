package cn.robertzhang.joke.presenter.doubi;


import cn.robertzhang.joke.R;
import cn.robertzhang.joke.app.JokeApplication;
import cn.robertzhang.joke.presenter.Presenter;
import cn.robertzhang.joke.view.JokeView;

/**
 * Created by robertzhang on 16/1/28.
 * email: robertzhangsh@gmail.com
 */
public class JokePresenter implements Presenter {

    private JokeView jokeView;

    public String[] jokeCategoryArray;

    public JokePresenter(JokeView jokeView) {
        this.jokeView = jokeView;
    }
    public JokePresenter(){
        getJokeCategoryArray();
    }

    public void getJokeCategoryArray(){
        String[] array = JokeApplication.getAppContext().
                getResources().getStringArray(R.array.joke_tab_list);
        jokeCategoryArray =  array;
    }

    @Override
    public void initialized() {
        getJokeCategoryArray();
        jokeView.initializeViews(null);
    }
}
