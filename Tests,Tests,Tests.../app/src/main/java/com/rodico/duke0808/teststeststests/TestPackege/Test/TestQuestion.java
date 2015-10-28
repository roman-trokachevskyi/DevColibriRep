package com.rodico.duke0808.teststeststests.TestPackege.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by duke0808 on 20.10.15.
 */
public class TestQuestion {
    String text;
    Map<Integer, String> questions;
    int rightAnswerId;
    int answeredId;

    public TestQuestion(String text, int nOfAnswers, String[] answers, int rightAnswerId) {
        questions=new HashMap<>();
        this.text = text;
        this.rightAnswerId=rightAnswerId;
        for (int i=0;i<nOfAnswers;i++){
            questions.put(i,answers[i]);
        }
    }

    public String getText() {
        return text;
    }

    public Map<Integer, String> getQuestions() {
        return questions;
    }

    public void setAnsweredId(int answeredId) {
        this.answeredId = answeredId;
    }
    public boolean isRight(){
        return rightAnswerId==answeredId;
    }
}
