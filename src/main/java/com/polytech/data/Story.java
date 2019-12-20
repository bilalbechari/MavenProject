package com.polytech.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Story {

    int id;
    String content;

    public Story() {  }

    public Story(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}