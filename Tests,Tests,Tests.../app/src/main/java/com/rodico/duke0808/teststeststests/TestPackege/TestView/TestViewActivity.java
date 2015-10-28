package com.rodico.duke0808.teststeststests.TestPackege.TestView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rodico.duke0808.teststeststests.ChooseActivity;
import com.rodico.duke0808.teststeststests.R;
import com.rodico.duke0808.teststeststests.TestPackege.Test.Test;
import com.rodico.duke0808.teststeststests.TestPackege.Test.TestQuestion;
import com.rodico.duke0808.teststeststests.TestPackege.TestResult.ResultViewActivity;

public class TestViewActivity extends AppCompatActivity {
    public static Test currentTest;
    TestQuestion currentQuestion;
    int idCurrentQuestion;
    QuestionFragment fragment;
    QuestionFragment fragmentNext;
    RelativeLayout root;
    FragmentManager fragmentManager;
    ImageButton backBt;
    ImageButton nextBt;
    ImageView backGroundIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        root = (RelativeLayout) findViewById(R.id.root_view);
        fragmentManager = getSupportFragmentManager();
        if (ChooseActivity.getSelectedTest()==null){
            finish();
        } else {
            currentTest = ChooseActivity.getSelectedTest();
            idCurrentQuestion=0;
            currentQuestion=currentTest.getQuestionById(idCurrentQuestion);
            fragment = new QuestionFragment();
            fragment.setCurrentTest(currentTest);
            fragment.setIdCurrentQuestion(idCurrentQuestion);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(root, new Fade());
            }
            fragmentManager.beginTransaction().add(R.id.questionContainer,fragment,"fr1").commit();
            backBt = (ImageButton) findViewById(R.id.backBt);
            nextBt = (ImageButton) findViewById(R.id.forwrdBt);
        }
        backGroundIv = (ImageView) findViewById(R.id.imageViewView);
        backGroundIv.setImageResource(R.drawable.background);
    }

    public void onBackClick(View v){
        if (idCurrentQuestion==0){
            finish();
        } else {
            idCurrentQuestion--;
            currentQuestion=currentTest.getQuestionById(idCurrentQuestion);
            fragmentNext = new QuestionFragment();
            fragmentNext.setCurrentTest(currentTest);
            fragmentNext.setIdCurrentQuestion(idCurrentQuestion);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(root, new Fade());
            }
            fragmentManager.beginTransaction().replace(R.id.questionContainer, fragmentNext, "fr2").commit();
        }
    }

    public void onForvardClick(View v){
        if (idCurrentQuestion==currentTest.getNumberOfQuestions()-1){
            Intent intent = new Intent(this, ResultViewActivity.class);
            for (TestQuestion question : currentTest.getQuestionArrayList()){
                if (question.isRight()) currentTest.counterOfRight++;
            }
            startActivity(intent);
        } else {
            idCurrentQuestion++;
            currentQuestion=currentTest.getQuestionById(idCurrentQuestion);
            fragmentNext = new QuestionFragment();
            fragmentNext.setCurrentTest(currentTest);
            fragmentNext.setIdCurrentQuestion(idCurrentQuestion);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(root, new Fade());
            }
            fragmentManager.beginTransaction().replace(R.id.questionContainer, fragmentNext, "fr2").commit();
        }
    }
    public void onRadioClick(View v) {
        switch (v.getId()){
            case R.id.answer0:
                currentQuestion.setAnsweredId(0); break;
            case R.id.answer1:
                currentQuestion.setAnsweredId(1); break;
            case R.id.answer2:
                currentQuestion.setAnsweredId(2); break;
            case R.id.answer3:
                currentQuestion.setAnsweredId(3); break;
        }
    }

    public static Test getCurrentTest() {
        return currentTest;
    }
}
