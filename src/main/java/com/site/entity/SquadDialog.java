package com.site.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SquadDialog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Dialog dialogId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User userId;

    public SquadDialog() {
    }

    public SquadDialog(Dialog dialogId, User userId) {
        this.dialogId = dialogId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dialog getDialogId() {
        return dialogId;
    }

    public void setDialogId(Dialog dialogId) {
        this.dialogId = dialogId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquadDialog that = (SquadDialog) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SquadDialog{" +
                "dialogId=" + dialogId +
                ", userId=" + userId +
                '}';
    }
}
