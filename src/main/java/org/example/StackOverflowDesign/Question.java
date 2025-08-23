package org.example.StackOverflowDesign;

import java.util.ArrayList;
import java.util.List;

public class Question implements Votable, Commentable{
    private final int id;
    private String title;
    private String content;
    private final User author;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(String title, String content, User author, List<String> tags) {
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = author;
        answers = new ArrayList<>();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        for (String name : tags) {
            this.tags.add(new Tag(name));
        }
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addAnswer(Answer answer) {
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
    }
    @Override
    public void vote(User voter, VoteType voteType) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, voteType));
        author.updateReputation(5 * ((voteType == VoteType.UPVOTE) ? 1 : -1));
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v -> v.getVoteType() == VoteType.UPVOTE ? 1 : -1)
                .sum();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    public int getId() { return id; }
    public User getAuthor() {   return author;  }
    public String getTitle() {  return this.title;}
    public Answer getAcceptedAnswer() { return acceptedAnswer;  }
    public List<Answer> getAnswers() {  return answers; }
    public List<Vote> getVotes() {  return votes;   }
    public String getContent() {    return content; }
    public List<Tag> getTags() {    return tags;    }

    @Override
    public String toString() {
        return "title: " + this.title + "\n" + "content: " + this.content;
    }
}

