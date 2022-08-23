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
import com.example.tripfair.databinding.FragmentGangwonTourBinding;
import com.example.tripfair.databinding.FragmentGyeonggiFoodBinding;
import com.example.tripfair.databinding.FragmentGyeonggiTourBinding;
import com.example.tripfair.databinding.FragmentGyeongsangFoodBinding;


public class GyeongsangFoodFragment extends Fragment {

    private FragmentGyeongsangFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGyeongsangFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeongsang_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경상 맛집/음식관광"); // 툴바 제목 설정

        binding.gsfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/43/2820343_image2_1.jpg").into(binding.gsfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/38/2820338_image2_1.jpg").into(binding.gsfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/35/2820335_image2_1.jpg").into(binding.gsfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/05/2820505_image2_1.jpg").into(binding.gsfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/36/2610936_image2_1.bmp").into(binding.gsfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/78/2552778_image2_1.JPG").into(binding.gsfImg6);
        

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