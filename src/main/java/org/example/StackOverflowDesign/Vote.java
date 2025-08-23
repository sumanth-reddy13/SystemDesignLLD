package org.example.StackOverflowDesign;

import java.util.Date;

public class Vote {
    private final int id;
    private final User voter;
    private final VoteType voteType;
    private final Date creationDate;

    public Vote(User voter, VoteType voteType) {
        this.voter = voter;
        this.voteType = voteType;
        this.creationDate = new Date();
        this.id = generateId();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public User getVoter() {    return this.voter;  }
    public VoteType getVoteType() { return this.voteType;   }
    public int getId() {    return id;  }
    public Date getCreationDate() { return creationDate;    }
}
