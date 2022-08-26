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
import com.example.tripfair.databinding.FragmentGyeongsangTourBinding;
import com.example.tripfair.databinding.FragmentJeonlaTourBinding;


public class JeonlaTourFragment extends Fragment implements MainActivity.OnBackPressedListener {

    JeonlaTourFragment jeonlaTourFragment;
    private FragmentJeonlaTourBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentJeonlaTourBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        jeonlaTourFragment = new JeonlaTourFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_jeonla_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("전라 관광지"); // 툴바 제목 설정

        binding.jtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.jt1.setOnClickListener(this::onClick);
        binding.jt2.setOnClickListener(this::onClick);
        binding.jt3.setOnClickListener(this::onClick);
        binding.jt4.setOnClickListener(this::onClick);
        binding.jt5.setOnClickListener(this::onClick);
        binding.jt6.setOnClickListener(this::onClick);
        binding.jt7.setOnClickListener(this::onClick);
        binding.jt8.setOnClickListener(this::onClick);
        binding.jt9.setOnClickListener(this::onClick);
        binding.jt10.setOnClickListener(this::onClick);

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/86/2819886_image2_1.jpg").into(binding.jtImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2821808_image2_1.jpg").into(binding.jtImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/54/2821654_image2_1.jpg").into(binding.jtImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/72/2819872_image2_1.jpg").into(binding.jtImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2819608_image2_1.jpg").into(binding.jtImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/04/2819604_image2_1.jpg").into(binding.jtImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2819595_image2_1.jpg").into(binding.jtImg7);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/32/2552832_image2_1.bmp").into(binding.jtImg8);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/62/2552862_image2_1.bmp").into(binding.jtImg9);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/75/2552775_image2_1.jpg").into(binding.jtImg10);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.jtAll.setVisibility(View.GONE);
        binding.jtFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.jt1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/86/2819886_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("순솝 (더감동협동조합)");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 순천시 이수1길 20");
                binding.jtoverview.setText("순솝은 순천과 자연에서 얻은 풍요로움을 비누에 담아내어 순천을 담은 비누, 순천을 닮은 비누를 통해 친환경적인 삶에 가까이 가고자 하는 주민 공동체 ‘더감동협동조합’에서 만든 브랜드이다. 또한 친환경 제품인 비누와 같이 사용하면 좋은 곁들임 제품인 도자기 비누 받침대, 소창 수건, 삼베 비누망 등을 제조하여 판매 중이다. 지역 내 로컬 디자이너와 크리에이터들과 함께 순천의 이야기를 담아내고 있다. 순천을 담은 비누, 순천만에 사는 동식물편 비누 DIY 키트를 제조·판매하고 있으며, 환경의 중요성과 함께 비누 및 인센스 만들기 체험 프로그램을 운영하고 있다.\n");
                break;
            case R.id.jt2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2821808_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("두만꽃피오리(두만숲속학교)");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라북도 임실군 두만1길 45-50 두만숲속학교(유아숲체험원)");
                binding.jtoverview.setText("전북 임실의 주민사업체 ‘두만꽃피오리’는 임실 팔경 중 하나인 두만산을 배경으로 생태 마을 두만숲속학교를 운영하고 있다. 어른과 아이 모두 자연의 넉넉함과 고요함을 만끽하며 쉼을 통해 평온함을 느끼는 휴식 공간이다. 꽃누르미, 자연물 놀잇감, 텃밭 가꾸기, 자연생태 습성놀이터같은 다양한 체험 활동은 두만꽃피오리의 지향점이 가장 돋보이는 과정이다. 이 외에도 참여하는 팀의 인원과 연령, 성향 등을 고려해 눈높이에 맞는 체험활동을 선보인다. 모든 과정에서 참가자는 자연의 소중한 가치와 유대를 배우고 조금씩 성장해 나갈 수 있다. 두만꽃피오리는 배움과 쉼, 그리고 힐링의 공간을 넘어 다양한 형태의 사랑과 감사를 나눌 수 있는 공간으로 도약하기 위해 노력한다.\n");
                break;
            case R.id.jt3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/54/2821654_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("문화가꽃피다(한옥카페 돌담길)");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 장성군 수산2길 12-5");
                binding.jtoverview.setText("전남 장성의 주민사업체 ‘문화가꽃피다’가 운영하는 돌담길은 한옥 카페 겸 전통문화 공예 체험 공간이다. 최근 SNS를 통해 한옥과 전통문화를 동시에 즐길 수 있다는 사실이 알려지면서 장성 관광객들의 발길이 크게 늘었다. 한옥 특유의 서정적인 분위기가 물씬 풍기는 카페는 돌담길의 매력을 십분 느낄 수 있는 공간이다. 단팥 라떼와 팥 비트 차가 이곳의 대표메뉴다. 별채인 사랑채에서는 보자기 공예와 전통매듭 짓기 같은 공예 체험을 할 수 있다. 둘 다 쉽게 배울 수 있으면서 일상생활에서 활용도가 높아 인기가 많다. ‘문화가 꽃피다’는 경력 단절 여성, 결혼이주여성, 상호문화가정 어린이 등 다양한 계층의 모두가 함께하며 이름처럼 다채롭고 풍부한 문화를 꽃피울 수 있도록 더욱 활발한 활동을 펼칠 예정이다.\n");
                break;
            case R.id.jt4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/72/2819872_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("별이랑");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 순천시 일출길 141");
                binding.jtoverview.setText("'별이랑'은 숙박형 농촌휴양 프로그램과 공예체험, 특산물 제조공정체험, 지역관광을 제공하는 관광두레 주민사업체로, 순천만과 농어촌의 이색관광체험을 제공함으로써 맞춤형 여행을 즐길 수 있도록 도움을 준다. 순천만과 별량의 농어촌을 찾는 관광객과 소비자에게 순천만의 갯벌생태 공방체험과 첨산 농막농촌체험을 통해, 지역의 다양한 관광자원을 묶어서 활용하고 우수한 지역특산품을 소개한다. 로컬에서 힐링숙박하며 잘거리 뿐만 아니라 할거리, 먹거리, 살거리의 평면적 선택지를 기획하여 지역형 테마여행을 입체적으로 설계, '별이랑'에서는 특색있는 민박체험과 계절형 프로그램, 다른 곳에서는 볼 수 없었던 농어촌 특산품과 기념품들을 만날 수 있다. 순천만에 서식하는 짱뚱어 모양의 오카리나 만들기 등, 흙과 함께 하는 도자체험을 즐길 수 있다.\n");
                break;
            case R.id.jt5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2819608_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("사우스마켓(남쪽동네)");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 순천시 역전광장1길 6");
                binding.jtoverview.setText("'로컬푸드 큐레이션 샵 - 사우스마켓'은 로컬푸드 스토리를 콘텐츠화 하여 음식을 통해 지역문화를 경험할 수 있도록 하며, 로컬을 여행 온 여행객들을 대상으로 소중한 사람들에게 선물하고 싶은 로컬푸드 기념품을 제조, 판매하는 브랜드이다. 판로를 찾기 힘든 지역주민들에게는 안테나샵이 되어 주고 매장을 찾는 고객들에게는 한 곳에서 다양한 로컬상품을 보고, 선택할 수 있는 편의를 제공한다. 사우스마켓은 순천을 방문하는 여행객들에게 양질의 상품을 제공함으로써 순천에 대한 긍정적인 인식을 심어주고자 한다. 순천에서 떠나는 여행객들과 그들의 소중한 사람에게 추억을 나눌 수 있는 마음이 되고자 하는 사우스마켓은 순척역과 종합버스터미널 가까이에 위치하고 있다.\n");
                break;
            case R.id.jt6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/04/2819604_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("드로잉라이프");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 순천시 서문로 2 오행생식건강원");
                binding.jtoverview.setText("드로잉라이프는 순천의 자연과 마을을 스토리와 감각으로 엮어 그 지역에서만 느낄 수 있는 색다름을 전달하는 브랜드이다. 드로잉라이프의 드로잉투어는 골목길의 이야기와 사람들의 삶을 엮어 드로잉을 통해 다른 삶을 여행해 볼 수 있게 하는 스토리기반 투어 상품으로 메이저 여행지뿐만 아니라 지역의 삶도 함께 느낄 수 있는 특별한 시간을 제공한다. 이곳을 찾는 사람들은 순천의 독특한 이야기가 담긴 먹거리 상품과 굿즈도 구매할 수 있다. 이 외에도 생태적 경험을 위한 투어 및 생태 공간 대여 서비스를 운영하고 있으며, 드로잉라이프의 브랜드 아이덴티티를 함축한 카페를 준비하고 있다.\n");
                break;
            case R.id.jt7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2819595_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("밀림슈퍼 연구소");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 순천시 역전2길 46 밀림다방");
                binding.jtoverview.setText("순천의 천연 관광자원인 동천을 중심으로 국가정원과 원도심을 관광할 수 있는 전기 자전거를 개발 및 제작하여 렌탈 및 판매를 준비하고 있다. 실용적이며 트렌디한 디자인으로 mz세대의 라이프 스타일에 딱맞는 특색있는 전기자전거를 개발하고 있으며, 밀림슈퍼연구소의 전기자전거와 함께 순천을 여행한다면 순천의 자연을 더욱 더 자세하게 탐미할 수 있다.\n");
                break;
            case R.id.jt8:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/32/2552832_image2_1.bmp").into(binding.jtImage);
                binding.jtTitle.setText("두레아트");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 순천시  중앙4길 (6-11)");
                binding.jtoverview.setText("두레아트는 생활 속에서 익숙한 것들의 새로운 변화를 통해 가치를 살리는 모토를 가진 업사이클링 기념품, 체험을 제공하는 주민사업체 이다. 버려지는 폐스타킹을 활용한 공예품(머리핀,브로치등)을 판매하고 직접 만들어볼 수 있어 여행자들에게 사회적 가치를 담은 여행을 할 수 있도록 한다. 남녀노소 누구나 찾아와 손쉽게 체험이 가능하도록 스타킹공예체험, 정크아트, 커피바리스타, 가죽공예, 냅킨아트 등 다양한 체험 아이템이 갖추어져 있으며, 다양한 관광상품 제작을 통해 인사동에 위치한 한국관광명품관 등 다양한 곳에서 판매되고 있다.\n");
                break;
            case R.id.jt9:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/62/2552862_image2_1.bmp").into(binding.jtImage);
                binding.jtTitle.setText("토요오픈스튜디오");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 구례군 광의면 예술인길 57");
                binding.jtoverview.setText("마음만 먹으면 언제든지 예술과 예술가를 만날 수 있는 마을, '자연 속의 살아있는 미술관' 구례예술인마을은 화가, 조각가, 도예가 등 은퇴를 앞둔 30여 가구의 예술가들이 거주와 예술작업, 전시를 위해 삶의 터전을 옮겨와 모여 살면서 조성됐다. 이 중 6명의 예술가를 주축으로 마을을 보다 생산적이고 지속가능한 창작 공간으로 만들어가기 위해 토요오픈스튜디오를 운영하기 시작했다. 토요오픈스튜디오는 매주 토요일마다 개인 창작공간인 예술가들의 집을 개방하여 방문객과 함께하는 체험 프로그램을 운영한다. 매주 토요일 'OPEN 예술in' 이라는 깃발이 꽂힌 예술가들의 개인 창작공간을 방문하여 예술가와 이야기를 나누고, 작품 관람 및 다양한 예술체험을 해볼 수 있다.\n");
                break;
            case R.id.jt10:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/75/2552775_image2_1.jpg").into(binding.jtImage);
                binding.jtTitle.setText("금오도캠핑장");
                binding.jtTel.setText("");
                binding.jtAddress.setText("전라남도 여수시 남면 대유길 36-2");
                binding.jtoverview.setText("몇 년 전부터 금오도 비렁길이 비경을 자아낸다는 입소문을 타면서 금오도로 향하는 관광객들의 발걸음이 대폭 늘었다. 비렁길 외에도 여행할 곳이 많다는 사실을 알려주고 싶었던 지역주민들은 여수시로부터 폐교를 매입해 <금오도캠핑장> 열었고, 체험상품까지 운영하고 있다. 다도해 푸른 바다를 앞마당 삼고 있는 <금오도캠핑장> 은 나무데크와 오토캠핑 여러개의 사이트와 글램핑장, 게스트하우스로 구성되어 있어 친구나 가족, 단체 등 누구나 찾아와 즐길 수 있다.이외에도 주민들이 직접 카약, 스노쿨링, 바다낚시, 호핑투어 등의 해양레저체험과 방풍나물 채취, 통발과 이강망 체험과 같은 농촌체험도 운영하며 주민과 여행자 모두가 행복한 휴양마을로 자리매김하고 있다.\n");
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
                .replace(R.id.containers, jeonlaTourFragment).commit();
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