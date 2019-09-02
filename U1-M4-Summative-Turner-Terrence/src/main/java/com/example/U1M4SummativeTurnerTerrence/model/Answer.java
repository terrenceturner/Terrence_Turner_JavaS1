package com.example.U1M4SummativeTurnerTerrence.model;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class Answer {

    @NotEmpty(message = "You must supply a value for question")
    private String question;

    @NotEmpty(message = "You must supply a value for answer")
    private String answer;

    public Answer(@NotEmpty(message = "You must supply a value for question") String question,
                  @NotEmpty(message = "You must supply a value for answer") String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static List<Answer> answers = new ArrayList<>();

    public static List<Answer> getAnswers() {
        return answers;
    }

    public static void setAnswers(List<Answer> answers) {
        Answer.answers = answers;
    }
}
