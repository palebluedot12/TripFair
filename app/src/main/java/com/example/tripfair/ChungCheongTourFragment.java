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
import com.example.tripfair.databinding.FragmentChungCheongTourBinding;
import com.example.tripfair.databinding.FragmentGangwonTourBinding;

public class ChungCheongTourFragment extends Fragment {

    private FragmentChungCheongTourBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentChungCheongTourBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Toolbar toolbar = v.findViewById(R.id.toolbar_chungcheong_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("충청 관광지"); // 툴바 제목 설정

        binding.ctFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/31/2821331_image2_1.jpg").into(binding.ctImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2820095_image2_1.JPG").into(binding.ctImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/10/2820410_image2_1.jpg").into(binding.ctImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/15/2820415_image2_1.jpg").into(binding.ctImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/46/2821346_image2_1.jpg").into(binding.ctImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/34/2821334_image2_1.jpg").into(binding.ctImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/91/2820091_image2_1.jpg").into(binding.ctImg7);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/00/2820100_image2_1.jpg").into(binding.ctImg8);
        //Glide.with(getActivity()).load("").into(binding.ctImg9);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/29/2820729_image2_1.jpg").into(binding.ctImg10);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/22/2820622_image2_1.JPG").into(binding.ctImg11);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/27/2820627_image2_1.jpg").into(binding.ctImg12);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2820613_image2_1.JPG").into(binding.ctImg13);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/09/2820609_image2_1.JPG").into(binding.ctImg14);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/04/2820604_image2_1.jpg").into(binding.ctImg15);
        //Glide.with(getActivity()).load("").into(binding.ctImg16);
        //Glide.with(getActivity()).load("").into(binding.ctImg5);
        //Glide.with(getActivity()).load("").into(binding.ctImg17);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/27/2698827_image2_1.bmp").into(binding.ctImg18);
//        Glide.with(getActivity()).load("").into(binding.ctImg19);
//        Glide.with(getActivity()).load("").into(binding.ctImg20);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/06/2739606_image2_1.jpg").into(binding.ctImg21);
        //Glide.with(getActivity()).load("").into(binding.ctImg22);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/14/2821314_image2_1.JPG").into(binding.ctImg23);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/81/2671481_image2_1.jpg").into(binding.ctImg24);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/09/2820609_image2_1.JPG").into(binding.ctImg25);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/11/2698811_image2_1.bmp").into(binding.ctImg26);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2554608_image2_1.JPG").into(binding.ctImg27);

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