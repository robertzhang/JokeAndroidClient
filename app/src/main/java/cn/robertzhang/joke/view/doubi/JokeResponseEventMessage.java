package cn.robertzhang.joke.view.doubi;

import java.util.List;

import cn.robertzhang.joke.model.entities.joke.Item;
import cn.robertzhang.libraries.eventbus.EventMessage;

/**
 * Created by robertzhang on 16/3/4.
 * email: robertzhangsh@gmail.com
 */
public class JokeResponseEventMessage extends EventMessage<List<Item>>{
    public JokeResponseEventMessage(int eventCode, List<Item> data) {
        super(eventCode, data);
    }
}
