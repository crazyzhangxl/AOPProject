package com.example.aopproject.arouter.testactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.aopproject.R;

/**
 * @author crazyZhangxl on 2019-3-6 22:13:52.
 * Describe:
 */

@Route(path = "/test/activity2")
public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        aRouterIntent();

    }

    private void aRouterIntent() {
        String value = getIntent().getStringExtra("key1");
        if (!TextUtils.isEmpty(value)) {
            Toast.makeText(this, "exist param :" + value, Toast.LENGTH_LONG).show();
        }
        setResult(999);
    }
}
