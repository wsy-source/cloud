package com.cloud.service.impl;

import com.cloud.service.MessageReceive;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Service
public class MessageReceiveListener implements MessageReceive {

    @Override
    public String receiveMessage(Message message) {
        return message.getPayload().toString();
    }
}
