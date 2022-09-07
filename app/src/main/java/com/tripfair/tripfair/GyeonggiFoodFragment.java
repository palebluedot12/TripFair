package com.tripfair.tripfair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tripfair.tripfair.databinding.FragmentGyeonggiFoodBinding;
import com.tripfair.tripfair.databinding.FragmentGyeonggiTourBinding;

import androidx.appcompat.widget.Toolbar;

public class GyeonggiFoodFragment extends Fragment implements MainActivity.OnBackPressedListener {

    GyeonggiFoodFragment gyeonggiFoodFragment;

    String data;
    String image, image2, image3, image4, image5 = "";
    private FragmentGyeonggiFoodBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGyeonggiFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

//        binding.review.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
//                startActivity(intent); //액티비티 열기
//            }
//        });

        gyeonggiFoodFragment = new GyeonggiFoodFragment();

        //파싱된 결과확인!
        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeonggi_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경인 맛집/음식관광"); // 툴바 제목 설정

        binding.gfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/20/2820320_image2_1.jpg").into(binding.img5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/96/2820296_image2_1.jpg").into(binding.img6);

        binding.gf5.setOnClickListener(this::onClick);
        binding.gf6.setOnClickListener(this::onClick);
        binding.gf8.setOnClickListener(this::onClick);
        binding.gf16.setOnClickListener(this::onClick);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.gfAll.setVisibility(View.GONE);
        binding.gfFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.gf5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/20/2820320_image2_1.jpg").into(binding.gfImage);
                binding.gfTitle.setText("포천 파머스키친");
                binding.gfTel.setText("");
                binding.gfAddress.setText("경기도 포천시 호국로 886");
                binding.gfoverview.setText("생산자에게 안정적인 소득을 보장하고 소비자에게 포천 지역 농업의 관광적 가치를 전달하고자 안전하고 신선한 포천 지역의 농축산물을 사용한 BBQ밀키트를 개발했다. 포천의 농산물을 활용한 밀키트 사업 이외도 농장 체험 관광, 생산자와 소비자를 위한 플랫폼 사업을 한다.");
                break;
            case R.id.gf6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/96/2820296_image2_1.jpg").into(binding.gfImage);
                binding.gfTitle.setText("비둘기낭99");
                binding.gfTel.setText("");
                binding.gfAddress.setText("경기도 포천시 비둘기낭길 52");
                binding.gfoverview.setText("비둘기낭99는 마을이 가지고 있는 다양한 문제를 해결하기 위해 마을 이장님을 중심으로 3인의 여성들이 똘똘 뭉친 마을공동체이다. 2020년 유네스코에 등재 된 한탄강 지질공원의 가치를 널리 알리고 자연환경을 보호하면서 한탄강 지질 공원 방문객의 니즈를 반영하여 지역 기반 농산물의 건강 도시락을 특색 있게 제공, 지역 관광 활성화와 지역 주민 수익 증대를 이루고 있다.");
                break;
            case R.id.gf8:
                //Glide.with(getActivity()).load("").into(binding.gfImage);
                binding.gfImage.setImageResource(R.drawable.mildang);
                binding.gfTitle.setText("안성밀당");
                binding.gfTel.setText("010-8221-9690");
                binding.gfAddress.setText("경기도 안성시 시장길 37");
                binding.gfoverview.setText("안성밀당은 부모님에게서 배운 양봉을 기술에, 가지고 있던 바리스타 재능을 더해 꿀을 콘셉트로 한 로컬 디저트 카페이다. 안성지역의 깨끗한 자연환경에서 생산된 건강한 꿀을 활용하여 맛있는 디저트(꿀 음료&amp;꿀 제과)를 판매하고 있으며, 양봉하는 바리스타 이름에 맞게 안성밀당에서 직접 수확한 100% 천연 벌꿀을 소비자들이 편리하게 먹을 수 있도록 소분하여 판매하고 있다.");
                break;
            case R.id.gf16:
                binding.gfImage.setImageResource(R.drawable.localfood_pochun);
                binding.gfTitle.setText("포천 로컬푸드마켓");
                binding.gfTel.setText("070-8848-6478");
                binding.gfAddress.setText("경기도 포천시 호국로 886");
                binding.gfoverview.setText("포천로컬푸드는 안전하고 신뢰할 수 있는 농산물 직거래를 통해 생산자와 소비자의 권익을 보호하는 파머스 마켓을 운영한다. 중·소규모 농업인의 농업소득 증대와 지역농업·지역경제의 균형 발전을 위해 농업의 존엄한 가치와 철학을 존중하고 계승하며, 사회적 경제와 공공의 이익 추구를 위해 지역 농업인과 함께 노력하고 있다. 로컬푸드 시스템을 생산자와 소비자에게 바르게 알리고 정착시키고자 소비자 식생활(로컬푸드) 교육, 농가 체험, 문화 클래스, 플리 마켓 등 다양한 지역 활동도 한다. 2019년 현재 포천시 관내 중·소규모 농업인 400여 명이 참여하여 약 800여 가지 농산물 가공품을 출하했다. 앞으로 포천의 농산물을 활용한 밀키트 사업, 농장체험관광, 생산자와 소비자를 위한 플랫폼사업을 통한 농업관광의 주축이 되고자 한다.");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item2) {
        switch (item2.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                // 액티비티 이동
                ((MainActivity)getActivity()).fragmentChange(2);
            }
        }
        return super.onOptionsItemSelected(item2);
    }

    // xml parsing part
    // https://bugloss-chestnut.tistory.com/entry/Android-%EC%98%A4%ED%94%88API-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EB%B2%95JAVA
    /** https://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=
     RmQEk8%2FSDU6FE15Ov2cdNj%2FwLmoHZde3XbSSz2Sik3iKbSK2Yqt0IZRY6WcjwaX1eNp50bLHNIzRBakdUmP37g%3D%3D
     &pageNo=1&numOfRows=2&MobileApp=AppTest&MobileOS=ETC&arrange=A&contentTypeId=32&areaCode=4&sigunguCode=4&listYN=Y **/

