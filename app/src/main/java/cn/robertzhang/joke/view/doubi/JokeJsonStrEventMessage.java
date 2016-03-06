package cn.robertzhang.joke.view.doubi;

import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/3/4.
 * email: robertzhangsh@gmail.com
 */
public class JokeJsonStrEventMessage extends EventMessage<String> {

    public JokeJsonStrEventMessage(int eventCode, String data) {
        super(eventCode, data);
    }
}
