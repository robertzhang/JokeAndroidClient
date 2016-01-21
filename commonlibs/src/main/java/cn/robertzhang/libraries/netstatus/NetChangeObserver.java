package cn.robertzhang.libraries.netstatus;

import cn.robertzhang.libraries.utils.NetUtils;

/**
 * Created by robertzhang on 16/1/20.
 * email: robertzhangsh@gmail.com
 */
public abstract class NetChangeObserver {

    /**
     * when network connected callback
     */
    public abstract void onNetConnected(NetUtils.NetType type) ;

    /**
     *  when network disconnected callback
     */
    public abstract void onNetDisConnect() ;

}
