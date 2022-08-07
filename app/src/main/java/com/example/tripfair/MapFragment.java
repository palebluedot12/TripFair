package com.example.tripfair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MapFragment extends Fragment {

    String key = "RmQEk8%2FSDU6FE15Ov2cdNj%2FwLmoHZde3XbSSz2Sik3iKbSK2Yqt0IZRY6WcjwaX1eNp50bLHNIzRBakdUmP37g%3D%3D";
    String data;
    String image = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        //StrictMode.enableDefaults();

        TextView apitest = (TextView) v.findViewById(R.id.apitest); //파싱된 결과확인!
        ImageView apitest_image = (ImageView) v.findViewById(R.id.apitest_image);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

                // 아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                // 날씨 API
                data = getData();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        apitest.setText(data); //TextView에 문자열  data 출력
                        Glide.with(getActivity()).load(image).into(apitest_image);
                    }
                });
            }
        }).start();

        return v;
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
        String contentTypeId = "32";
        String areaCode = "1";
        String sigunguCode = "1";
        String listYN = "Y";
        String serviceKey = "RmQEk8%2FSDU6FE15Ov2cdNj%2FwLmoHZde3XbSSz2Sik3iKbSK2Yqt0IZRY6WcjwaX1eNp50bLHNIzRBakdUmP37g%3D%3D";

        String queryUrl = "https://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=" + serviceKey +
                "&pageNo=" + pageNo + "&numOfRows=" + numOfRows + "&MobileApp=" + MobileApp + "&MobileOS=" + MobileOS + "&arrange=" + arrange +
                "&contentTypeId=" + contentTypeId + "&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&listYN=" + listYN;

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

                        if(tag.equals("item")) ;
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
                            buffer.append("\n\n");
                        }
                        else if(tag.equals("grndFlrCnt")) {
                            buffer.append("지상층수 : ");
                            xpp.next();
                            buffer.append(xpp.getText() +"층");
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