package com.rodico.duke0808.myapplication.activity.AsynkTask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rodico.duke0808.myapplication.R;

import java.util.concurrent.ExecutionException;

public class AsyncTaskActivity extends AppCompatActivity {
    static Context context;
   static ProgressBar progressBar;
    static TextView textView;
    static Button startButton;
    MyProgressBarAsyncTask myProgressBarAsyncTask;
    static TextView resTV;
    static Button cancelBT;
    static Button statusBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        context=this;
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        textView=(TextView) findViewById(R.id.progressTV);
         startButton = (Button) findViewById(R.id.startBT);
        myProgressBarAsyncTask=new MyProgressBarAsyncTask();
        cancelBT = (Button) findViewById(R.id.cancelBT);
        resTV=(TextView) findViewById(R.id.resTV);
        statusBT = (Button) findViewById(R.id.statusBT);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProgressBarAsyncTask=new MyProgressBarAsyncTask();
                if (myProgressBarAsyncTask.getProgressBarVal()==0) {
                    myProgressBarAsyncTask.execute();
                }
            }
        });
        cancelBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!myProgressBarAsyncTask.isCancelled()){
                    myProgressBarAsyncTask.cancel(false);
                    }
            }
        });
        statusBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resTV.setText(myProgressBarAsyncTask.getStatus().toString());
            }
        });
    }
}
