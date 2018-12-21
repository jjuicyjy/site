package com.site.service;

import com.site.entity.Message;
import com.site.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Message sendMessage(Message message){
        return messageRepo.save(message);
    }
}
