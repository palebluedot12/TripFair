package com.example.tripfair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tripfair.databinding.FragmentGangwonTourBinding;
import com.example.tripfair.databinding.FragmentGyeongsangTourBinding;

public class GyeongsangTourFragment extends Fragment implements MainActivity.OnBackPressedListener{

    GyeongsangTourFragment gyeongsangTourFragment;
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

        gyeongsangTourFragment = new GyeongsangTourFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeongsang_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경상 관광지"); // 툴바 제목 설정

        binding.gstFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.gst1.setOnClickListener(this::onClick);
        binding.gst2.setOnClickListener(this::onClick);
        binding.gst4.setOnClickListener(this::onClick);
        binding.gst5.setOnClickListener(this::onClick);
        binding.gst6.setOnClickListener(this::onClick);
        binding.gst7.setOnClickListener(this::onClick);
        binding.gst8.setOnClickListener(this::onClick);
        binding.gst9.setOnClickListener(this::onClick);
        binding.gst10.setOnClickListener(this::onClick);
        binding.gst11.setOnClickListener(this::onClick);
        binding.gst12.setOnClickListener(this::onClick);
        binding.gst13.setOnClickListener(this::onClick);
        binding.gst15.setOnClickListener(this::onClick);
        binding.gst17.setOnClickListener(this::onClick);
        binding.gst21.setOnClickListener(this::onClick);
        binding.gst22.setOnClickListener(this::onClick);
        binding.gst23.setOnClickListener(this::onClick);
        binding.gst24.setOnClickListener(this::onClick);


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

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.gstAll.setVisibility(View.GONE);
        binding.gstFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.gst1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/01/2820401_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("룰루낭만협동조합");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 김해시 가락로 102");
                binding.gstoverview.setText("룰루낭만 협동조합은 김해를 중심으로 호동이 농원, 삼계 풀잎센터, 성림가든, 송화도예, 우리 관광여행사 등 각자의 사업을 운영 중인 주민 5명이 모여 결성한 여행 전문 주민사업체이다. 이들은 국제 슬로시티인 김해를 찾는 여행객들이 마음을 정화하고 선물 같은 시간을 만들어 갈 수 있도록 다양한 여행상품을 기획하였다. 아이들에게는 울창한 숲속에서 곤충의 생태에 대해 깊이 있게 알 수 있는 야간 곤충캠프가, 성인에게는 전통 인도 요가를 하며 나를 찾고 마음을 열어가는 명상 여행이 인기 있다. 룰루낭만은 관광객들이 김해의 숨은 매력을 느끼고 낙동강변을 따라 마음을 정화하고 심신의 여유와 충만한 행복을 느낄 수 있도록 노력한다.\n");
                break;
            case R.id.gst2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/33/2820133_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("무덤덤투어(더휴앤)");
                binding.gstTel.setText("");
                binding.gstAddress.setText("대구광역시 동구 반야월북로53길 10");
                binding.gstoverview.setText("더휴앤은 과거와 현대가 공존하는 도시 대구에서는 대구만의 상품 개발을 하고 있는 지역 여행사이다. 그 중 대표 상품인 무덤덤투어는 대구의 관광객이 제대로 대구를 느낄 수 있도록 만든 여행 상품이다. 이런 바람을 담아 만든 무덤덤투어는 우리나라 천연기념물에서 시작하며 옹기종기 붙어있는 수많은 무덤 사이로 깔끔하게 정돈된 길과 한 폭의 그림이 연상되는 장소에서 멋진 풍경을 배경으로 추억을 담을 수 있다. 스쳐 지나가던 천연기념물 측백나무 숲은 더 자세히 보고 싶은 공간이 되고, 도심의 전통 오일장에 숨겨진 스토리를 들으며 장도 보고 다양한 자연 풍경, 과거와 현대가 공존하는 공간에서 바쁘게만 살아온 나에게 주는 선물 같은 여행을 떠날 수 있다. 대표 상품 무덤덤투어 외에도 금호강을 따라 자전거로 떠나는 안달투어, 백조가 찾아오는 안심습지, 갓바위 여행 그리고 덤덤야행과 외국인 생태 프로그램 등 다양한 상품을 만들고 있다.\n");
                break;
            case R.id.gst4:
                Glide.with(getActivity()).load("").into(binding.gstImage);
                binding.gstTitle.setText("폴링 인 진주");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 진주시 범골로54번길 30-9");
                binding.gstoverview.setText("폴링 인 진주는 진주여행 로컬 브랜드로써 진주에 진주다운 여행을 만들어 나가는 회사이다. 진주 내에 무장애 여행과 더불어 다양한 여행을 선보일 예정이다.\n");
                break;
            case R.id.gst5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/86/2820686_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("배건네공작소");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 진주시 강남로325번길 7-1");
                binding.gstoverview.setText("배건네공작소는 처음 커뮤니티모임에서 만난 주민들이 모여 만든 협동조합이다. 경남 진주 배건네 마을, 촉석루를 바라보는 이 작은 마을이야기에서 ‘우리가 진주다’를 품고 경남 진주만의 이야기를 발굴하고 마을 주민의 일상생활과 문화활동을 콘텐츠로 만드는 곳이다. 현재 배건네공작소에서는 문화기획, 지역아카이브, 스토리텔링을 통해 진주관광상품을 만들어 판매하기 위해 열심히 준비중에 있다.\n");
                break;
            case R.id.gst6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2820539_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("주티스트");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상북도 영주시 안정면 용주로1364번길 12");
                binding.gstoverview.setText("주티스트는 지역청년들과 로컬양조장이 협업하여 영주의 색깔을 담은 지역특산주 및 전통주체험, 양조장 스테이 등을 제공하는 주민사업체이다. 최근에는 사과, 복숭아 등 지역 농산물을 활용하여 젊은 감각의 새로운 과실 탄산주를 개발중이며, 전국 최초 '양조장 스테이' 상품을 도입하여 양조장 프라이빗 캠핑에서 즐기는 로컬푸드+바베큐와 영주생탁은 잊지 못할 추억을 선사해줄 것이다. 주티스트는 이러한 체험과 지역홍보를 통해 전통주 문화와 더불어 영주의 이야기를 전하는 문화공간을 조성하고자 한다.\n");
                break;
            case R.id.gst7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/48/2820348_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("잇다오지 창녕");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 창녕군 동포로 6");
                binding.gstoverview.setText("잇다오지창녕은 걷고 싶고 머무르고 싶은 공간인 외갓집을 콘텐츠로 한 마을 체험 여행사이다. 외가가 주는 푸근함과 편안함을 한나절 마을 탐방과 1박, 일주일, 한달살이를 통해 느낄 수 있다. 프로그램 '놀러 와 외갓집'은 땅콩떡 만들기 체험과 외갓집 밥상 체험, 계절 텃밭 체험이 가능하기 때문에 창녕군 귀농 프로그램과 연계한 귀농 체험이 필요한 많은 사람이 찾고 있다. '놀러 와 외갓집' 카페에서는 남지 주민들이 즐기던 남지 땅콩을 이용한 땅콩 두부, 땅콩 국수, 땅콩 차 등을 맛볼 수 있고, 숙박 시에 주민이 직접 만든 식사 한 끼를 경험할 수 있다. 주요 밥상 메뉴는 찌개와 제철 채소가 곁들여지는 계절 밥상이다. 제공되는 음식의 원재료를 수입산을 배제하는 것을 원칙으로 하여 외갓집을 상상하고 찾은 방문객에게 만족감을 준다. 낙동강 수변산책길과 한국의 아름다운 길로 지정된 남지개비리길이 가까이 있어서 1박 이상 여행 코스에 좋다.\n");
                break;
            case R.id.gst8:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/44/2820344_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("우포여행가방");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 창녕군 소목길 95");
                binding.gstoverview.setText("창녕군 우포늪 장재 기러기마을에 위치한 우포여행가방은 우포늪과 가장 가까운 마을이다. 우포여행가방의 석창성 대표는 우포늪에서 가업을 이어 고기를 낚는 어부이자 시인이며 사진작가이다. 우포여행가방은 천연재료를 사용한 비누, 방향제 등의 굿즈를 생산·판매하며 환경을 지키고 보존하는 여행을 위해 불편함을 감수한 우포늪 트레킹을 기획하고 있다.\n");
                break;
            case R.id.gst9:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/50/2820450_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("관사골작업실 협동조합");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상북도 영주시 두서길19번길 10");
                binding.gstoverview.setText("관사골작업실 협동조합은 수공예 분야의 전문성을 가진 3040 주부들로 구성되었다. 이곳은 영주관광 자원을 활용한 관광기념품 개발 및 판매, 지역 수공예작가들의 상품을 판매하는 편집숍, 관사골 원도심을 재미있게 체험할 수 있는 체험관광, 그리고 방문객이 직접 체험할 수 있는 공방형카페이다. 현재 관사골 일대 관광체험 제품들과 영주 관광기념품 등을 제작 개발하고 있으며, 주부들로 구성되어 실용성에 중점을 두고 제품을 개발하고 있다. 카페관사골에서 원도심만이 가지고 있는 아이템들을 만날 수 있고, 지역 수공예작가들의 제품들도 구매할 수도 있다. 앞으로 수공예체험과 더불어 관사골 원도심의 특징을 살린 철도 관련 골목투어 등 원도심관광의 안내센터이자 방문객의 휴식처, 체험형 관광 공방카페로 1타 5피 이상의 다양한 역할을 하는 관사골을 대표하는 곳이다.\n");
                break;
            case R.id.gst10:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/74/2820474_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("소백꽃차이야기");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상북도 영주시 안정면 대평로229번길 33-22");
                binding.gstoverview.setText("소백산꽃차이야기는 영주의 귀농 여성들로 구성 된 체험 농장형 꽃차 카페이다. 아름답고 다양한 꽃들을 농약 없이 손수 재배∙가공하여 친환경 꽃차와 식용꽃샐러드(여우꽃밥) 등 다양한 힐링푸드를 제공하고 있다. 뿐만 아니라 꽃을 활용해 팜크닉(농장 피크닉), 꽃차 카페, 꽃을 활용한 감각적이고 다채로운 체험상품들을 경험하는 곳으로, 꽃을 통한 오감만족 체험 장소 이다. 소백산꽃차이야기는 숲속 체험장 그리고 팜크닉 공간을 예약제로 제공, 영주의 팜크닉 메카로 자리잡기 시작한 곳이며 영주의 핫플레이스 그리고 여행지의 나이스한 코스로 많은 여행객들의 마음을 사로잡고 있다.\n");
                break;
            case R.id.gst11:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/44/2820144_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("서리단길 뮤지션 협동조합");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 양산시 증산역로 177 라피에스타");
                binding.gstoverview.setText("양산시 물금리 서리단길 트랜디 거리 조성 사업이 추진되면서, 서리단길 뮤지션 협동조합은 지역 관광 활성화를 위해 다양한 문화공연 프로그램을 개발하고 있다. 서리단길은 특히 80년 넘게 이어오는 전통 방식의 막걸리 양조장이 인기 있는 여행지로, 최근 들어 레트로한 느낌을 좋아하는 젊은 층이 많이 찾고 있다. 서리단길 뮤지션 협동조합은 이곳을 찾은 관광객들의 추억에 여운을 남기고 다시 찾고 싶은 환경을 만들고자 전통 음악을 주제로 하는 예술 공연을 상시 펼친다. 또한 증산 신도시에 ‘라피아트홀’을 개관하여 관객과 가깝게 소통하기 위해 노력한다. 이곳은 기타, 드럼, 시 낭송, 연극 등 장르 불문 다양한 문화공연을 쉽게 접할 수 있는 관광두레 공연장으로, 양산을 대표하는 문화센터로 발전해 나갈 계획이다.\n");
                break;
            case R.id.gst12:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/01/2820201_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("하모예");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 진주시 광제산로 368");
                binding.gstoverview.setText("하모예는 ‘그래! 잘 될거야!’라는 뜻의 진주 방언 ‘하모’와 예술을 뜻하는 ‘예’를 결합하여 만든 이름으로 긍정의 의미를 담은 진주 방언과 창의성 및 전통성을 바탕으로 한 예술성의 결합을 함축하고 있다. 하모예는 유네스코 공예-민속 예술창의도시에 어울리는 ‘진주시 문화유산과 함께하는 공예 관광 기념품 제작’을 핵심 과제로 삼고 진주시를 대표하는 다양한 문화유산을 표현하는 관광 기념품을 개발 및 판매하면서 동시에 진주시를 찾는 많은 관광객들의 오감을 만족 시킬 수 있는 체험 프로그램을 제공하고 있다.\n");
                break;
            case R.id.gst13:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/70/2817570_image2_1.JPG").into(binding.gstImage);
                binding.gstTitle.setText("밀알영농조합");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 진주시 죽곡길 7");
                binding.gstoverview.setText("밀알영농조합은 우리밀인 앉은뱅이밀로 요리하고, 먹고, 놀고, 농사체험 프로그램을 운영한다. 지역의 농가와 계약재배를 통해 밀을 생산하고 밀가루, 국수, 빵, 과자 등 다양한 우리밀 식품과 밀키트를 개발하고 판매한다. 체험장은 고소한 냄새를 맡고, 부드러운 밀가루를 만지고 뒹굴며 놀 수 있는 가루방과 통밀방으로 나뉘어져 있다. 밀 수확시기인 6월이면 밀 축제가 펼쳐진다. 수확과 타작을 직접 해보고 이제는 사라지고 없는 추억의 밀서리도 체험할 수 있다.\n");
                break;
            case R.id.gst15:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/15/2698915_image2_1.bmp").into(binding.gstImage);
                binding.gstTitle.setText("이랑협동조합");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상남도 통영시 도남로 195");
                binding.gstoverview.setText("통영이랑은 통영의 역사, 문화, 관광콘텐츠를 기반으로 통영테마여행, 이순신아카데미, 단체교육연수, 체험학습, 워크숍을 운영하는 단체전문 주민여행사이다. '지역과 통(TONG)해라'Together(함께), Original(통영만의), News(알리다), Global(세계에) 라는 의미의 통영이랑은 통영만이 가지고있는 모습을 소개하며 지역과 함께 성장하기위해 노력하고 있다.\n");
                break;
            case R.id.gst17:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/15/2821415_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("비손농장(포항체험잇다)");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상북도 포항시 북구 청하면 비학로 1889-157");
                binding.gstoverview.setText("tvN 예능 프로그램<바퀴 달린 집>에도 소개된 바 있는 비손농장(주식회사 포항체험잇다)은 오토캠핑장이다. 오토캠핑장 이외에도 비손농장을 지칭하는 수식어가 있는데 바로 농촌 체험농장, 물놀이장, 카페다. 체크인/아웃을 하는 관리동에서는 카페와 매점을 운영 중이고, 뒤 뜰에는 거위와 토끼를 키우며, 텃밭에서는 작물 수확 시기에 맞춰 봄나물, 여름 과일, 밤, 고구마 가을작물 수확 체험과 이를 이용한 베이킹 체험 프로그램을 연다. 또한, 여름이면 대형 물놀이장을 열어 손님을 맞는다. 사시사철 변화무쌍하게 손님을 맞는 비손농장(주식회사 포항체험잇다)의 권민제 대표는 귀농을 위해 처음 이 농장을 열었다가 농장을 찾는 손님들의 권유로 캠핑 야영장으로 변모하기 시작했다. 주말이면 비손농장(주식회사 포항체험잇다)에는 싱그러운 숲과 맑은 공기 그리고 월포 바다 전망을 마당으로 삼고 싶어하는 전국 각기의 캠핑 족들이 찾아온다. 데크, 파쇄석, 잔디 등 구획마다 특색 있는 텐트 존부터 반려동물과 함께 거닐 수 있는 산책로, 아이들이 좋아하는 모래 놀이터, 사계절 수확, 베이킹 체험까지 갖가지의 테마로 가득하다. 더 나아가 주식회사 포항체험잇다로 지역 청년들이 모여 주변 농가와 협업하여 체험 프로그램 진행을 준비 중이다.\n");
                break;
            case R.id.gst21:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/02/2821402_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("힐링로드(청하체리힐, 드로잉체리공방/누나서프/HJ디저트)");
                binding.gstTel.setText("");
                binding.gstAddress.setText("경상북도 포항시 북구 화두길 32-45");
                binding.gstoverview.setText("[농촌 복합 문화공간 + 해양레포츠 + 자연속 캠핑] 포항시 북구의 농어촌 지역에 자리 잡고 있는 청하체리힐, 드로잉체리공방(HJ디저트), 누나서프가 파트너쉽을 구축하여 \"힐링로드\"라는 지역 거점 브랜드(주민공동체)를 만들고자 한다. \"청하체리힐\"은 체리와 산딸기를 재배하여 수확 체험을 운영하는 6차산업 기반의 농업경영체이다. 또한, 드로잉체리라는 예술 체험 공방을 함께 운영하고 있어 농작물 수확이 이루어지지 않는 기간에도 관광객에게 다양한 체험의 기회를 제공하고 있다. 전문베이킹강사를 채용하여 디저트와 쿠킹체험에도 전문성을 더하였다. \"누나 서프\"는 포항시 북구 청하면 월포해수욕장에 위치하고 있는 서핑샵이다. 월포해수욕장을 찾는 서퍼들과 관광객을 대상으로 서핑에 대한 교육과 체험 프로그램을 운영 중이다. 현재는 종영된 드라마 “갯마을차차차” 촬영지로 더욱 관광객의 유입이 높아지고 있다. 위의 업체가 모여 주민공동체 \"힐링로드\"를 만들고자 한다. 각자의 사업장을 운영하며 쌓아온 노하우를 활용하여 구매력 있는 관광객의 방문을 촉진시키는 관광 패키지 상품을 개발하고 적극적인 홍보, 마케팅을 통해 관광객을 유입시킴으로써 부가 가치를 창출하고 나아가 농촌 지역 경제 활성화에 기여하고자 한다.\n");
                break;
            case R.id.gst22:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2820113_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("명품옻골1616");
                binding.gstTel.setText("");
                binding.gstAddress.setText("대구광역시 동구 옻골로 195-5");
                binding.gstoverview.setText("명품옻골1616협동조합은 대구에서 제일 오래된 마을로서 경주최씨 대암공파의 자손들이 모여사는 옻골마을의 자손들이 운영하는 마을기업이다. 옛 전통을 지키고 후세에 전달 방법을 찾다가 사업의 3가지 갈래로 정하고 2022년 현재 모든 준비 작업을 마무리하고 본격적으로 명품 관광이 되도록 노력하고 있다. 200여년된 고가옥을 활용한 한옥스테이, 여러가지 민속 놀이를 통한 체험, 한옥 카페를 이용한 전래 전통 음료 개발을 통한 관광객 요구 충족 등 전래의 풍습과 가치를 다시 한 번 오늘에 되살리고 옻골마을을 찾는 모든 관광객들에게 힐링의 장소로 각광받을수있도록 노력하고 있다.\n");
                break;
            case R.id.gst23:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2820139_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("모냥");
                binding.gstTel.setText("");
                binding.gstAddress.setText("대구광역시 동구 둔산로 5");
                binding.gstoverview.setText("‘모냥’은 모양의 사투리로 ‘세상 모든 모양’이라는 의미를 가지고 있다. 대구 지역의 젊은 작가들이 모여 실생활에서 많이 쓰이는 일회용품을 도자기로 대체하고자 일상에서 쓰이는 다양한 생활용품을 제작하고 있고 직접 도자기를 만들어 볼 수 있는 체험 프로그램을 운영하고 있다.\n");
                break;
            case R.id.gst24:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/64/2820464_image2_1.jpg").into(binding.gstImage);
                binding.gstTitle.setText("소백명품서클");
                binding.gstTel.setText("010-3789-5735");
                binding.gstAddress.setText("경상북도 영주시 부석면 영부로117번길 76-7");
                binding.gstoverview.setText("소백명품서클은 “나만 알고 싶은 마음의 숲, 영주” 라는 컨셉으로 구성원의 대규모 명품 농장인 명이나물 산약초 농장, 와인 포도 농장, 양계장, 통나무 독채 숙박, 샘사이트 등 숨겨진 영주의 멋진 비경을 가진 농장에서 치유와 힐링을 할 수 있는 시간을 고객맞춤형으로 제공한다. 지금까지 알려지지 않은, 나만 알고 싶은 소백산의 아름다운 비경과 몸에 좋은 현지인이 추천하는 명품 농특산품을 소개한다. 소백산의 치유, 힐링, 사색의 시간과 함께, 영주 선비정신까지 느낄 수 있는 곳이다. 모든 체험 관광은 고객 맞춤형 예약제로 운영된다.\n");
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

    @Override
    public void onBack() {
        Log.e("Other", "onBack()");
        // 리스너를 설정하기 위해 Activity 를 받아옵니다.
        MainActivity activity = (MainActivity)getActivity();
        // 한번 뒤로가기 버튼을 눌렀다면 Listener 를 null 로 해제해줍니다.
        activity.setOnBackPressedListener(null);
        // MainFragment 로 교체
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containers, gyeongsangTourFragment).commit();
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