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
import com.example.tripfair.databinding.FragmentJeonlaFoodBinding;
import com.example.tripfair.databinding.FragmentJeonlaTourBinding;

public class JeonlaFoodFragment extends Fragment {
    private FragmentJeonlaFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentJeonlaFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_jeonla_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("전라 맛집/음식 관광"); // 툴바 제목 설정

        binding.jfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/93/2819893_image2_1.jpg").into(binding.jfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/91/2820791_image2_1.jpg").into(binding.jfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/85/2820785_image2_1.jpg").into(binding.jfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/67/2820967_image2_1.jpg").into(binding.jfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2819639_image2_1.jpg").into(binding.jfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/80/2819880_image2_1.jpg").into(binding.jfImg6);

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