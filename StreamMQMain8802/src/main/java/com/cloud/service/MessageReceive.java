package com.cloud.service;

import org.springframework.messaging.Message;

public interface MessageReceive {
    String receiveMessage(Message message);
}
