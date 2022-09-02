package com.tripfair.tripfair;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.tripfair.tripfair.databinding.FragmentGangwonTourBinding;
import com.tripfair.tripfair.databinding.FragmentGyeonggiTourBinding;


public class GangwonTourFragment extends Fragment implements MainActivity.OnBackPressedListener {

    GangwonTourFragment gangwonTourFragment;
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

        binding.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        gangwonTourFragment = new GangwonTourFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gangwon_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("강원 관광지"); // 툴바 제목 설정

        binding.gwtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.gwt1.setOnClickListener(this::onClick);
        binding.gwt3.setOnClickListener(this::onClick);
        binding.gwt4.setOnClickListener(this::onClick);
        binding.gwt5.setOnClickListener(this::onClick);
        binding.gwt6.setOnClickListener(this::onClick);
        binding.gwt7.setOnClickListener(this::onClick);
        binding.gwt8.setOnClickListener(this::onClick);
        binding.gwt9.setOnClickListener(this::onClick);
        binding.gwt11.setOnClickListener(this::onClick);
        binding.gwt15.setOnClickListener(this::onClick);
        binding.gwt17.setOnClickListener(this::onClick);
        binding.gwt19.setOnClickListener(this::onClick);
        binding.gwt23.setOnClickListener(this::onClick);
        binding.gwt24.setOnClickListener(this::onClick);


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

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.gwtAll.setVisibility(View.GONE);
        binding.gwtFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.gwt1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/70/2820170_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("감성공작소");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 삼척시 대학로 9-1 마스터컷");
                binding.gwtoverview.setText("감성공작소는 친환경과 상생을 중시하는 삼척의 경력 단절 여성들이 모여서 만든 사업체이다. \n" +
                        "감성공작소를 방문 하면 첫 번째로, 삼척 바다의 푸른 모습을 지킬 수 있는 비치코밍이 스며든 체험 상품을 만날 수 있다. 바다에 버려진 유리 조각이나 조개 껍데기등을 활용해 그립톡을 직접 만들어 볼 수 있으며, 재료들을 체험객이 직접 바다에서 주어오면 체험비를 할인해주고 있다. 비치 코밍을 통해 관광객들이 환경에 대한 의미를 생각해 볼 수 있도록 하며 지구를 아끼고 바다를 생각하는 마음들을 공유하고자 한다. 두 번째로 감성공작소만의 유니크한 기념품들. 조합원들이 자체적으로 개발해 디자인을 적용한 오랍드리꽃, 이사부사자 테마를 적용한 기념품들과 직접 수공예로 만든 유니크한 제품들을 만날 수 있다. 이외에도 지역 주민과 관광객을 대상으로 다양한 예술 교육 수업도 운영하고 있는데 모든 체험과 교육은 예약제로 운영되고 있다.");
                break;
            case R.id.gwt3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/49/2820849_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("와우미탄");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 평창군 마하길 41-5");
                binding.gwtoverview.setText("와우미탄은 평창군 미탄면에 거주하고 있는 5명의 청년이 구성한 협동조합이다. 산너미목장, 어름치마을, 옐로우트리 카페, 평창연화농원을 운영하고 있는 청년들은 미탄면의 잘 보존된 자연과 건강한 농특산물을 기반으로 주민여행사를 운영하고 있다.");
                break;
            case R.id.gwt4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/98/2698698_image2_1.bmp").into(binding.gwtImage);
                binding.gwtTitle.setText("행복한 숲");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 홍천군 서면 도롱골길 195-19");
                binding.gwtoverview.setText("관광두레 주민사업체인 '컬러팜포레스트웨딩 협동조합' 소속으로 팜웨딩, 파티 등 다양한 체험이 가능한 펜션이다. 홍천강의 아름다운 풍경과 아늑한 객실에서 휴식을 취할 수 있고 화관만들기, 떡케잌 만들기, 캘리그라피 등 다양한 체험이 준비되어 있다. 전 객실 리버뷰로 전망이 좋다.");
                break;
            case R.id.gwt5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/71/2820771_image2_1.JPG").into(binding.gwtImage);
                binding.gwtTitle.setText("대관령마켓");
                binding.gwtTel.setText("010-7742-7808");
                binding.gwtAddress.setText("강원도 평창군 대관령면 대관령로 117");
                binding.gwtoverview.setText("대관령마켓은 지역프리마켓 셀럽들이 모여 평창군의 관광기념품을 제작, 개발하여 판매하는 관광두레 주민사업체이다. 홈패션, 목공예, 퀼트 등 다양한 소재로 인테리어 용품, 생활용품, 잡화 등 다양한 상품들로 이루어져 있다. 사무실과 작업실과 별개로 판매장은 대관령의 바우파머스몰을 기점으로 하고 있다. 평창군 8개면마다 1곳 이상의 기념품판매장을 거점으로 삼을 계획에 있다. 현재는 기존의 상품을 비롯하여 캐릭터 개발과 아이템 개발에 집중하고 있으나, 하반기 시작 무렵에는 더 다양한 상품으로 선보일 예정이다. 체험상품으로는 목공예품(나무도마, 스텐드, 벽시계, 만녀필, 사프, 펜 등) 만들기가 있고, 패브릭 아트( 아크릴 그림그리기, 앞치마 만들기, 두건 만들기, 소품 만들기 등)가 있다. 체험은 별도의 기간을 지정해서 공지 후, 예약제로 실시 할 예정이다.");
                break;
            case R.id.gwt6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/65/2820865_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("평창사랑");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 평창군 문화택지길 41-12");
                binding.gwtoverview.setText("평창사랑은 귀농귀촌을 꿈꾸는 사람들에게 다양한 귀농인들의 삶을 모델로 제시하며 여러 가지 체험과 숙박, 농산물 꾸러미 판매 등 모듈형 투어 프로그램을 제공한다.\n");
                break;
            case R.id.gwt7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/40/2820840_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("오대산힐링빌리지(별마루)");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 평창군 능골길 52-77");
                binding.gwtoverview.setText("오대산힐링빌리지는 평창군에 거주하는 주민들로 구성된 주민사업체로 구성원들 모두 숲해설 교육을 이수하고 자격증을 보유하고 있다. 농촌/생태 관광 및 체험을 제공하는 것을 목표로 운영되고 있으며 브랜드 “별마루”를 개발해 생산되는 농산물, 프로그램 등에 적용하고 있다. 해발 700미터 고지에서 평창의 청정 자연을 만끽할 수 있는 별보기체험과 숲을 그대로 즐길 수 있는 노르딕워킹체험, 직접 재배한 고랭지 배추를 이용한 김장체험 등 다채로운 프로그램을 진행하고 있다. 특히 노르딕워킹은 설피와 같은 장비를 이용해 눈 위에서도 걷기 체험을 할 수 있어 이색적이다. 이밖에 가족단위로 즐길 수 있는 숲해설, 숲치유 등 프로그램도 마련되어 있다. 평창 지역의 자원과 문화를 최대한 활용한 체험 프로그램들을 지속적으로 개발하고 있으며 이를 통해 방문객들에게 진정한 힐링을 제공하고 있다.\n");
                break;
            case R.id.gwt8:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/37/2820837_image2_1.JPG").into(binding.gwtImage);
                binding.gwtTitle.setText("평창캠프닉");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 평창군 태기로 228-33 한화리조트");
                binding.gwtoverview.setText("평창캠프닉(주식회사 아이평창유)는 소풍개념의 먹거리 관광 특화상품을 체험하는 청정지역 평창의 유휴공간에서 우리만의 가족, 연인들이 즐길 수 있는 프로그램을 제공하는 주민 여행 기업이다. 청정지역 강원도 평창에서의 ‘평창캠프닉’은 특별한 장비가 필요없고 빈몸으로 혹은 대중교통을 이용하여 즐기는 체험 프로그램으로 전화로 예약이 가능하며 이외에도 다양한 감성 체험 상품들을 운영하고 있다.\n");
                break;
            case R.id.gwt9:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/67/2698767_image2_1.bmp").into(binding.gwtImage);
                binding.gwtTitle.setText("무네미농장");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 홍천군 내면 수유동길 637");
                binding.gwtoverview.setText("관광두레 주민사업체인 '컬러팜포레스트웨딩 협동조합' 소속으로 사족여행, 워크숍 등 단체전문 주민사업체이다. 강원도 청정 자연속에서 수영장, 미니수영장, 족구장, 캠프파이어는 물론 음향시설, 빔프로잭트가 갖춰진 세미나실이 있어 회의나 레크리에이션이 가능하다.\n");
                break;
            case R.id.gwt11:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/73/2820173_image2_1.JPG").into(binding.gwtImage);
                binding.gwtTitle.setText("마린데크(커피마린협동조합)");
                binding.gwtTel.setText("033-574-2555");
                binding.gwtAddress.setText("강원도 삼척시 새천년도로 326");
                binding.gwtoverview.setText("삼척의 푸른 바다와 기암괴석을 즐길 수 있는 새천년 해안도로를 따라 달리다 보면 해안 절벽 위 카페 커피마린협동조합을 만날 수 있다. 지역, 환경과 상생하는 커피 문화 공간으로 자리 잡고 있는 커피마린의 입구에는 지역 예술가들의 전시 작품과 인근 지역에서 생산하는 상품들이 관광객들을 맞이한다. 커피마린협동조합에서 제작한 ‘삼척 로컬 커피 시리즈’ 커피 드립백은 삼척의 5군데 명소와 5개 커피의 풍미를 연결한 기념품이다. 바로 현장에서 구매 가능하며 온라인으로도 판매하고 있다. 바다를 바라보면서 바리스타의 설명과 함께 직접 로스팅한 생두를 가지고 손수 커피를 내려 마실 수 있는 핸드 드립 커피 체험은 예약제로 운영되고 있으니, 방문 전 전화 문의가 요망된다.\n");
                break;
            case R.id.gwt15:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/97/2731297_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("나전역카페");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 정선군 북평면 북평8길 38");
                binding.gwtoverview.setText("나전역은 오랜 시간 잊힌 기차역이었다. 1969년에 문을 열어 석탄사업이 활황이던 시절에 가장 번성했다. 그러다 1993년에 이르러 간이역이 됐고 2011년에 여객 취급마저 멈춰 폐역 직전까지 갔다. 2015년 의자와 난로 등을 설치하며 옛 역의 모습을 복원했지만 크게 관심을 끌지 못했역다. 나전역의 부활을 이끈 건 카페다. 나전역은 우리나라 1호 간이역카페다. 역 건물을 카페로 개조하며 정선의 새로운 명소로 떠올랐다. 기차를 기다리던 대합실은 손님들이 커피를 마시며 쉴 수 있는 장소로 변신했다. 기차표를 사듯 커피를 주문해 마신다. 옛 간이역의 긴 의자도 그대로다. 시간표 자리에 붙어 있는 메뉴판도 흥미롭다. 나전역의 특별함은 기차역의 느낌을 살린 레트로 분위기에만 있지 않다. 정선의 로컬푸드 곤드레를 활용한 메뉴 역시 나전역 카페를 알린 비결이다. 대표 음료는 나전역크림커피로 쌉싸름한 곤드레 나물 향과 달콤한 크림 커피의 조화가 절묘하다. 곤드레아란치니도 나전역 카페에서만 맛볼 수 있는 디저트 메뉴다. 커피 한 잔을 마신 후에는 인근 계곡수공원을 같이 돌아봐도 좋겠다. 공원은 계곡수체험장이 ‘S’자로 가로지른다. 그 주변으로 분수와 정자, 파고라 등이 자리해 계곡수에 발을 담그며 잠시 쉬어갈 수 있다.\n");
                break;
            case R.id.gwt17:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/14/2649014_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("나릿골 감성마을");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 삼척시 나리골길 12");
                binding.gwtoverview.setText("나릿골은 삼척 정리항 영진안과 벽너머 사이 어항의 배를 정박하는나루가 있어서붙여친 명칭으로 거주민 30%가 어업에 종사하고 있으며 60~70년대생화 정취가남아있는 계단과 골목길, 담장 등을 간직하고 있는 전형적인 항구문화가 남아있는아름다운 경치의 어촌 산마을입니다.\n");
                break;
            case R.id.gwt19:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/47/2820747_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("대화면TV(너나드리)");
                binding.gwtTel.setText("http://tong.visitkorea.or.kr/cms/resource/47/2820747_image2_1.jpg");
                binding.gwtAddress.setText("강원도 평창군 대화면 대화중앙로 40");
                binding.gwtoverview.setText("대화면TV는 청년여성 사업가들이 모인 공동체이다.\n" +
                        "평창군 대화면 여행비타민(travel vitamin)을 관광객에게 선사하고자 체험프로그램을 제공한다. 1박2일 체험, 캠핑장, 펜션 등을 이용하는 관광객에게 단조로운 여행에서 벗어나 평창의 특색을 제공하고자 한다. 도자기 상품과 체험, 평창의 자연에서 줌바댄스를 추며 오감을 자극시키는 체험, 평창지역 구석구석을 돌아보며 마을해설을 들을 수 있는 체험이 준비되어 있다. 그 뿐만 아니라 지역주민, 마을 공동체, 지역작가들과 협업하여 더욱 다채로운 체험을 준비하여 지역과 상생하는 평창군 대화면의 여행비타민을 제공하고 있다.");
                break;
            case R.id.gwt23:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/46/2707046_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("DUO 가족농원");
                binding.gwtTel.setText("");
                binding.gwtAddress.setText("강원도 홍천군 남면 신대로232번길 30");
                binding.gwtoverview.setText("관광두레 주민사업체 컬러팜웨딩포레스트 협동조합 중 한 곳인 DUO 가족농원은 자연수정으로 바르게 키워낸 배 전문 과수원이다. 아름다운 배꽃과수원은 봄시즌만 되면 삼삼오오 카메라에 사진을 담기 위해 붐비는 인기포토스팟이다. 싱그러운 배를 직접 구확하고 배나무를 직접 분양할 수 있는 체험을 운영하고 있다.\n");
                break;
            case R.id.gwt24:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/98/2553198_image2_1.jpg").into(binding.gwtImage);
                binding.gwtTitle.setText("무코바란");
                binding.gwtTel.setText("033-532-2042");
                binding.gwtAddress.setText("강원도 동해시 일출로 10");
                binding.gwtoverview.setText("<무코바란>은 게스트하우스가 위치한 강원도 동해시 일출로의 옛 지명인 강원도 명주군 묵호읍 발한리에서 \"묵호\"와 \"발한\"을 소리나는 대로 적어 만든 상호로써 지역의 문화와 역사 등의 콘텐츠를 계승, 발전시키고자 하는 목표로 설립되었다. 창업자들의 고향이었던 동해의 옛 묵호항 이야기, 북적거리던 골목 이야기 등이 기억으로만 묻히는 게 아쉬워, 여행자들의 발걸음으로 묵호가 활기를 되찾고 여행자와 묵호주민이 활발히 교류하는 기회를 만들고자 하였다. <무코바란> 은 망상해변, 무릉계곡, 추암 촛대바위, 천곡 천연동굴 등 주변 관광자원이 풍부하며, 특별한 텐트형 숙소와 함께 매일 아침 묵호의 역사 이야기와 함께 논골담길에서 일출을 맞이하는 눈꼽트래킹이 시그니처 여행상품이다.\n");
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
                .replace(R.id.containers, gangwonTourFragment).commit();
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