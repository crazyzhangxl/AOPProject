package com.example.aopproject.arouter.testactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.aopproject.R;

/**
 * @author crazyZhangxl on 2019-3-6 23:46:35.
 * Describe:
 */

@Route(path = "/test/activity4")
public class Test4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        ((TextView)findViewById(R.id.test)).setText("I am " + Test4Activity.class.getName());
        String extra = getIntent().getStringExtra("extra");
        if (!TextUtils.isEmpty(extra)) {
            ((TextView)findViewById(R.id.test2)).setText(extra);
        }
    }
}
