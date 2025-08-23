package org.example.StackOverflowDesign;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<Integer, Tag> tags;
    private final Map<Integer, User> users;

    public StackOverflow() {
        questions = new ConcurrentHashMap<>();   // Know more about this.
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
        users = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email) {
        User user = new User(username, email);
        users.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        Question question = user.askQuestion(title, content, tags);
        questions.put(question.getId(), question);
        for (Tag tag : question.getTags()) {
            this.tags.putIfAbsent(tag.getId(), tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.answerQuestion(content);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(User user, String content, Commentable commentable) {
        Comment comment = new Comment(content, user);
        return comment;
    }

    public void voteQuestion(User voter, Question question, VoteType voteType) {
        question.vote(voter, voteType);
    }

    public void voteAnswer(User voter, Answer answer, VoteType voteType) {
        answer.vote(voter, voteType);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }

    public Question getQuestion(int id) {   return questions.get(id); }
    public Answer getAnswer(int id) {   return answers.get(id); }
    public User getUser(int id) {   return users.get(id); }
    public Tag getTag(int id) {   return tags.get(id); }
}

