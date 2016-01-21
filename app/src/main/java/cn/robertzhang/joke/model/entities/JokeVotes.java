package cn.robertzhang.joke.model.entities;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class JokeVotes {
    private int down;
    private int up;

    public void setDown(int down) {
        this.down = down;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public int getUp() {
        return up;
    }
}
