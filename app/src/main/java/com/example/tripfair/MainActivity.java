package com.example.tripfair;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;

import com.example.tripfair.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MapFragment mapFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
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



}