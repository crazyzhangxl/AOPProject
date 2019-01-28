package com.example.aopproject.login_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aopproject.R;
import com.example.aopproject.UserCache;

/**
 * @author crazyZhangxl on 2019-1-28 15:24:45.
 * Describe:
 */

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin,btnLoginout,btnNormal,btnVip;
    private TextView tvState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initViews();
        initListener();
    }

    private void initViews() {
        tvState = findViewById(R.id.tvState);
        btnLogin = findViewById(R.id.btn_login);
        btnLoginout = findViewById(R.id.btn_login_out);
        btnNormal = findViewById(R.id.btnNormal);
        btnVip = findViewById(R.id.btnVip);
    }

    private void initListener(){
        btnLogin.setOnClickListener(this);
        btnLoginout.setOnClickListener(this);
        btnNormal.setOnClickListener(this);
        btnVip.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                UserCache.getInstance().setLogin(true);
                break;
            case R.id.btn_login_out:
                UserCache.getInstance().setLogin(false);
                break;
            case R.id.btnNormal:
                methodOne();
                break;
            case R.id.btnVip:
                methodTwo();
                break;
                default:
                    break;
        }
        updateState();
    }

    private void updateState(){
        tvState.setText(getString(R.string.login_state,UserCache.getInstance().isLogin()));
    }

    private void methodOne(){
        Toast.makeText(this, "执行普通浏览", Toast.LENGTH_SHORT).show();
    }

    @LoginTrace(type = 0)
    private void methodTwo(){
        Toast.makeText(this, "执行VIP动作", Toast.LENGTH_SHORT).show();
    }
}
