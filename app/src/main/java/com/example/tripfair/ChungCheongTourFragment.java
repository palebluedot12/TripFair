package com.example.tripfair;

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
import com.example.tripfair.databinding.FragmentChungCheongTourBinding;
import com.example.tripfair.databinding.FragmentGangwonTourBinding;

public class ChungCheongTourFragment extends Fragment implements MainActivity.OnBackPressedListener {

    ChungCheongTourFragment chungCheongTourFragment;
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

        binding.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        chungCheongTourFragment = new ChungCheongTourFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_chungcheong_tour);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("충청 관광지"); // 툴바 제목 설정

        binding.ctFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.ct1.setOnClickListener(this::onClick);
        binding.ct2.setOnClickListener(this::onClick);
        binding.ct3.setOnClickListener(this::onClick);
        binding.ct4.setOnClickListener(this::onClick);
        binding.ct5.setOnClickListener(this::onClick);
        binding.ct6.setOnClickListener(this::onClick);
        binding.ct7.setOnClickListener(this::onClick);
        binding.ct8.setOnClickListener(this::onClick);
        binding.ct10.setOnClickListener(this::onClick);
        binding.ct11.setOnClickListener(this::onClick);
        binding.ct12.setOnClickListener(this::onClick);
        binding.ct13.setOnClickListener(this::onClick);
        binding.ct14.setOnClickListener(this::onClick);
        binding.ct15.setOnClickListener(this::onClick);
        binding.ct21.setOnClickListener(this::onClick);
        binding.ct24.setOnClickListener(this::onClick);
        binding.ct26.setOnClickListener(this::onClick);
        binding.ct27.setOnClickListener(this::onClick);



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

