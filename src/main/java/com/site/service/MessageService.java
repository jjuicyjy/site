package com.site.service;

import com.site.entity.Dialog;
import com.site.entity.Message;
import com.site.entity.SquadDialog;
import com.site.entity.User;
import com.site.repo.DialogRepo;
import com.site.repo.MessageRepo;
import com.site.repo.SquadDialogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private SquadDialogRepo squadDialogRepo;

    @Autowired
    private DialogRepo dialogRepo;

    public Dialog createDialog(Dialog dialog){
        Dialog save = dialogRepo.save(dialog);
        squadDialogRepo.save(new SquadDialog(dialog, dialog.getUserId()));
        return save;
    }

    public void addToDialog(Dialog dialog, User user){
        if (dialogRepo.existsById(dialog.getId()) && !squadDialogRepo.existsByUserId(user)){
            squadDialogRepo.save(new SquadDialog(dialog, user));
        }
    }

    public Message sentMessage(Message message){
        message.setRead(false);
        message.setTime(LocalDateTime.now());
        return messageRepo.save(message);
    }

    public void readMessage(Dialog dialog){
        if (dialogRepo.existsById(dialog.getId())){
            List<Message> messages = messageRepo.findAllByDialogIdAndIsRead(dialog, false);
            for (Message m: messages){
                m.setRead(true);
            }
        }
    }
}
