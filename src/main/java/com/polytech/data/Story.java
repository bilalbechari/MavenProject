package com.polytech.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Story {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "content")
    String content;

    public Story() { }

    public Story(String content){
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}