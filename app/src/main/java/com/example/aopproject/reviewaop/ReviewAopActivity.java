package com.example.aopproject.reviewaop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aopproject.R;
import com.example.aopproject.reviewaop.figuretime.FigureTimeTrace;

public class ReviewAopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_aop);

        haveLunch();
        enjoyGame();
    }

    @FigureTimeTrace
    public void haveLunch(){
        for (int i=0;i<50;i++){

        }
    }

    @FigureTimeTrace
    public void enjoyGame(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
