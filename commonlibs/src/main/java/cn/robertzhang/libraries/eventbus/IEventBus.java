package cn.robertzhang.libraries.eventbus;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */


/*******************************
 *
 *
 *  EventBus 升级到3.0，以下方法弃用
 *
 *
 * ****************************
 */
public abstract interface IEventBus {

    /*
     * 可根据需要对下面的抽象方法进行隐藏
     */

    /**
     * 事件在哪个线程发布出来的，onEvent就会在这个线程中运行
     * @param eventMessage
     */
    public abstract void onEvent(EventMessage eventMessage);

    /**
     * UI线程中执行
     * @param eventMessage
     */
    public abstract void onEventMainThread(EventMessage eventMessage);

    /**
     * 在子线程中运行
     * @param eventMessage
     */
    public abstract void onEventBackground(EventMessage eventMessage);

    /**
     * 无论事件在哪个线程发布，都会创建新的子线程再执行
     * @param eventMessage
     */
    public abstract void onEventAsync(EventMessage eventMessage);
}
