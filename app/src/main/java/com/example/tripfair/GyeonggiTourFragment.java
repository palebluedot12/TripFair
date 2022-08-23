package com.example.tripfair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.tripfair.databinding.FragmentGyeonggiTourBinding;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GyeonggiTourFragment extends Fragment {

    private FragmentGyeonggiTourBinding binding;
    String image = "";
    String data = "";
    String overview = "";
    String tel = "";

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

        binding.gtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                //  API
                getData("12","2820274");

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        binding.gtAddress.setText(data); //TextView에 문자열  data 출력
                        binding.gtTel.setText(tel);
                    }
                });
            }
        }).start();
        //     ImageView img1 = (ImageView) v.findViewById(R.id.img1);
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

        //목록 이미지 띄우기
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/56/2820256_image2_1.jpg").into(binding.img1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/24/2820324_image2_1.jpg").into(binding.img2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/30/2820830_image2_1.jpg").into(binding.img3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/00/2820600_image2_1.jpg").into(binding.img4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/61/2820261_image2_1.jpg").into(binding.img7);
        //Glide.with(getActivity()).load("").into(binding.img8);
        //Glide.with(getActivity()).load("").into(binding.img9);
        //Glide.with(getActivity()).load("").into(binding.img10);
        //Glide.with(getActivity()).load("").into(binding.img11);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/82/2724782_image2_1.jpg").into(binding.img12);
//        Glide.with(getActivity()).load("").into(binding.img13);
//        Glide.with(getActivity()).load("").into(binding.img14);
//        Glide.with(getActivity()).load("").into(binding.img15);
//        Glide.with(getActivity()).load("").into(binding.img16);
//        Glide.with(getActivity()).load("").into(binding.img17);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/67/2698667_image2_1.bmp").into(binding.img18);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/37/2698637_image2_1.bmp").into(binding.img19);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/12/2610912_image2_1.bmp").into(binding.img20);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/05/2553505_image2_1.bmp").into(binding.img21);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/24/2552724_image2_1.bmp").into(binding.img22);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/07/2553707_image2_1.bmp").into(binding.img23);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gt1:
                binding.gtAll.setVisibility(View.GONE);
                binding.gtFrame.setVisibility(View.VISIBLE);
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/56/2820256_image2_1.jpg").into(binding.gtImage);
             //   data = getData("12","2820274");  //왜 이코드만 들어가면 익셉션이 뜰까...???
//                binding.gtAddress.setText(data); //TextView에 문자열  data 출력
//                binding.gtTel.setText(tel);

            case R.id.gt2:
            case R.id.gt3:
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

    public void getData(String contentTypeId, String contentId){
        StringBuffer buffer = new StringBuffer();

        String pageNo = "1";
        String numOfRows = "2";
        String MobileApp = "TripFair";
        String MobileOS = "AND";
        String arrange = "A";
        String defaultYN = "Y";
//        String contentTypeId = "12";
//        String contentId = "2820274";
        String areacodeYN = "1";
        String addrinfoYN = "Y";
        String mapinfoYN = "Y";
        String overviewYN = "Y";
        String sigunguCode = "1";
        String firstImageYN = "Y";
        String listYN = "Y";
        String catcodeYN = "Y";
        String serviceKey = "RmQEk8%2FSDU6FE15Ov2cdNj%2FwLmoHZde3XbSSz2Sik3iKbSK2Yqt0IZRY6WcjwaX1eNp50bLHNIzRBakdUmP37g%3D%3D";

        String queryUrl = "http://apis.data.go.kr/B551011/KorService/detailCommon?ServiceKey=" + serviceKey +
                "&contentTypeId=" + contentTypeId + "&contentId=" + contentId + "&MobileOS=" + MobileOS + "&MobileApp=" + MobileApp +
                "&defaultYN=" + defaultYN + "&firstImageYN=" + firstImageYN +  "&areacodeYN=" + areacodeYN + "&catcodeYN=" + catcodeYN +
                "&addrinfoYN=" + addrinfoYN + "&mapinfoYN=" + mapinfoYN + "&overviewYN=" + overviewYN;

        try {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;
            xpp.next();
            int eventType= xpp.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT){
                switch(eventType){
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//태그 이름 얻어오기
                        if(tag.equals("item"));
                        else if(tag.equals("addr1")) {
                            xpp.next();
                            buffer.append(xpp.getText());
                        }
                        else if(tag.equals("firstimage")) {
                            xpp.next();
                            image = xpp.getText();
                            // Glide.with(getActivity()).load(image).into(food_image1); //첫번째. food_image id가 전역이 아니라 onCreate 밖에서 안됨.
                            //두번째. getActivity()도 밖에서 되는지 모르겠음.
                        }
                        else if(tag.equals("overview")) {
                            xpp.next();
                            //buffer.append(xpp.getText());
                            tel = xpp.getText();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName();
                        if(tag.equals("item")) buffer.append("\n");
                        break;
                }
                eventType = xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
            Log.d("TAG", "익셉션뜸");
        }
        //return buffer.toString();//StringBuffer 문자열 객체 반환
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}