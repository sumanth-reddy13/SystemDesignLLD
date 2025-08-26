package org.example.StackOverflowDesign;

import java.util.List;

public class StackOverflowDemo {
    public static void main(String[] args) {
        StackOverflow system = new StackOverflow();
        User sumanth = system.createUser("Sumanth", "sumanthdamma@gmail.com");
        User jyoshna = system.createUser("Jyoshna", "Jyo@gmail.com");
        User raji = system.createUser("Raji", "raji@gmail.com");

        Question aiQuestion = system.askQuestion(sumanth, "what is AI?",
                                                "Can anyone explain what is AI?",
                                                List.of("AI", "GPT", "CS"));

        Answer answer = system.answerQuestion(jyoshna, aiQuestion,
                                        "AI is a field of CS where a machine is " +
                                                "trained using data to perform tasks.");

        system.addComment(raji, "ChatGPT is a AI model that can perform multi modal tasks.", aiQuestion);

        system.acceptAnswer(answer);

        system.voteQuestion(raji, aiQuestion, VoteType.UPVOTE);
        system.voteAnswer(sumanth, answer, VoteType.UPVOTE);

        System.out.println(system.getQuestionsByUser(sumanth));
        system.searchQuestionByQuery("what");

        system.getUsers();
    }
}
