package com.example.tripfair;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;

public class LoginActivity extends AppCompatActivity {
    private Button mKakaoLoginBtn;
    private LoginButton mKakaoLoginBtnBasic;
    private KakaoLogin.KakaoSessionCallback sessionCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mKakaoLoginBtn = findViewById(R.id.btn_kakao_login);
        mKakaoLoginBtnBasic = findViewById(R.id.btn_kakao_login_basic);


        mKakaoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mKakaoLoginBtnBasic.performClick();
            }
        });

        if (!HasKakaoSession()) {
            sessionCallback = new KakaoLogin.KakaoSessionCallback(getApplicationContext(), LoginActivity.this);
            Session.getCurrentSession().addCallback(sessionCallback);
        } else if (HasKakaoSession()) {
            sessionCallback = new KakaoLogin.KakaoSessionCallback(getApplicationContext(), LoginActivity.this);
            Session.getCurrentSession().addCallback(sessionCallback);
            Session.getCurrentSession().checkAndImplicitOpen();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    private boolean HasKakaoSession() {
        if (!Session.getCurrentSession().checkAndImplicitOpen()) {
            return false;
        }
        return true;
    }

    public void directToSecondActivity(Boolean result) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        if (result) {
            Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
            startActivity(intent);;
            finish();
        }
    }
}