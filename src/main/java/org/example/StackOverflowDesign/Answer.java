package org.example.StackOverflowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable{
    private final int id;
    private String content;
    private final User author;
    private final Date creationDate;
    private Question question;
    private final List<Comment> comments;        // check final for this List
    private final List<Vote> votes;
    private boolean isAccepted;

    public Answer(String content, User author) {
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("The answer is already accepted.");
        }
        isAccepted = true;
        author.updateReputation(15);
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

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public User getAuthor() {   return author;  }
    public int getId() {    return id;  }
    public boolean isAccepted() {   return isAccepted; }
    public Date getCreationDate() { return creationDate; }
    public List<Vote> getVotes() {  return votes;   }
    public Question getQuestion() { return question;    }
    public String getContent() {    return content; }
}
