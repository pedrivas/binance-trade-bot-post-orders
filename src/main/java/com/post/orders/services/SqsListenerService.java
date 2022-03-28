package com.post.orders.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.post.orders.controller.MessageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqsListenerService {

    @Autowired
    private final MessageController messageController;

    public SqsListenerService(MessageController messageController) {
        this.messageController = messageController;
    }

    @SqsListener("https://sqs.sa-east-1.amazonaws.com/258969145002/binance-prices-queue.fifo")
    public void receiveMessage( String message ) throws JsonProcessingException {

        messageController.handler(message);

    }

}
