package com.dianarus.facebook.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table(name = "post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public Post(){}

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Post(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
