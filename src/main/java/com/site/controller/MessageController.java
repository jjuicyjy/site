package com.site.controller;

import com.site.entity.Message;
import com.site.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("")
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

}