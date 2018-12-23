package com.site.repo;

import com.site.entity.Dialog;
import com.site.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findAllByDialogIdAndIsRead(Dialog dialogId, Boolean read);
}
