package com.site.controller;

import com.site.entity.Dialog;
import com.site.entity.Message;
import com.site.entity.User;
import com.site.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/createDialog")
    public Dialog createDialog(Dialog dialog){
        if (dialog.getUserId() == null){
            return null;
        }
        return messageService.createDialog(dialog);
    }

    @PostMapping("/addToDialog")
    public Dialog addToDialog(Dialog dialog, User user){
        if (dialog.getUserId() == null){
            return null;
        }
        messageService.addToDialog(dialog, user);
        return dialog;
    }

    @PostMapping("/sent")
    public Message sentMessage(Message message){
        if (message.getMessage().isEmpty() || message.getUserId() == null || message.getDialogId() == null){
            return null;
        }
        return messageService.sentMessage(message);
    }

    @GetMapping("/read")
    public void readMessage(Dialog dialog){
        messageService.readMessage(dialog);
    }
}
