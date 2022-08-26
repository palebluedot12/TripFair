package com.example.tripfair;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.kakao.auth.ApiErrorCode;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;

public class GlobalAuthHelper {

    public static void accountLogout(Context context, MypageFragment fragment) {
        if (Session.getCurrentSession().checkAndImplicitOpen()) {
            UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                @Override
                public void onCompleteLogout() {
                    fragment.directToLoginActivity(true);
                }
            });
        }else if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            FirebaseAuth.getInstance().signOut();
            GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_SIGN_IN).signOut();
            fragment.directToLoginActivity(true);
        }
    }

    public static void accountResign(final Context context, final MypageFragment fragment) {
        if (Session.getCurrentSession().checkAndImplicitOpen()) {
            // 카카오 연동 해제
            UserManagement.getInstance().requestUnlink(new UnLinkResponseCallback() {
                @Override
                public void onFailure(ErrorResult errorResult) {
                    if (errorResult.getErrorCode() == ApiErrorCode.CLIENT_ERROR_CODE) {
                        Toast.makeText(context, "네트워크가 불안정합니다.", Toast.LENGTH_SHORT).show();
                        fragment.directToLoginActivity(false);
                    }
                }

                @Override
                public void onSessionClosed(ErrorResult errorResult) {
                    Toast.makeText(context, "세션이 닫혀있습니다.", Toast.LENGTH_SHORT).show();
                    fragment.directToLoginActivity(false);
                }

                @Override
                public void onSuccess(Long result) {
                    Toast.makeText(context, "카카오톡 연동 해제", Toast.LENGTH_SHORT).show();
                    fragment.directToLoginActivity(true);
                }
            });
        } else if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            // 구글 연동 해제
            try {
                FirebaseAuth.getInstance().getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            fragment.directToLoginActivity(true);
                        }
                        else {
                            fragment.directToLoginActivity(false);
                        }
                    }
                }); // Firebase 인증 해제
                GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_SIGN_IN).revokeAccess(); // Google 계정 해제
            } catch (Exception e) {
                fragment.directToLoginActivity(false);
            }
        }
    }
}
