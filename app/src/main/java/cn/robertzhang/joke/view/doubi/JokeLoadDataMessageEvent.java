package cn.robertzhang.joke.view.doubi;

import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/3/4.
 * email: robertzhangsh@gmail.com
 */
public class JokeLoadDataMessageEvent extends EventMessage<Integer>{

    public JokeLoadDataMessageEvent(int eventCode, Integer data) {
        super(eventCode, data);
    }
}
