package org.example.StackOverflowDesign;

public interface Votable {
    void vote(User voter, VoteType voteType);
    int getVoteCount();
}
