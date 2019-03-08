package com.example.aopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopproject.arouter.ARouterMainActivity;
import com.example.aopproject.login_demo.UserActivity;

import java.text.SimpleDateFormat;


/**
 * @author zxl on 2018/06/10.
 *         discription:
 *         OOP，即『面向对象编程』，它提倡的是将功能模块化，对象化，而AOP的思想，则不太一样，
 *         它提倡的是针对同一类问题的统一处理
 *         AOP应用的方面还是挺窄的,了解一下:日志，统计，分配权限等
 *
 *         发生在编译时--
 *         代理/butterKnife发生在运行时x
 */
public class MainActivity extends AppCompatActivity {
    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
    private long begin = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLoginExample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserActivity.class));
            }
        });

        findViewById(R.id.btnARouter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ARouterMainActivity.class));
            }
        });
    }

}
