package com.example.tripfair;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tripfair.databinding.FragmentGangwonFoodBinding;
import com.example.tripfair.databinding.FragmentGangwonTourBinding;


public class GangwonFoodFragment extends Fragment {

    private FragmentGangwonFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGangwonFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gangwon_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("강원 맛집/음식관광"); // 툴바 제목 설정

        binding.gwfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2732813_image2_1.jpg").into(binding.gwfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/80/2773880_image2_1.jpg").into(binding.gwfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/73/2820873_image2_1.JPG").into(binding.gwfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2698695_image2_1.bmp").into(binding.gwfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/93/2698793_image2_1.bmp").into(binding.gwfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/42/2707042_image2_1.jpeg").into(binding.gwfImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/06/2610806_image2_1.bmp").into(binding.gwfImg7);


        return v;
    }

    //상단바 뒤로가기 눌렀을 때
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                // 액티비티 이동
                ((MainActivity)getActivity()).fragmentChange(2);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}