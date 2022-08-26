package com.example.tripfair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class GyeonggiTourFragment extends Fragment implements MainActivity.OnBackPressedListener {

    GyeonggiTourFragment gyeonggiTourFragment;

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


        binding.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        gyeonggiTourFragment = new GyeonggiTourFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeonggi_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경인 관광지"); // 툴바 제목 설정

        binding.gtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
//                //  API
//                getData("12","2820274");
//
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // TODO Auto-generated method stub
//                        binding.gtAddress.setText(data); //TextView에 문자열  data 출력
//                        binding.gtTel.setText(tel);
//                    }
//                });
//            }
//        }).start();
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
        binding.gt4.setOnClickListener(this::onClick);
        binding.gt7.setOnClickListener(this::onClick);
        binding.gt12.setOnClickListener(this::onClick);
        binding.gt18.setOnClickListener(this::onClick);
        binding.gt19.setOnClickListener(this::onClick);
        binding.gt20.setOnClickListener(this::onClick);
        binding.gt21.setOnClickListener(this::onClick);
        binding.gt22.setOnClickListener(this::onClick);
        binding.gt23.setOnClickListener(this::onClick);

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

        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");		// 고정 text
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "트립페어 - 함께 만들어가는 공정의 가치 [링크]");

                Intent chooser = Intent.createChooser(sharingIntent, "친구에게 공유하기");
                startActivity(sharingIntent);
            }
        });

        return v;
    }



    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.gtAll.setVisibility(View.GONE);
        binding.gtFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.gt1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/56/2820256_image2_1.jpg").into(binding.gtImage);
                binding.gtTitle.setText("누구나투어");
                binding.gtTel.setText("010-7596-5253");
                binding.gtAddress.setText("경기도 포천시 중앙로 168");
                binding.gtoverview.setText("㈜누구나투어는 MZ세대 개별 여행자를 대상으로 맞춤형 여행 상품을 온라인으로 판매하고 누구나그래퍼, 누구나소믈리에, 누구나아티스트, 누구나플로깅, 누구나스토리안, 누구나플레이어와 같은 누구나 이용할 수 있지만 포천 지역에서만 만나볼 수 있는 여행 상품을 판매하는 주민 여행사이다. 포천 지역의 다양한 기관이나 주민들과 협업하는 상품 개발하여 로컬 여행을 선두하고 ESG를 실천하고자 하는 여행자들의 가치 여행을 지향한다.");
                break;
            case R.id.gt2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/24/2820324_image2_1.jpg").into(binding.gtImage);
                binding.gtTitle.setText("힐데루시 자연치유 협동조합");
                binding.gtTel.setText("010-9880-1057");
                binding.gtAddress.setText("경기도 포천시 신북면 청신로1341번길 10-20");
                binding.gtoverview.setText("힐데루시 자연치유 주민사업체는 20년간 쌓아온 경험을 바탕으로 하는 관광두레 주민사업체이다. 삶에 지친 현대인들을 위한 대한민국의 독보적인 오감치유 프로그램으로 개발하여 사회적 배려자를 우선하며 정신적 건강을 회복하여 긍정적인 삶을 영위하도록 돕는 것을 목적으로 한다.");
                break;
            case R.id.gt3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/30/2820830_image2_1.jpg").into(binding.gtImage);
                binding.gtTitle.setText("남한산성 전통무예");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 광주시 남한산성로 240-28");
                binding.gtoverview.setText("남한산성전통무예는 경기도 광주시 남한산성면에 있으며 옛 역사가 살아 숨 쉬는 곳으로 선조들 전통의 숨결을 보유한 곳이다. 한양을 지키던 남한산성 안에서 조선 후기의 무예 훈련 교범인 '무예도보통지'와 남한산성 유네스코 지정 홍보 및 무예 체험, 의상체험, 국궁체험 등 우리나라의 유구한 역사인 전통 무예의 발전을 알리기 위해 노력하고 있다. 남한산성(유네스코 지정), 남한산성전통무예, 둘레길 체험 등 서비스를 제공하여 경쟁력 강화와 지역관광에 기여하고 있다.");
                break;
            case R.id.gt4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/00/2820600_image2_1.jpg").into(binding.gtImage);
                binding.gtTitle.setText("도자누리");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 광주시 경안천로 126");
                binding.gtoverview.setText("도자누리는 지역 장애인 가정들이 모여 관광 기념품을 개발 및 판매하는 특수한 마을 공동체 기업이다. 틀림이 아닌 다른 관점으로 장애인 가정의 섬세한 손길과 뜨거운 열정을 감동으로 체험할 수 있는 의미 있는 기념품을 구매할 수 있다. 체험 공방 또한 운영하고 있어, 남녀노소, 장애인/비장애인 누구나 쉽게 배울 수 있는 도자기 프로그램으로 멀게만 느껴졌던 도자기와 가까워 질 수 있다");
                break;
            case R.id.gt7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/61/2820261_image2_1.jpg").into(binding.gtImage);
                binding.gtTitle.setText("사르르목장");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 포천시 산정호수로 130");
                binding.gtoverview.setText("포천 피크닉은 목장사업 2세대들이 주민들과 단합하여 만든 주민사업체로 ‘포천’의 장점, 지역 주민과 청년들의 ‘토박이’로서의 장점, 그리고 새로운 시대에 맞는 ‘융합’을 통하여 ‘지역 성장의 교두보’ 역할을 해내겠다는 비전과 의지를 가지고 만들어졌다.\n" +
                        "포천을 방문하는 관광객들이라면 들려야 할 로컬 대표 맛집 탐방 명소로 자리 잡고자, 포천 지역의 농산물과 결합한 아이스크림을 개발하고 인스타 감성의 아기자기한 포토존까지 함께 제공한다.(산정호수 가는 길목에 9월 오픈예정)");
                break;
            case R.id.gt12:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/82/2724782_image2_1.jpg").into(binding.gtImage);
                binding.gtTitle.setText("협동조합 문화와함께");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 용인시 처인구 원삼면 백원로262번길 57-7");
                binding.gtoverview.setText("협동조합문화와함께는 문화예술인이 만든 협동조합으로 관광기념품과 문화예술체험을 제공한다. 풀낭글씨공방, 백암도예, 생각을담는집, 스펙트우드가 주축이 되어 글씨공예, 도자기체험, 옻칠공예, 자계공예, 인문학 체험을 콜라보한 상품을 꾸준히 개발하고 있고 용담호수뚝마켓을 통해 지역의 수공예작가들의 작품을 전시판매하는 장을 마련하고 있다.");
                break;
            case R.id.gt18:
                Glide.with(getActivity()).load("").into(binding.gtImage);
                binding.gtTitle.setText("4.16희망목공소(4.16희망목공협동조합)");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 안산시 단원구 순환로 416");
                binding.gtoverview.setText("4.16희망목공소는 안산의 버려진 나무를 활용하여 제품 및 목공 체험으로 새 생명을 부여하는 곳이다. 목공을 통해 더불어 사는 따뜻한 세상을 만들고자 2015년부터 세월호 엄마아빠들이 모였고 2019년 5월 개소를 통해 목공소를 운영하게 되었다.  목공소의 든든한 파파스머프 미지아빠(유해종), 투털이지만 묵묵히 작품을 만드는 민정아빠(김병준), 열정 넘치는 수연아빠(이재복) 세 명의 목수가 주축이 되어 세월호의 정신과 아이들의 꿈, 세상을 향한 희망을 목공을 통해 전달하고 있다. 톱질과 사포질 하나하나에 그리움과 희망을, 더 나은 사회를 향한 꿈을 담아내고 있다.");
                break;
            case R.id.gt19:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/37/2698637_image2_1.bmp").into(binding.gtImage);
                binding.gtTitle.setText("평화오르골");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 파주시 법원읍 술이홀로1333번길 128");
                binding.gtoverview.setText("파주 평화오르골은 우리나라 대표 안보관광지인 파주의 특성을 살린 지역 기념품체험지이다. 평화오르골은 임진각을 찾는 관광객들이 평화오르골을 직접 만들어보기도 하며 평화와 전쟁의 의미를 되새길 수 있다. 그 외에도 평화오르골 체험장 인근은 농촌체험마을로 다양한 농촌체험과 캠핑장등이 준비 되어 있어 함께 즐기기에 좋다.");
                break;
            case R.id.gt20:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/12/2610912_image2_1.bmp").into(binding.gtImage);
                binding.gtTitle.setText("시흥하이갯골");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 시흥시 동서로 287");
                binding.gtoverview.setText("시흥갯골생태공원은 옛 소래염전 지역으로 1934~1936년에 조성되었으며 145만평 정도 규모의 친환경 자연생태공원이다. 당시 이곳에서 생산된 대부분의 소금이 수인선과 경부선 열차로 부산항에 옮겨진 후, 일본으로 반출되었던 우리민족사의 아픔을 간직한 곳이기도 하다. 시흥갯골생태공원은 경기도 유일의 내만 갯골과 옛 염전의 정취를 느낄 수 있는 아름다운 곳이다. 칠면초, 나문재, 퉁퉁마디 등의 염생식물과 농게, 방게 등 각종 어류, 양서류가 서식하고 자연 생태가 온전히 보존되어 2012년 2월 국가습지보호구역으로 지정되었다.");
                break;
            case R.id.gt21:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/05/2553505_image2_1.bmp").into(binding.gtImage);
                binding.gtTitle.setText("가치가");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 가평군 가평읍 용추로 269");
                binding.gtoverview.setText("누구나 알지만 다 알기는 어려운 곳이 바로 가평이다. '가치가'는 ‘같이하는 가치 여행’을 모토로 지역 주민들만이 경험하는 청정 가평의 숨겨진 가치와 순간들을 여행자들과 나누며 휴식과 영감, 활력을 함께 찾아가는 지속가능한 여행 문화를 만들어가고자 한다. 경기도에 속하지만 강원도와 맞닿아 있는 가평은 면적의 83%가 산지로 이루어져 있다. 가평 주민들조차 그 비경을 다 알지 못할 만큼 강과 호수는 넓고, 산등성이와 골짜기를 넘어 깊숙이 자리한 마을들이 많다. 그렇기에 몇몇 유명관광지들을 여행하는 것만으로는 가평의 매력을 제대로 파악 할 수 없다. 누구나 알지만 다 알기는 어려운, 가평의 숨겨진 매력과 가치를 보여주고 싶었던 가평 지역주민들은 공정여행에 기반한 같이하는 가치여행을 모토로 가치가여행사를 창업하였고, 현재 지역 주민들만이 경험하는 청정 가평의 숨겨진 가치와 순간들을 여행자들과 나누며 휴식과 영감, 활력을 함께 찾아가는 지속가능한 여행 문화를 가평에 정착시켜 나가고 있다. 가평의 호수길을 따라 떠나는 호수마을 뱃길 여행 가치가, 여자끼리 실내스포츠클라이밍, UTV바이크, 캠핑기술배우기 등을 하는 걸크러쉬 레포츠 투어 가치가;, 국내 최대 잣나무숲에서 힐링, 잣향기푸른마을에서 우든펜 제작 등을 체험할 수 있는 가평잣나무숲여행 가치가 상품 등을 운영하면서 가평을 다른 시각에서 다양하게 즐길 수 있는 기회를 제공하고 있다.");
                break;
            case R.id.gt22:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/24/2552724_image2_1.bmp").into(binding.gtImage);
                binding.gtTitle.setText("동동카누");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 양평군 개군면 공세리 389번지");
                binding.gtoverview.setText("양평은 남한강과 북한강이 만나 한강의 본류를 이루는 곳이다. 이런 환경에 힘입어 양평에서는 카누 선수들이 계속 배출되고 있다. 그러나 양평에는 이들이 수년간 배우고 훈련한 카누 전문가로서의 능력을 발휘할 장소가 없었다. 이를 안타깝게 여긴 카누선수, 지도자 출신들은 양평카누협회를 만들어 양평군 내 카누 체험 및 교육 시설 마련을 모색하였고, 양평카누협회와 관광두레가 의기투합하면서 양평수상안전교육원이 설립되었다. 이후 2014년 문화체육관광부에서 실시하는 관광두레사업의 일환으로 물맑은 양평의 원덕보(흑천)에서 양평카누체험사업을 시작하였고, 물위에 카누배가 고요하게 둥둥 떠있는 걸 모티브로 의역하여 &apos;동동카누&apos;라는 브랜드가 탄생하였다. 카누는 수상에서 이루어지는 특성상 안전이 우선시되기에 전체 주민이 2016년 인명 구조 자격증을 취득하였고, 현재까지 한 건의 안전사고도 없이 운영되고 있다. 한 해 1만명 이상의 체험객들이 방문하고 있으며 그 평가 또한 긍정적으로 양평의 새로운 즐길거리로 자리매김하고 있다");
                break;
            case R.id.gt23:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/07/2553707_image2_1.bmp").into(binding.gtImage);
                binding.gtTitle.setText("구석구석여행사");
                binding.gtTel.setText("");
                binding.gtAddress.setText("경기도 연천군 전곡읍 전곡로 112");
                binding.gtoverview.setText("구석구석여행사는 관광사업에 관심 있는 연천의 체험농장주들이 모여, 농장들을 연계한 네트워크형 체험상품과 연천군의 문화와 생태, 역사와 자연 자원을 활용한 관광상품을 통해 연천의 구석구석을 보여주기 위해 설립 되었다. 기존의 농촌체험에만 초점을 맞춰 구성된 상품과는 달리 차별화를 위해 DMZ 생태관광, 기찬먹방여행, 병영 체험 등 연천만의 상품을 기획, 개발하고 있다. 이는 군사지역인 연천은 90% 이상이 군사시설 보호구역이라는 지역적 약점을 역으로 이용하여 개발한 상품들이다. 이 외에도 쿠킹 콘텐스트 워크숍 프로그램, 한의학 전문가와 함께 떠나는 기찬 먹방여행 등의 다양한 상품을 운영하고 있다.");
                break;
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

