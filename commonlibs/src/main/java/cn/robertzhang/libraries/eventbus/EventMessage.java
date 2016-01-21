package cn.robertzhang.libraries.eventbus;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public class EventMessage<T> {

    /**
     * reserved data
     */
    private T data;

    /**
     * this code distinguish between different events
     */
    private int eventCode = -1;

    public EventMessage(int eventCode) {
        this(eventCode, null);
    }

    public EventMessage(int eventCode, T data) {
        this.eventCode = eventCode;
        this.data = data;
    }

    /**
     * get event code
     *
     * @return
     */
    public int getEventCode() {
        return this.eventCode;
    }

    /**
     * get event reserved data
     *
     * @return
     */
    public T getData() {
        return this.data;
    }
}
