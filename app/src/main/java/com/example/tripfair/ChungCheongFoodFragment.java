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
import com.example.tripfair.databinding.FragmentChungCheongFoodBinding;
import com.example.tripfair.databinding.FragmentGangwonTourBinding;


public class ChungCheongFoodFragment extends Fragment {

    private FragmentChungCheongFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentChungCheongFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_chungcheong_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("충청 맛집/음식관광"); // 툴바 제목 설정

        binding.cfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        //binding.gwtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/01/2820401_image2_1.jpg").into(binding.cfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/31/2821331_image2_1.jpg").into(binding.cfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/20/2820620_image2_1.JPG").into(binding.cfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/84/2822184_image2_1.jpg").into(binding.cfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/55/2821855_image2_1.JPG").into(binding.cfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/47/2821547_image2_1.JPG").into(binding.cfImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/14/2821314_image2_1.JPG").into(binding.cfImg7);

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