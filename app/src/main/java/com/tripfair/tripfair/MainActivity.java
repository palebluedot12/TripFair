package com.tripfair.tripfair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.tripfair.tripfair.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MapFragment mapFragment;
    LoungeFragment loungeFragment;
    MypageFragment mypageFragment;
    GyeonggiFoodFragment gyeonggiFoodFragment;
    GyeonggiTourFragment gyeonggiTourFragment;
    GangwonFoodFragment gangwonFoodFragment;
    GangwonTourFragment gangwonTourFragment;
    ChungCheongFoodFragment chungCheongFoodFragment;
    ChungCheongTourFragment chungCheongTourFragment;
    GyeongsangFoodFragment gyeongsangFoodFragment;
    GyeongsangTourFragment gyeongsangTourFragment;
    JeonlaFoodFragment jeonlaFoodFragment;
    JeonlaTourFragment jeonlaTourFragment;

    public static Stack<Fragment> fragmentStack;
    public static FragmentManager manager;

    private long pressedTime = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
        loungeFragment = new LoungeFragment();
        mypageFragment = new MypageFragment();
        gyeonggiFoodFragment = new GyeonggiFoodFragment();
        gyeonggiTourFragment = new GyeonggiTourFragment();
        gangwonTourFragment = new GangwonTourFragment();
        gangwonFoodFragment = new GangwonFoodFragment();
        chungCheongTourFragment = new ChungCheongTourFragment();
        chungCheongFoodFragment = new ChungCheongFoodFragment();
        gyeongsangTourFragment = new GyeongsangTourFragment();
        gyeongsangFoodFragment = new GyeongsangFoodFragment();
        jeonlaTourFragment = new JeonlaTourFragment();
        jeonlaFoodFragment = new JeonlaFoodFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                        return true;
                    case R.id.map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, mapFragment).commit();
                        return true;
//                    case R.id.lounge:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, loungeFragment).commit();
//                        return true;
                    case R.id.mypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, mypageFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    public void fragmentChange(int index){
        if(index == 1){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, gyeonggiFoodFragment).commit();
        }
        else if(index == 2){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, homeFragment).commit();
        }
        else if(index == 3){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, gyeonggiTourFragment).commit();
        }
        else if(index == 4){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, gangwonTourFragment).commit();
        }
        else if(index == 5){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, gangwonFoodFragment).commit();
        }
        else if(index == 6){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, chungCheongTourFragment).commit();
        }
        else if(index == 7){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, chungCheongFoodFragment).commit();
        }
        else if(index == 8){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, gyeongsangTourFragment).commit();
        }
        else if(index == 9){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, gyeongsangFoodFragment).commit();
        }
        else if(index == 10){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, jeonlaTourFragment).commit();
        }
        else if(index == 11){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containers, jeonlaFoodFragment).commit();
        }
    }

//    @Override
//    public void onBackPressed() {
//        if(!fragmentStack.isEmpty()){
//            Fragment nextFragment = fragmentStack.pop();
//            manager.beginTransaction().replace(R.id.container, nextFragment).commit();
//            System.out.println("[TESTING >>] " + fragmentStack.size());
//        }else {
//            super.onBackPressed();
//        }
//
//    }

    // 리스너 생성
    public interface OnBackPressedListener {
        public void onBack();
    }

    // 리스너 객체 생성
    private OnBackPressedListener mBackListener;

    // 리스너 설정 메소드
    public void setOnBackPressedListener(OnBackPressedListener listener) {
        mBackListener = listener;
    }

    // 뒤로가기 버튼을 눌렀을 때의 오버라이드 메소드
    @Override
    public void onBackPressed() {

        // 다른 Fragment 에서 리스너를 설정했을 때 처리됩니다.
        if(mBackListener != null) {
            mBackListener.onBack();
            Log.e("!!!", "Listener is not null");
            // 리스너가 설정되지 않은 상태(예를들어 메인Fragment)라면
            // 뒤로가기 버튼을 연속적으로 두번 눌렀을 때 앱이 종료됩니다.
        } else {
            Log.e("!!!", "Listener is null");
            if ( pressedTime == 0 ) {
                Snackbar.make(findViewById(android.R.id.content),
                        " 한 번 더 누르면 종료됩니다." , Snackbar.LENGTH_LONG).show();
                pressedTime = System.currentTimeMillis();
            }
            else {
                int seconds = (int) (System.currentTimeMillis() - pressedTime);

                if (seconds > 2000) {
                    Snackbar.make(findViewById(android.R.id.content),
                            " 한 번 더 누르면 종료됩니다." , Snackbar.LENGTH_LONG).show();
                    pressedTime = 0 ;
                }
                else {
                    super.onBackPressed();
                    Log.e("!!!", "onBackPressed : finish, killProcess");
                    finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            }
        }
    }


}