//    String getData(){
//        StringBuffer buffer = new StringBuffer();
//
//        String pageNo = "1";
//        String numOfRows = "2";
//        String MobileApp = "TripFair";
//        String MobileOS = "AND";
//        String arrange = "A";
//        String contentTypeId = "12";
//        String defaultYN = "Y";
//        String contentId = "2820274";
//        String areacodeYN = "1";
//        String addrinfoYN = "Y";
//        String mapinfoYN = "Y";
//        String overviewYN = "Y";
//        String sigunguCode = "1";
//        String firstImageYN = "Y";
//        String listYN = "Y";
//        String catcodeYN = "Y";
//        String serviceKey = "RmQEk8%2FSDU6FE15Ov2cdNj%2FwLmoHZde3XbSSz2Sik3iKbSK2Yqt0IZRY6WcjwaX1eNp50bLHNIzRBakdUmP37g%3D%3D";
//
//        String queryUrl = "http://apis.data.go.kr/B551011/KorService/detailCommon?ServiceKey=" + serviceKey +
//                "&contentTypeId=" + contentTypeId + "&contentId=" + contentId + "&MobileOS=" + MobileOS + "&MobileApp=" + MobileApp +
//                "&defaultYN=" + defaultYN + "&firstImageYN=" + firstImageYN +  "&areacodeYN=" + areacodeYN + "&catcodeYN=" + catcodeYN +
//                "&addrinfoYN=" + addrinfoYN + "&mapinfoYN=" + mapinfoYN + "&overviewYN=" + overviewYN;
//
//        try {
//            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
//            InputStream is= url.openStream(); //url위치로 입력스트림 연결
//
//            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
//            XmlPullParser xpp= factory.newPullParser();
//            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기
//
//            String tag;
//            xpp.next();
//            int eventType= xpp.getEventType();
//
//            while(eventType != XmlPullParser.END_DOCUMENT){
//                switch(eventType){
//                    case XmlPullParser.START_DOCUMENT:
//                        break;
//
//                    case XmlPullParser.START_TAG:
//                        tag= xpp.getName();//태그 이름 얻어오기
//
//                        if(tag.equals("item"));
//                        else if(tag.equals("addr1")) {
//                            buffer.append("주소 : ");
//                            xpp.next();
//                            buffer.append(xpp.getText());
//                            buffer.append("\n\n");
//                        }
//                        else if(tag.equals("firstimage")) {
//                            buffer.append("사진 : ");
//                            xpp.next();
//                            image = xpp.getText();
//                           // Glide.with(getActivity()).load(image).into(food_image1); //첫번째. food_image id가 전역이 아니라 onCreate 밖에서 안됨.
//                                                                                     //두번째. getActivity()도 밖에서 되는지 모르겠음.
//                            buffer.append("\n\n");
//                        }
//                        break;
//                    case XmlPullParser.TEXT:
//                        break;
//
//                    case XmlPullParser.END_TAG:
//                        tag= xpp.getName();
//                        if(tag.equals("item")) buffer.append("\n");
//                        break;
//                }
//                eventType = xpp.next();
//            }
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch blocke.printStackTrace();
//            Log.d("TAG", "익셉션뜸");
//        }
//        return buffer.toString();//StringBuffer 문자열 객체 반환
//
//
//    }

    @Override
    public void onBack() {
        Log.e("Other", "onBack()");
        // 리스너를 설정하기 위해 Activity 를 받아옵니다.
        MainActivity activity = (MainActivity)getActivity();
        // 한번 뒤로가기 버튼을 눌렀다면 Listener 를 null 로 해제해줍니다.
        activity.setOnBackPressedListener(null);
        // MainFragment 로 교체
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containers, gyeonggiFoodFragment).commit();
        // Activity 에서도 뭔가 처리하고 싶은 내용이 있다면 하단 문장처럼 호출해주면 됩니다.
        // activity.onBackPressed();
    }

    // Fragment 호출 시 반드시 호출되는 오버라이드 메소드입니다.
    @Override
    //                     혹시 Context 로 안되시는분은 Activity 로 바꿔보시기 바랍니다.
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Other", "onAttach()");
        ((MainActivity)context).setOnBackPressedListener(this);
    }


}