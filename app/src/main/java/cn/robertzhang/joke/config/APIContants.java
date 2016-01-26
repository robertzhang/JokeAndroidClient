package cn.robertzhang.joke.config;

/**
 * Created by zhangchao on 16/1/19.
 */
public class APIContants {

    /*
     * 糗事百科接口
     * eg: url = HOT_JOKE + page(页数)
     */
    public static final String URL_HOT_JOKE = "http://m2.qiushibaike.com/article/list/suggest?count=20&page=";

    public static final String URL_NEWST_JOKE = "http://m2.qiushibaike.com/article/list/latest?count=20&page=";

    public static final String URL_TRUTH_JOKE = "http://m2.qiushibaike.com/article/list/imgrank?count=20&page=";

    /**
     * 获取用户头像，下面参数不建议这样定义，在此是为了直观才这样定义。
     * prefixUserId = userId.substringToIndex(userId.length - 4)
     * eg:  头像 = AVATAR_JOKE + prefixUserId + "/" + userId + "/medium/" + userIcon
     */
    public static final String URL_AVATAR_JOKE = "http://pic.qiushibaike.com/system/avtnew/";

    /**
     * 获取图片
     * eg: 小图 = IMG_JOKE + prefiximageId + "/" + imageId + "/small/" + imgSrc
     *     大图 = IMG_JOKE + prefiximageId + "/" + imageId + "/medium/" + imgSrc
     */
    public static final String URL_IMG_JOKE = "http://pic.qiushibaike.com/system/pictures/";

    /*
     * one一个的接口
     */
    /**
     * 首页
     * eg. http://rest.wufazhuce.com/OneForWeb/one/getHp_N?strDate=2016-01-22&strRow=9
     */
    public static final String URL_HOME_ONE = "http://rest.wufazhuce.com/OneForWeb/one/getHp_N";
    /**
     * 文章
     */
    public static final String URL_ARTICLE_ONE = "http://rest.wufazhuce.com/OneForWeb/one/getC_N";
    /**
     * 问题
     */
    public static final String URL_QUESTION_ONE = "http://rest.wufazhuce.com/OneForWeb/one/getQ_N";
    /**
     * 东西
     */
    public static final String URL_THING_ONE = "http://rest.wufazhuce.com/OneForWeb/one/o_f";
    /**
     * 喜欢/取消喜欢
     */
    public static final String URL_LIKE_OR_CANCLELIKE = "http://bea.wufazhuce.com/OneForWeb/onest/praiseAppItemSomeId";
}