//        Glide.with(getActivity()).load("").into(binding.ctImg19);
//        Glide.with(getActivity()).load("").into(binding.ctImg20);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/06/2739606_image2_1.jpg").into(binding.ctImg21);
        //Glide.with(getActivity()).load("").into(binding.ctImg22);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/81/2671481_image2_1.jpg").into(binding.ctImg24);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/11/2698811_image2_1.bmp").into(binding.ctImg26);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2554608_image2_1.JPG").into(binding.ctImg27);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.ctAll.setVisibility(View.GONE);
        binding.ctFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.ct1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/31/2821331_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("어슬티굿밤");
                binding.ctTel.setText("010-8736-1282");
                binding.ctAddress.setText("충청남도 청양군 운곡면 어슬티안길 71-15");
                binding.ctoverview.setText("충청남도 청양군 운곡면에 위치한 어슬티굿밤은 레저 체험상품과 숙박시설을 제공하는 관광두레 협동조합이다. 살아온 연륜만큼 넉넉한 마음을 가진 이 곳의 주인장들은 하나부터 열까지 정성을 다해 직접 가꾼 공간을 여행객들과 아낌없이 나눈다. 시골집과 같은 편안한 숙박시설뿐 아니라, 인접한 저수지에서 차박이나 캠핑을 즐기며 가족 낚시 체험도 가능하다. 다양한 활동을 자유롭게 즐길 수 있어 가족 단위 여행자가 취향껏 쉬기에 부족함 없다. 밤이 되면 아름다운 자연을 배경으로 청양의 로컬푸드와 항아리 훈제 통삼겹살로 차려진 팜파티가 열린다. 어슬티 굿밤에서의 하룻밤은 피곤한 도시 생활에서 벗어나 편안한 행복과 휴식을 느끼기에 충분하다.\n");
                break;
            case R.id.ct2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2820095_image2_1.JPG").into(binding.ctImage);
                binding.ctTitle.setText("별신(삼버들협동조합)");
                binding.ctTel.setText("");
                binding.ctAddress.setText("세종특별자치시 부강면 시장1길 6-2");
                binding.ctoverview.setText("삼버들협동조합은 큰 버드나무 세 그루가 있었다 하여 지어진 부강의 옛 지명 ‘삼버들’에서 따온 이름으로 전통문화향유 활성화 사업 및 교육 콘텐츠를 기획하는 마을기업이다. 2018년부터 14개의 지역 문화재를 활용한 도보여행 코스 ‘작은 여행자마을’을 운영하며 역사공간을 활용해 문화공연과 돌잔치, 전통혼례장소 대관을 하고 있다.\n");
                break;
            case R.id.ct3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/10/2820410_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("괴산 그곳에 가면 협동조합");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청북도 괴산군 괴산읍 능촌로 328");
                binding.ctoverview.setText("괴산 그곳에 가면 협동조합은 김득신의 '취묵당' 그리고 충무공 김시민 장군 묘역과 둘레길을 이용하여 산책을 하고 밤에는 달천강에서 다슬기(올갱이) 잡기 체험을 주로 한다. 또한, 옛날 선조들의 농사 짓던 삶을 체험하고자 연중 농사체험을 진행한다.\n");
                break;
            case R.id.ct4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/15/2820415_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("산막이옛길 협동조합");
                binding.ctTel.setText("010-5243-0133");
                binding.ctAddress.setText("충청북도 괴산군 칠성면 산막이옛길 80-10");
                binding.ctoverview.setText("산막이옛길협동조합은 괴산의 대표 관광지인 산막이옛길을 보존하고 홍보하기 위해 뜻을 모아 만들어졌다. 수려한 자연 경관 속에서 마음의 안식을 찾을 수 있도록 1박 2일 숙박 프로그램과 트레킹, 국궁체험을 할 수 있는 시설을 갖춰 아름다운 옛길에서 전통 체험과 건강 증진을 위한 프로그램을 운영하고 있다.\n");
                break;
            case R.id.ct5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/46/2821346_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("마을여행사 청보리");
                binding.ctTel.setText("010-7110-3870");
                binding.ctAddress.setText("충청남도 청양군 대치면 칠갑산로 704-18");
                binding.ctoverview.setText("마을여행사 청보리는 청양군에 위치하고 있으며 당일, 1박2일 등 다양한 레저 체험 프로그램을 운영한다. * 상품명 : 비단강 천리길 걸어보리 (회당 20만원) •주제 : 비단강(금강) 하구둑에서 뜸봉샘(발원지)까지 천리길 걷기 •개요 : 1회 : 매월 둘째주 토,일(1박2일) / 200,000원, 10회 : 40km 구간 X 10회 / 연회비 150만원 •내용 : 1회 : 금강의 흙길을 걷다 (청양, 부여), 2회 : 금강을 건너다 (금산, 무주), 3회 : 벼룻길 (무주, 진안), 4회 : 봄꽃만발한 누애머릿길(무주), 5회 : 방우리 계곡트래킹(금산), 6회 :잉태와 탄생의 길(뜸봉샘) (장수), 7회 : 갈대숲과 생태의 길(부여, 서천), 8회 : 금강의 얼음트래킹(진안) ※ 구간과 내용은 현지 사정에 따라 변경될 수 있습니다. * 상품명 : 청양을 걸어보리 (체험비와 식비 포함 회당 35,000원) •주제 : 청양에서 쉬어보리, 놀아보리, 살아보리 •개요 : 1일 코스, 매주 토요일, 매회 참가비 3.5만원(체험비,식비 포함), 최소인원 10명 •내용 : 순차적 진행, 희망코스 선택시 사전협의 1. 읍내길 2. 남산둘레길 3. 지천생태길 4. 성태산 금광길 걷기 5. 금강 달빛따라 걷기 6. 고택과 커피의 만남 7. 면암 발자취따라 걷기 8. 칠갑산과 콩요리 9. 테마별 저수지길 걷기(사랑저수지, 칠갑, 천장, 대박, 도림, 적누) 10. 100년 돌담길 걷기 11. 금강 왕의나루 길 걷기 12. 휴식과 치유 체험 코스 ※ 구간과 내용은 현지사정에 따라 변경될 수 있습니다.\n");
                break;
            case R.id.ct6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/34/2821334_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("공방 이플아토");
                binding.ctTel.setText("010-9455-7307");
                binding.ctAddress.setText("충청남도 청양군 청양읍 중앙로열길 3");
                binding.ctoverview.setText("㈜이플아토는 2021년 관광공사의 청양지역 관광두레 주민사업체로 선정이 되면서 다양한 배움과 파일럿을 통해 건강한 지역 농산물과 지역 캐릭터를 활용해 비누, 캔들, 디퓨저, 석고, 인센스,초콜렛, 굿즈 등을 청양의 젊은 엄마들과 청년들 그리고 학교 밖 청소년들과 함께 다양한 것들을 만들고 개발해 보면서 갖고 싶은 건강한 기념품들을 선보이고 있다.\n");
                break;
            case R.id.ct7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/91/2820091_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("리틀파머스");
                binding.ctTel.setText("");
                binding.ctAddress.setText("세종특별자치시 전동면 미곡리");
                binding.ctoverview.setText("리틀파머스는 세종 지역의 청년농부들이 함께 농촌관광체험을 개발하여 도시민에게 농촌의 즐거움을 알려주는 기업이다. 화훼, 양봉, 한과, 로컬 디저트, 딸기, 친환경 고추 등을 생산하는 젊은 농부들이 모여 색다른 농촌체험이 가능하다. 또한 농업 이전의 직업(디자인, 외국어, 유아교육, 캐이터링 등)을 특기로 하여 새로운 농촌의 패러다임을 제시한다. 수확체험으로 귀결되는 농촌체험을 한계를 뛰어넘어 휴식과 힐링을 할 수 있는 체험 프로그램을 통해 아이도 즐겁고, 부모님도 쉬어갈 수 있는 농촌의 공간을 디자인한다.\n");
                break;
            case R.id.ct8:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/00/2820100_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("비녀랑 한복이랑");
                binding.ctTel.setText("010-5203-4451");
                binding.ctAddress.setText("세종특별자치시 조치원읍 안터길 107");
                binding.ctoverview.setText("<비녀랑 한복이랑>사업은 세종특별자치시 조치원읍에 위치하고 있으며 40여년간 방송 영화, 드라마 ,각종 문화 행사에 참여한 가체, 장신구, 여인들의 생활용품과 각종 민속품 등으로 전시되어있다. 특히 국가 표준영정에 참여한 가체 (신사임당, 논개, 제주만덕) 와 복식을 구경 할 수 있으며 드라마와 영화에서 본 가체 써보기와 만들기도 해볼 수 있다. 전통 공예 만들기 체험으로는 (비녀 만들기 갖 만들기,상투 만들기, 가체 만들기, 금강초롱 만들기가 있으며 다양한전통복식을 즐길 수 있다. 특히 청소년들의 성인식 체험은 사전 예약이 필수이며 100명 이상 일 경우에는 단체 한복과 필요한 모든 절차는 주최 측에서 준비한다 또한 학교와 학원의 특성 상 주최에서 찾아서 진행해주는 학생들의 최고의 추억이 될 것이다.\n");
                break;
            case R.id.ct10:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/29/2820729_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("생생마을 여행사");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청북도 음성군 오신로342번길 27");
                binding.ctoverview.setText("생생마을여행사는 자연과 인간이 공존하는 마을을 꿈꾸는 충북 음성군 생극면 지역 주민들이 만든 생태탐방전문 여행사다. 주민이 직접 주도하여 우리 지역만의 고유한 자원을 발굴하고 마을별 생태환경과 이야기를 엮어 여행상품으로 소개하고 있다. 코로나19로 모든 활동이 중단 되었을 때 지역 주민들이 직접 촬영한 지역의 동식물 사진과 어르신들과의 인터뷰를 통해 수집한 마을 역사와 전설 등 생극면의 자연환경과 옛 삶의 흔적들을 '생생가이드북: 음성군 생극면 생태환경 이야기'으로 발간했다. 생태관광을 주제로 2021년 전국 주민자치박람회에서 최우수상을 수상했다. 현재, '생태마을탐방 1탄 안터마을 편'을 절찬 판매중이다. 이야기가 있는 마을 산책을 통해 동물농장에 들러 동물들과 더불어 살아가는 원장님을 만나고, 약초꾼이 만든 비밀 효소터널과 꽃사과효소에 대한 이야기도 듣고, 꿈뜨락 정원사를 만나 아름다운 정원탐방을 진행한다. 숲속을 거닐 며 자연 속 숨은 보물 찾기를 하고 300년 된 고택에서 한방족욕과 맛있는 가정식 자연밥상을 즐기는 여정이다. 이 외에도 <우리마을에만 있다 생태탐방 여행시리즈> 프로젝트를 통해, 자연과 더불어 살아가는 마을 사람들의 이야기와 체험, 휴식까지 겸비한 마을별 여행 상품을 선보일 예정이다. 생생마을 여행사는 마을을 찾는 이들이 시골마을의 정을 느끼고, 다시 오고 싶은, 체류하고 싶은, 지속가능한 마을여행을 앞으로도 계속 만들어 나갈 것이다.\n");
                break;
            case R.id.ct11:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/22/2820622_image2_1.JPG").into(binding.ctImage);
                binding.ctTitle.setText("아홉 살이 관광");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 부여군 동헌로 31 한국농촌공사");
                binding.ctoverview.setText("아홉 살이 관광은 부여홍산을 기반으로 체험과 여행프로그램을 운영하는 주민사업체이다. 부여홍산의 역사자원인 보부상을 소재로 조선시대 보부상을 경험해보는 보부상 복식체험과 보부상 시장체험, 홍산의 역사와 문화자원을 배경으로 한 홍산 보부상투어 등을 경험해볼 수 있다.\n");
                break;
            case R.id.ct12:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/27/2820627_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("정림스튜디오");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 부여군 금성로 8");
                binding.ctoverview.setText("정림스튜디오는 부여 지역을 방문하는 관광객을 대상으로 야외사진촬영 및 주민여행 서비스를 제공하고 있다. 천혜의 자연환경과 풍부한 역사 자원을 지닌 부여의 구석구석을 지역주민인 사진가와 함께 여행하며 부여에서의 아름다운 추억들을 예쁜 사진으로 제공한다. 또한 스튜디오는 고전적인 레트로 분위기로 꾸며서 고객들이 자유롭게 촬영을 즐길 수 있는 공간으로 활용하고 있다. 이외에도 프로필, 가족사진, 결혼사진, 행사 사진 등의 서비스를 예약제로 제공하고 있다.\n");
                break;
            case R.id.ct13:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2820613_image2_1.JPG").into(binding.ctImage);
                binding.ctTitle.setText("부여 선샤인");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 부여군 자온로 68");
                binding.ctoverview.setText("㈜ 부여 선샤인은 부여에서의 가장 행복한 순간을 선사하고자 만든 관광두레이다. 부여의 진정한 가치를 알리기 위한 가든과 공예체험 여행 관련 상품을 주로 개발하고 있다. 피크닉 렌탈 상품인 ‘One Green Day’와 정원의 보테니컬 작품을 패브릭으로 제작하여 만든 홈데코 제품 ‘오키의 정원’과 같은 상품을 개발하여 부여에서의 웰니스를 추구하고 있다. 가든을 중심으로 한 여행상품은 여행전문 가이드의 안내로 부여에서의 편안한 휴식과 치유의 시간을 보낼 수도 있다.\n");
                break;
            case R.id.ct14:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/09/2820609_image2_1.JPG").into(binding.ctImage);
                binding.ctTitle.setText("만세장터영농법인");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 부여군 성흥로97번길 4-5");
                binding.ctoverview.setText("만세장터영농조합법인은 부여 임천면 토박이 어머님 7분이 모인 주민사업체이다. 3년전부터 임천만세장터에서 로컬장터를 운영하며 지역의 농산물을 활용한 상품을 개발 중이다. 부여 농산물이 들어간 수제 영양바와 오란다등의 강정 세트가 대표 상품이며, 직접 농사지은 부여산 100%의 건강한 고추장 된장 등의 장류 등도 판매중이다. 겨울에만 볼 수 있는 동치미 키트는 만세장터의 겨울 히트상품이다. 현재 공간 리모델링을 통해 도시락 카페를 준비중이며, 어머님들의 손맛으로 만들어진 다양한 반찬과 장류 등도 차후 맛볼 수 있어 매우 기대가 되는 팀이다.\n");
                break;
            case R.id.ct15:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/04/2820604_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("뒷개한옥촌민박협의회");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 부여군 뒷개로27번길 10-1");
                binding.ctoverview.setText("뒷개한옥촌민박협의회는 부여읍에 위치한 한옥 단지에 위치해있다. 10여개의 한옥이 단지를 이루고 있으며, 현 사업체는 나성한옥, 월함지, 의자왕한옥, 서동선화한옥 4곳의 한옥이 참여중이다. 한옥 카페가 있는 나성한옥, 단체 숙박하기 좋은 의자왕한옥, 연인들이 사랑을 키우는 서동선화한옥, 가족 숙박객들이 편히 쉬어가는 월함지 등 한옥마다 색다른 특징으로 숙박 프로그램을 운영중이다. 특히 평일 단체와 기관 등이 부여 방문 시 한옥 단제 전체가 숙박이 연계되 있어 100여명도 동시 숙박이 가능하다.\n");
                break;
            case R.id.ct21:
                Glide.with(getActivity()).load("").into(binding.ctImage);
                binding.ctTitle.setText("쌍류포도정원 협동조합");
                binding.ctTel.setText("010-8374-0191");
                binding.ctAddress.setText("세종특별자치시 연서면 쌍류송암길 76-36");
                binding.ctoverview.setText("쌍류포도정원 협동조합은 세종특별자치시의 마을기업으로 연서면 쌍류리의 '포도나무정원 농촌체험장'과 과수농가들이 주축이 되어 조합을 결성하였다. 출자한 조합원은 다섯 농가 11명이지만 조합원이 아닌 일반 농가도 체험활동 지원에 참여하고 있다. 포도를 중심으로 이 지역에서 재배되는 다양한 농작물을 활용하여 계절별 프로그램을 진행한다. 관광객들은 가정에서 쉽게 하기 힘든 다양한 농촌 체험을 할 수 있고 가족 단위의 팜 파티나 발표회, 연주회 같은 각종 행사를 즐길 수 있다. 마을 주민들은 단순한 농산물 판매에서 벗어나 일자리 창출 및 새로운 부가가치 수익을 올리고 있다. * 상품명 : 머루포도 따기 체험(9~10월) (15,000원) 머루포도의 특징과 효능에 대해 알아보고 잘 익은 포도를 직접 수확해본다. * 상품명 : 나만의 포도뱅쇼(연중) (20,000원) 포도와인 또는 포도주스(포도즙)에 과일과 향신료 등을 넣어 끓인 감기예방에 좋은 음료를 만들어 본다. * 상품명 : 바비큐 체험 (25,000원) 가족 및 단체 모임시 즐거운 가든 파티~! 바비큐 체험을 할 수 있다.\n");
                break;
            case R.id.ct24:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/81/2671481_image2_1.jpg").into(binding.ctImage);
                binding.ctTitle.setText("해미읍성");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 서산시 해미면 남문2로 143");
                binding.ctoverview.setText("조선 시대의 대표적인 읍성이다. 읍성이란 읍을 둘러싸고 세운 평지성으로 해미읍성 외에 고창읍성, 낙안읍성 등이 유명하다. 해미읍성은 조선 성종 22년, 1491년에 완성한 석성이다. 둘레는 약 1.8km, 높이 5m, 총면적 196,381m²(6만여 평)의 거대한 성으로 동,남,서의 세 문루가 있다. 최근 복원 및 정화사업을 벌여 옛 모습을 되찾아 사적공원으로 조성되었으며, 조선말 천주교도들의 순교 성지로도 유명하다. 천주교 박해 당시 관아가 있던 해미읍성으로 충청도 각 지역에서 수많은 신자가 잡혀와 고문받고 죽음을 당했으며, 특히 1866년 박해때에는 1천여 명이 이 곳에서 처형됐다고 한다.\n" +
                        "\n" +
                        "성내 광장에는 대원군 집정 당시 체포된 천주교도들이 갇혀 있던 감옥터와 나뭇가지에 매달려 모진 고문을 당했던 노거수 회화나무가 서 있다. 바로 성문밖 도로변에는 회화나무에 매달려 고문을 받으면서도 굴하지 않은 신도들을 돌 위에 태질해 살해했던 자리개돌이 있어 천주교도들의 순례지가 되고 있다. 성벽 주위에는 탱자나무를 심어 적병을 막는데 이용하였다고 하나, 지금은 거의 찾아볼 수가 없다.\n" +
                        "\n" +
                        "* 호야나무(회화나무)\n" +
                        "감옥 입구에 서 있는 300년 된 나무로, 이 나무의 가지에 신자들이 머리채를 묶어 매달아 고문하였었고, 그 흔적으로 철사줄이 박혀있다.");
                break;
            case R.id.ct26:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/11/2698811_image2_1.bmp").into(binding.ctImage);
                binding.ctTitle.setText("상점195");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 서산시 대사동1로 55");
                binding.ctoverview.setText("상점195’는 관광두레 사업을 통해 지원받아 제작된 지역 관광지를 상징하는 기념품 마켓이다 마그넷, 휴대폰 케이스, 떡메모지등과 같은 지역기념품과 10개 분야의 지역작가들이 제작한 한지드림캐처, 별자리목걸이등의 공예기념품 40여종을 만날 수 있다. 기념품 이외에도 칠보공예체험, 민화채색체험, 여행용가죽카드지갑 원데이클래스도 진행하고 있다.\n");
                break;
            case R.id.ct27:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/08/2554608_image2_1.JPG").into(binding.ctImage);
                binding.ctTitle.setText("행복한여행나눔");
                binding.ctTel.setText("");
                binding.ctAddress.setText("충청남도 홍성군 홍성읍 대학길 25");
                binding.ctoverview.setText("\"행복한여행나눔은 2014년부터 쌓아올린 농촌 기반 여행을 바탕으로 지역을 필요로 하는 다양한 이들에게 고객 맞춤 여행을 소개하는 내비게이션 지역 여행사이다. 기농업의 메카 충남 홍성에 자리하고 있으며, 지역 대학 관광과를 전공한 친구들이 유기농업, 귀농이 궁금한 사람들에게 필요한 워크숍 및 선진지 견학 형태로 지역을 알리고 있다. 또한 최근 홍성에서 활동하는 다양한 청년들과 교류하며 귀촌을 희망하는 도시 청년들과 문화 생활과 접점이 적은 시골 청년들을 잇는 네트워크 파티 ''파트라슈''를 기획․운영하고 있다.\n" +
                        "\n" +
                        "대표투어 : 귀농귀촌캠프, 명사와 함께 하는 해설투어, 문화재 활용 체험 투어, 지역 먹거리와 함께 하는 삼시세끼");
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
                .replace(R.id.containers, chungCheongTourFragment).commit();
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