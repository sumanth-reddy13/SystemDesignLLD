package org.example.StackOverflowDesign;

import java.util.Date;

public class Comment {
    private final int id;
    private String content;
    private final User author;
    private final Date creationDate;

    public Comment(String content, User author) {
        this.content = content;
        this.author = author;
        this.id = generateId();
        this.creationDate = new Date();
    }

    public User getAuthor() {   return author;  }
    public int getId() {    return id;  }
    public Date getCreationDate() { return creationDate;    }
    public String getContent() {    return content; }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
