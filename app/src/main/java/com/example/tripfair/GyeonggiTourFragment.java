package com.example.tripfair;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.tripfair.databinding.FragmentGyeonggiTourBinding;

public class GyeonggiTourFragment extends Fragment {

    private FragmentGyeonggiTourBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_gyeonggi_tour, container, false);

        binding = FragmentGyeonggiTourBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeonggi_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경기 관광지"); // 툴바 제목 설정

//        ImageView img1 = (ImageView) v.findViewById(R.id.img1);
//        ImageView img2 = (ImageView) v.findViewById(R.id.img2);
//        ImageView img3 = (ImageView) v.findViewById(R.id.img3);
//
//        LinearLayout gt_1 = (LinearLayout) v.findViewById(R.id.gt_1);
//        LinearLayout gt_2 = (LinearLayout) v.findViewById(R.id.gt_2);
//        LinearLayout gt_3 = (LinearLayout) v.findViewById(R.id.gt_3);
//        LinearLayout gt_all = (LinearLayout) v.findViewById(R.id.gt_all);

        binding.gt1.setOnClickListener(this::onClick);
        binding.gt2.setOnClickListener(this::onClick);
        binding.gt3.setOnClickListener(this::onClick);


        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/56/2820256_image2_1.jpg").into(binding.img1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/24/2820324_image2_1.jpg").into(binding.img2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/30/2820830_image2_1.jpg").into(binding.img3);
        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gt1:
            case R.id.gt2:
            case R.id.gt3:
                binding.gtAll.setVisibility(View.GONE);
        }
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}