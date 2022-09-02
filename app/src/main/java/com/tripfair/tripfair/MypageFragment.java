package com.tripfair.tripfair;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MypageFragment extends Fragment {
    Frag5 frag5;
    private TextView tvSecondUserID, tvSecondNickname;
    private LinearLayout btnSecondLogout, btnSecondResign,mylounge;
    private List userInfo = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mypage, container, false);
        frag5=new Frag5();
        Button.OnClickListener mLogoutListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalAuthHelper.accountLogout(getActivity(),MypageFragment.this);
            }
        };

        Button.OnClickListener mResignListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalAuthHelper.accountResign(getActivity(),MypageFragment.this);
            }
        };


//        tvSecondUserID = v.findViewById(R.id.tv_second_userid);
//        tvSecondNickname = v.findViewById(R.id.tv_second_nickname);
        btnSecondLogout = v.findViewById(R.id.btn_second_logout);
        btnSecondResign = v.findViewById(R.id.btn_second_resign);
        mylounge =v.findViewById(R.id.my_lounge);

//        initView();
        mylounge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                bundle.putString("destinationUid",uid);
                frag5.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containers, frag5).commit();
            }
        });
        btnSecondLogout.setOnClickListener(mLogoutListener);
        btnSecondResign.setOnClickListener(mResignListener);
            return v;
    }


//    private void initView() {
//        GlobalHelper mGlobalHelper = new GlobalHelper();
//        userInfo = mGlobalHelper.getGlobalUserLoginInfo();
//
//        tvSecondUserID.setText("UserId : " + userInfo.get(0));
//        tvSecondNickname.setText("Nickname : " + userInfo.get(1));
//
//
//    }

    public void directToLoginActivity(Boolean result) {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}