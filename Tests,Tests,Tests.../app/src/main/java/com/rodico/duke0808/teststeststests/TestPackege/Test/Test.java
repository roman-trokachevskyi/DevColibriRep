package com.rodico.duke0808.teststeststests.TestPackege.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by duke0808 on 20.10.15.
 */
public class Test {
    String infoAboutTest;
    String name;
    ArrayList<TestQuestion> questionArrayList;
    public int counterOfRight;

    public Test(String name, String infoAboutTest, ArrayList<TestQuestion> questionArrayList) {
        this.name = name;
        this.infoAboutTest = infoAboutTest;
        this.questionArrayList = questionArrayList;
        this.counterOfRight=0;
    }
    public boolean setAnswer(int questionIndex, int answerId){
        TestQuestion question = questionArrayList.get(questionIndex);
        question.setAnsweredId(answerId);
        return question.isRight();
    }

    @Override
    public String toString() {
        return name+"  ("+questionArrayList.size()+" вопр.)";
    }

    public String getInfoAboutTest() {
        return infoAboutTest;
    }

    public TestQuestion getQuestionById(int id){
        return questionArrayList.get(id);
    }

    public int getNumberOfQuestions(){
        return questionArrayList.size();
    }
    public String getResult(){
        return "You must override this method during creating test";
    }

    public int getCounterOfRight() {
        return counterOfRight;
    }

    public ArrayList<TestQuestion> getQuestionArrayList() {
        return questionArrayList;
    }

    public String getName() {
        return name;
    }
}
