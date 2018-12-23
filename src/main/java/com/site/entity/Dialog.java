package com.site.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Dialog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User userId;

    public Dialog() {
    }

    public Dialog(String name, User userId) {
        this.name = name;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Dialog dialog = (Dialog) o;
        return id == dialog.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
