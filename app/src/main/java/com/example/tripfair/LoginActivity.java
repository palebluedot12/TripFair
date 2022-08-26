package com.example.tripfair;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;

public class LoginActivity extends AppCompatActivity {
    private ImageView mKakaoLoginBtn,mGoogleLoginBtn;
    private LoginButton mKakaoLoginBtnBasic;
    private KakaoLogin.KakaoSessionCallback sessionCallback;

    private FirebaseAuth mGoogleLoginModule;
    Button.OnClickListener mGoogleLoginListener = new ImageView.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, GoogleLogin.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mKakaoLoginBtn = findViewById(R.id.btn_kakao_login);
        mKakaoLoginBtnBasic = findViewById(R.id.btn_kakao_login_basic);
        mGoogleLoginBtn = findViewById(R.id.btn_google_login);
        mGoogleLoginBtn.setOnClickListener(mGoogleLoginListener);

        mKakaoLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mKakaoLoginBtnBasic.performClick();
            }
        });
        mGoogleLoginModule = FirebaseAuth.getInstance();
        if (!HasKakaoSession() &&  !HasGoogleSession()) {
            sessionCallback = new KakaoLogin.KakaoSessionCallback(getApplicationContext(), LoginActivity.this);
            Session.getCurrentSession().addCallback(sessionCallback);
        } else if (HasKakaoSession()) {
            sessionCallback = new KakaoLogin.KakaoSessionCallback(getApplicationContext(), LoginActivity.this);
            Session.getCurrentSession().addCallback(sessionCallback);
            Session.getCurrentSession().checkAndImplicitOpen();

        } else if (HasGoogleSession()) {
            Intent intent = new Intent(LoginActivity.this, GoogleLogin.class);
            startActivity(intent);
            finish();
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

    private boolean HasGoogleSession() {
        if (mGoogleLoginModule.getCurrentUser() == null) {
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