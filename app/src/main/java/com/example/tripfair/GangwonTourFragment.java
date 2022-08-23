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
import com.example.tripfair.databinding.FragmentGyeonggiTourBinding;


public class GangwonTourFragment extends Fragment {

    private FragmentGangwonTourBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGangwonTourBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gangwon_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("강원 관광지"); // 툴바 제목 설정

        binding.gwtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/70/2820170_image2_1.jpg").into(binding.gwtImg1);
//        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/70/2820170_image2_1.jpg").into(binding.gwtImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/49/2820849_image2_1.jpg").into(binding.gwtImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/98/2698698_image2_1.bmp").into(binding.gwtImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/71/2820771_image2_1.JPG").into(binding.gwtImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/65/2820865_image2_1.jpg").into(binding.gwtImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/40/2820840_image2_1.jpg").into(binding.gwtImg7);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/37/2820837_image2_1.JPG").into(binding.gwtImg8);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/67/2698767_image2_1.bmp").into(binding.gwtImg9);
        //Glide.with(getActivity()).load("").into(binding.gwtImg10);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/73/2820173_image2_1.JPG").into(binding.gwtImg11);
        //Glide.with(getActivity()).load("").into(binding.gwtImg12);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/81/2698681_image2_1.bmp").into(binding.gwtImg13);
        //Glide.with(getActivity()).load("").into(binding.gwtImg14);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/97/2731297_image2_1.jpg").into(binding.gwtImg15);
        //Glide.with(getActivity()).load("").into(binding.gwtImg16);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/14/2649014_image2_1.jpg").into(binding.gwtImg17);
       //Glide.with(getActivity()).load("").into(binding.gwtImg18);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/47/2820747_image2_1.jpg").into(binding.gwtImg19);
//        Glide.with(getActivity()).load("").into(binding.gwtImg20);
//        Glide.with(getActivity()).load("").into(binding.gwtImg21);
//        Glide.with(getActivity()).load("").into(binding.gwtImg22);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/46/2707046_image2_1.jpg").into(binding.gwtImg23);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/98/2553198_image2_1.jpg").into(binding.gwtImg24);

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