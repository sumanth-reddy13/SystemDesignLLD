package org.example.StackOverflowDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private String username;
    private String email;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private int reputation;

    public User(String username, String email) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(title, content, this, tags);
        questions.add(question);
        return question;
    }

    public Answer answerQuestion(String content) {
        Answer answer = new Answer(content, this);
        answers.add(answer);
        return answer;
    }

    public Comment addComment(String content, Commentable commentable) {
        Comment comment = new Comment(content, this);
        comments.add(comment);
        commentable.addComment(comment);
        return comment;
    }

    public void updateReputation(int reputation) {
        this.reputation += reputation;
        if (reputation < 0) {
            this.reputation = 0;
        }
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public String getId() {    return id;  }
    public int getReputation() {    return reputation;  }
    public List<Answer> getAnswers() {  return answers; }
    public List<Comment> getComments() {    return comments;    }
    public List<Question> getQuestions() {  return questions;   }
    public String getEmail() {  return email;   }
    public String getUsername() {   return username;    }

    @Override
    public String toString() {
        return  "Id: " + this.id + "\n" +
                "name: " + this.username + "\n" +
                "email: " + this.email + "\n" +
                "reputation: " + this.reputation;
    }
}
