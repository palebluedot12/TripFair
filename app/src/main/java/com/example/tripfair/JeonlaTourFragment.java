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
import com.example.tripfair.databinding.FragmentGyeongsangTourBinding;
import com.example.tripfair.databinding.FragmentJeonlaTourBinding;


public class JeonlaTourFragment extends Fragment {

    private FragmentJeonlaTourBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentJeonlaTourBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_jeonla_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("전라 관광지"); // 툴바 제목 설정

        binding.jtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/86/2819886_image2_1.jpg").into(binding.jtImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2821808_image2_1.jpg").into(binding.jtImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/54/2821654_image2_1.jpg").into(binding.jtImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/72/2819872_image2_1.jpg").into(binding.jtImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2819608_image2_1.jpg").into(binding.jtImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/04/2819604_image2_1.jpg").into(binding.jtImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2819595_image2_1.jpg").into(binding.jtImg7);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/32/2552832_image2_1.bmp").into(binding.jtImg8);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/62/2552862_image2_1.bmp").into(binding.jtImg9);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/75/2552775_image2_1.jpg").into(binding.jtImg10);

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