package com.rodico.duke0808.teststeststests.TestPackege.TestView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rodico.duke0808.teststeststests.R;
import com.rodico.duke0808.teststeststests.TestPackege.Test.Test;
import com.rodico.duke0808.teststeststests.TestPackege.Test.TestQuestion;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
    Test currentTest;
    int idCurrentQuestion;
    TestQuestion currentQuestion;
    //Views
    TextView questionView;
    RadioGroup radioGroup;
    RadioButton radioButton0;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        questionView = (TextView) getView().findViewById(R.id.questionTv);
        radioGroup=(RadioGroup)getView().findViewById(R.id.radioGroup);
        radioButton0 = (RadioButton) getView().findViewById(R.id.answer0);
        radioButton1 = (RadioButton) getView().findViewById(R.id.answer1);
        radioButton2 = (RadioButton) getView().findViewById(R.id.answer2);
        radioButton3 = (RadioButton) getView().findViewById(R.id.answer3);

        questionView.setText(currentQuestion.getText());
        radioButton0.setText(currentQuestion.getQuestions().get(0));
        radioButton1.setText(currentQuestion.getQuestions().get(1));
        radioButton2.setText(currentQuestion.getQuestions().get(2));
        radioButton3.setText(currentQuestion.getQuestions().get(3));

        if (currentQuestion.getQuestions().get(2)==null){
            radioButton2.setVisibility(View.INVISIBLE);
        }
        if (currentQuestion.getQuestions().get(3)==null){
            radioButton3.setVisibility(View.INVISIBLE);
        }

        super.onViewCreated(view, savedInstanceState);
    }

    public void setCurrentTest(Test currentTest) {
        this.currentTest = currentTest;
    }

    public void setIdCurrentQuestion(int idCurrentQuestion) {
        this.idCurrentQuestion = idCurrentQuestion;
        currentQuestion=currentTest.getQuestionById(idCurrentQuestion);
    }
}
