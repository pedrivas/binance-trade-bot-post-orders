package com.post.orders.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.post.orders.models.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    private final ObjectMapper objectMapper;

    public MessageController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void handler(String message) throws JsonProcessingException {
        Message parsedMessage = parseMessage(message);
        checkPrice(parsedMessage, 2500);
    }

    private void checkPrice(Message parsedMessage, double targetPrice) {
        double price = parsedMessage.getPrice();
        if (price <= targetPrice) {
            log.info(String.format("Valor atual de %s: %s - Compre essa caraia", parsedMessage.getSymbol(), parsedMessage.getPrice()));
        } else {
            log.info(String.format("Valor atual de %s: %s - Nem compre, ta caro", parsedMessage.getSymbol(), parsedMessage.getPrice()));
        }
    }

    public Message parseMessage(String message) throws JsonProcessingException {
        return objectMapper.readValue(message, Message.class);
    }

}
