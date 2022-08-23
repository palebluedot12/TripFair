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
import com.example.tripfair.databinding.FragmentGyeongsangTourBinding;

public class GyeongsangTourFragment extends Fragment {

    private FragmentGyeongsangTourBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGyeongsangTourBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeongsang_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경상 관광지"); // 툴바 제목 설정

        binding.gstFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/63/2821563_image2_1.jpg").into(binding.gstImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/33/2820133_image2_1.jpg").into(binding.gstImg2);
        //Glide.with(getActivity()).load("").into(binding.gstImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2820695_image2_1.jpg").into(binding.gstImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/86/2820686_image2_1.jpg").into(binding.gstImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2820539_image2_1.jpg").into(binding.gstImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/48/2820348_image2_1.jpg").into(binding.gstImg7);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/44/2820344_image2_1.jpg").into(binding.gstImg8);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/50/2820450_image2_1.jpg").into(binding.gstImg9);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/74/2820474_image2_1.jpg").into(binding.gstImg10);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/44/2820144_image2_1.jpg").into(binding.gstImg11);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/01/2820201_image2_1.jpg").into(binding.gstImg12);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/70/2817570_image2_1.JPG").into(binding.gstImg13);
        //Glide.with(getActivity()).load("").into(binding.gstImg14);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/15/2698915_image2_1.bmp").into(binding.gstImg15);
        //Glide.with(getActivity()).load("").into(binding.gstImg16);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/15/2821415_image2_1.jpg").into(binding.gstImg17);
//        Glide.with(getActivity()).load("").into(binding.gstImg18);
//        Glide.with(getActivity()).load("").into(binding.gstImg19);
//        Glide.with(getActivity()).load("").into(binding.gstImg20);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/02/2821402_image2_1.jpg").into(binding.gstImg21);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2820113_image2_1.jpg").into(binding.gstImg22);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2820139_image2_1.jpg").into(binding.gstImg23);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/64/2820464_image2_1.jpg").into(binding.gstImg24);




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