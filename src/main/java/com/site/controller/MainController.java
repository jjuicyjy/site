package com.site.controller;

import com.site.entity.Message;
import com.site.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/message")
    public Message greeting(@RequestParam(defaultValue="World") String text) {
        Message message = new Message();
        message.setText(text);
        messageService.sendMessage(message);
        return message;
    }

}