//    public void getData(String contentTypeId, String contentId){
//        StringBuffer buffer = new StringBuffer();
//
//        String pageNo = "1";
//        String numOfRows = "2";
//        String MobileApp = "TripFair";
//        String MobileOS = "AND";
//        String arrange = "A";
//        String defaultYN = "Y";
////        String contentTypeId = "12";
////        String contentId = "2820274";
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
//                        if(tag.equals("item"));
//                        else if(tag.equals("addr1")) {
//                            xpp.next();
//                            buffer.append(xpp.getText());
//                        }
//                        else if(tag.equals("firstimage")) {
//                            xpp.next();
//                            image = xpp.getText();
//                            // Glide.with(getActivity()).load(image).into(food_image1); //첫번째. food_image id가 전역이 아니라 onCreate 밖에서 안됨.
//                            //두번째. getActivity()도 밖에서 되는지 모르겠음.
//                        }
//                        else if(tag.equals("overview")) {
//                            xpp.next();
//                            //buffer.append(xpp.getText());
//                            tel = xpp.getText();
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
//        //return buffer.toString();//StringBuffer 문자열 객체 반환
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onBack() {
        Log.e("Other", "onBack()");
        // 리스너를 설정하기 위해 Activity 를 받아옵니다.
        MainActivity activity = (MainActivity)getActivity();
        // 한번 뒤로가기 버튼을 눌렀다면 Listener 를 null 로 해제해줍니다.
        activity.setOnBackPressedListener(null);
        // MainFragment 로 교체
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containers, gyeonggiTourFragment).commit();
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