package com.example.tripfair;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class HomeFragment extends Fragment {

    private Button btn_logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        // Inflate the layout for this fragment

        btn_logout = v.findViewById(R.id.btn_logout);

//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
//                    @Override
//                    public Unit invoke(Throwable throwable) {
//                        updateKakaoLoginUi();
//                        return null;
//                    }
//                });
//            }
//        });


        return v;
    }


    private void updateKakaoLoginUi() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                if (user != null){ //로그인 성공시
                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                } else{
                    btn_logout.setVisibility(View.GONE);
                }
                return null;
            }
        });
    }

}