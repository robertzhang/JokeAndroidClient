package cn.robertzhang.joke.view.doubi;

import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/3/5.
 * email: robertzhangsh@gmail.com
 */
public class JokeErrorMessageEvent extends EventMessage<Integer>{
    public JokeErrorMessageEvent(int eventCode) {
        super(eventCode);
    }
}
