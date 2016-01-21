package cn.robertzhang.joke.model.entities;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class JokeUser {

    /**
     * avatar_updated_at : 1449531682
     * last_visited_at : 1442700089
     * created_at : 1442700089
     * state : active
     * last_device : android_8.1.1
     * role : n
     * login : 大哥，别喷我
     * id : 30314175
     * icon : 20151207234121.jpg
     */

    private int avatar_updated_at;
    private int last_visited_at;
    private int created_at;
    private String state;
    private String last_device;
    private String role;
    private String login;
    private int id;
    private String icon;

    public void setAvatar_updated_at(int avatar_updated_at) {
        this.avatar_updated_at = avatar_updated_at;
    }

    public void setLast_visited_at(int last_visited_at) {
        this.last_visited_at = last_visited_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLast_device(String last_device) {
        this.last_device = last_device;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getAvatar_updated_at() {
        return avatar_updated_at;
    }

    public int getLast_visited_at() {
        return last_visited_at;
    }

    public int getCreated_at() {
        return created_at;
    }

    public String getState() {
        return state;
    }

    public String getLast_device() {
        return last_device;
    }

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }
}
