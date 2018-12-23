package com.site.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Dialog dialogId;

    private String message;

    @DateTimeFormat(pattern = "hh:mm:ss dd:MM:yyyy")
    private LocalDateTime time;

    private boolean isRead;

    public Message() {
    }

    public Message(User userId, Dialog dialogId, String message, LocalDateTime time, boolean isRead) {
        this.userId = userId;
        this.dialogId = dialogId;
        this.message = message;
        this.time = time;
        this.isRead = isRead;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Dialog getDialogId() {
        return dialogId;
    }

    public void setDialogId(Dialog dialogId) {
        this.dialogId = dialogId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "userId=" + userId +
                ", toUser=" + dialogId +
                ", message='" + message + '\'' +
                '}';
    }
}
