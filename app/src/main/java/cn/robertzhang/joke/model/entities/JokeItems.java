package cn.robertzhang.joke.model.entities;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class JokeItems {
    private String format;
    private Object image;
    private int published_at;
    private String tag;
    private JokeUser user;
    private int id;
    /**
     * down : -394
     * up : 18385
     */

    private JokeVotes jokeVotes;
    private int created_at;
    private String content;
    private String state;
    private int comments_count;
    private boolean allow_comment;
    private int share_count;
    private String type;


    // video使用的json参数
    private String high_url;
    private String low_url;
    private String pic_url; // video图片
    private String loop; // 循环次数


    public void setFormat(String format) {
        this.format = format;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public void setPublished_at(int published_at) {
        this.published_at = published_at;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setUser(JokeUser user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJokeVotes(JokeVotes jokeVotes) {
        this.jokeVotes = jokeVotes;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public void setAllow_comment(boolean allow_comment) {
        this.allow_comment = allow_comment;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public Object getImage() {
        return image;
    }

    public int getPublished_at() {
        return published_at;
    }

    public String getTag() {
        return tag;
    }

    public JokeUser getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public JokeVotes getJokeVotes() {
        return jokeVotes;
    }

    public int getCreated_at() {
        return created_at;
    }

    public String getContent() {
        return content;
    }

    public String getState() {
        return state;
    }

    public int getComments_count() {
        return comments_count;
    }

    public boolean isAllow_comment() {
        return allow_comment;
    }

    public int getShare_count() {
        return share_count;
    }

    public String getType() {
        return type;
    }

    public String getHigh_url() {
        return high_url;
    }

    public void setHigh_url(String high_url) {
        this.high_url = high_url;
    }

    public String getLow_url() {
        return low_url;
    }

    public void setLow_url(String low_url) {
        this.low_url = low_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }
}
