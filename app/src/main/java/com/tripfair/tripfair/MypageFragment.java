package com.tripfair.tripfair;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MypageFragment extends Fragment {
    Frag5 frag5;
    private TextView tvSecondUserID, tvSecondNickname;
    private LinearLayout btnSecondLogout, btnSecondResign,mylounge, btnServiceYakgwan, btnGaein, btnLocation, btnOpensource;
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
        btnServiceYakgwan = v.findViewById(R.id.btn_service_yakgwan);
        btnGaein = v.findViewById(R.id.btn_gaein);
        btnLocation = v.findViewById(R.id.btn_location);
        btnOpensource = v.findViewById(R.id.btn_opensource);
//        mylounge =v.findViewById(R.id.my_lounge);

//        initView();
//        mylounge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                bundle.putString("destinationUid",uid);
//                frag5.setArguments(bundle);
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.containers, frag5).commit();
//            }
//        });

        btnServiceYakgwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gigantic-salt-db6.notion.site/a5dfb146545249f3aaf102c032faa341"));
                startActivity(intent);
            }
        });

        btnGaein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gigantic-salt-db6.notion.site/d6674dc80b884d8f97926023e878ff0b"));
                startActivity(intent);
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gigantic-salt-db6.notion.site/222e74347d9440daa793d11fe40d3247"));
                startActivity(intent);
            }
        });

        btnOpensource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),OssLicensesMenuActivity.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
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