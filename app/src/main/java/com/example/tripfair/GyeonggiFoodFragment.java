package com.example.tripfair;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import androidx.appcompat.widget.Toolbar;

public class GyeonggiFoodFragment extends Fragment {

    String data;
    String image, image2, image3, image4, image5 = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gyeonggi_food, container, false);

         //파싱된 결과확인!
        TextView food_text1 = (TextView) v.findViewById(R.id.food_text1);
        TextView food_text2 = (TextView) v.findViewById(R.id.food_text2);
        TextView food_text3 = (TextView) v.findViewById(R.id.food_text3);
        TextView food_text4 = (TextView) v.findViewById(R.id.food_text4);
        TextView food_text5 = (TextView) v.findViewById(R.id.food_text5);
        ImageView food_image1 = (ImageView) v.findViewById(R.id.food_image1);
        ImageView food_image2 = (ImageView) v.findViewById(R.id.food_image2);
        ImageView food_image3 = (ImageView) v.findViewById(R.id.food_image3);
        ImageView food_image4 = (ImageView) v.findViewById(R.id.food_image4);
        ImageView food_image5 = (ImageView) v.findViewById(R.id.food_image5);

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeonggi_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경기 맛집"); // 툴바 제목 설정



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//
//                // 아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
//                // 날씨 API
//                data = getData();
//
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        food_text1.setText(data); //TextView에 문자열  data 출력
//                    }
//                });
//            }
//        }).start();


        return v;
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

    String getData(){
        StringBuffer buffer = new StringBuffer();

        String pageNo = "1";
        String numOfRows = "2";
        String MobileApp = "TripFair";
        String MobileOS = "AND";
        String arrange = "A";
        String contentTypeId = "12";
        String defaultYN = "Y";
        String contentId = "2820274";
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
                            buffer.append("주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n\n");
                        }
                        else if(tag.equals("firstimage")) {
                            buffer.append("사진 : ");
                            xpp.next();
                            image = xpp.getText();
                           // Glide.with(getActivity()).load(image).into(food_image1); //첫번째. food_image id가 전역이 아니라 onCreate 밖에서 안됨.
                                                                                     //두번째. getActivity()도 밖에서 되는지 모르겠음.
                            buffer.append("\n\n");
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
        }
        return buffer.toString();//StringBuffer 문자열 객체 반환


    }


}