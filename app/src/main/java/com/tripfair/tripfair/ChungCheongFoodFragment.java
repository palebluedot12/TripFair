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
import com.tripfair.tripfair.databinding.FragmentChungCheongFoodBinding;
import com.tripfair.tripfair.databinding.FragmentGangwonTourBinding;


public class ChungCheongFoodFragment extends Fragment implements MainActivity.OnBackPressedListener {

    ChungCheongFoodFragment chungCheongFoodFragment;
    private FragmentChungCheongFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentChungCheongFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        binding.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        chungCheongFoodFragment = new ChungCheongFoodFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_chungcheong_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("충청 맛집/음식관광"); // 툴바 제목 설정

        binding.cfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.cf1.setOnClickListener(this::onClick);
        binding.cf3.setOnClickListener(this::onClick);
        binding.cf4.setOnClickListener(this::onClick);
        binding.cf5.setOnClickListener(this::onClick);
        binding.cf6.setOnClickListener(this::onClick);
        binding.cf7.setOnClickListener(this::onClick);

        //binding.gwtFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/01/2820401_image2_1.jpg").into(binding.cfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/20/2820620_image2_1.JPG").into(binding.cfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/84/2822184_image2_1.jpg").into(binding.cfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/55/2821855_image2_1.JPG").into(binding.cfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/47/2821547_image2_1.JPG").into(binding.cfImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/14/2821314_image2_1.JPG").into(binding.cfImg7);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.cfAll.setVisibility(View.GONE);
        binding.cfFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.cf1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/01/2820401_image2_1.jpg").into(binding.cfImage);
                binding.cfTitle.setText("농업회사법인 ㈜ 가을농원");
                binding.cfTel.setText("");
                binding.cfAddress.setText("충청북도 괴산군 청천면 금평로 97-40");
                binding.cfoverview.setText("청정 지역 괴산군의 화양계곡 가는 길목에 위치한 가을 농원은 25년 전 청천면으로 귀농한 농민 부부가 운영하는 농장이다. 이들은 사과 농사와 체험활동, 생산품 직거래를 통해 수익을 창출하고 있다. 하지만 단순 상품 판매에서 머무는 것이 아니라, 소비자와 활발히 소통하며 유대감을 형성하기 위해 블로그와 유튜브 같은 SNS 활동도 꾸준히 하고 있다. 그뿐만 아니라 농촌 융복합산업 (6차 산업) 스타트업 스쿨과정과 농식품 여성 CEO 과정 수료, 농업 마이스터 대학 졸업, 유기농 농업 기능사, 아동 요리 지도사, 푸드 스타일링 및 테라피 자격증 등을 취득하는 등 지속적인 발전을 도모한다. 귀농을 계획 중인 후배들에게 성공하는 농업인으로서 롤모델이 되고 있다.\n");
                break;
            case R.id.cf3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/20/2820620_image2_1.JPG").into(binding.cfImage);
                binding.cfTitle.setText("수북로1945");
                binding.cfTel.setText("010-8181-6746");
                binding.cfAddress.setText("충청남도 부여군 규암면 수북로41번길 11-50");
                binding.cfoverview.setText("㈜ 수북로힐은 자연을 사랑하고 가꾸는 사람들로 모인 주민사업체이다. 2021년 오픈한 적산가옥 <수북로1945> 카페는 정원속 피크닉 카페를 컨셉으로 만들어진 정원형 카페로 판매하는 모든청과 꽃차는 주민사업체가 직접 만들어 판매하고 있어 매우 건강하고 신선하여 관광객들의 큰 호응을 받고 있다. 특히 주문하면 예쁜 피크닉바구니에 메뉴들을 담아주어 작은 정원속 피크닉을 느낄 수 있으며, 직접 기른 허브를 활용한 브런치 메뉴인 수북샐러드와 샐러드 피자는 눈과 맛이 모두 즐거운 대표 메뉴이다. 카페 뒤편의 넓은 공간은 텃밭과 체험장으로 이루어져 있어, 단체 및 가족들의 체험 프로그램도 활발히 운영 중이다. 수제청 만들기, 화분 심기, 수제꽃식초 만들기 등 자연과 함께하는 다양한 체험프로그램과 함께 수제청과 직접 만든 감물마스크 및 허브소품등의 상품들도 함께 판매 중이다.\n");
                break;
            case R.id.cf4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/84/2822184_image2_1.jpg").into(binding.cfImage);
                binding.cfTitle.setText("꽃동네제빵소(꽃구움)");
                binding.cfTel.setText("");
                binding.cfAddress.setText("충청북도 음성군 원중로1119번길 42 꽃동네학교");
                binding.cfoverview.setText("'꽃동네제빵소'는 2001년 장애 학생의 교육을 위하여 개교한 꽃동네학교에서 장애 학생들의 직업 훈련과 자립을 위하여 세워진 꽃동네학교 학교기업(2012.개관: 제과제빵분야)과 연계한 지역주민사업체로 음성군 관광기념품 사업을 신청하여 2021년 음성군 관광두레 주민사업체로 선정되었다. '꽃동네제빵소'는 HACCP 시설을 갖추어 60여 종의 제과제빵 제품을 생산하며 꽃동네학교 교사, 재학생, 졸업생, 꽃동네학교 학교기업에 취업하여 근무 중인 근로자(꽃동네학교 졸업생)로 구성되었다. 구성원간의 활발한 협의를 거쳐 '꽃구움'이라는 브랜드명을 개발하였으며 꽃같이 아름다운 사람들에게 위로와 용기와 힘을 북돋아 주는 제품을 기획하였다. '꽃구움'의 대표 상품으로는 당일 로스팅한 신선한 원두로 제작한 드립커피(12g)와 꽃향기가 가득한 원두커피(250g), 무방부제, 무유화제, 무색소 건강한 재료로 만든 쿠키가 있다.\n");
                break;
            case R.id.cf5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/55/2821855_image2_1.JPG").into(binding.cfImage);
                binding.cfTitle.setText("향온");
                binding.cfTel.setText("");
                binding.cfAddress.setText("충청남도 청양군 장곡길 43-7");
                binding.cfoverview.setText("향온은 청양 대표 여행지 장곡사 입구에 위치한 양조장으로, 석탄 향이 특징인 지역 전통주를 빚고 나누는 일에 전념하고 있다. 관광객들은 체험장에서 전통주 빚는 법을 배우고 시음도 하며 일상에서 쉽게 접하기 힘든 전통주 문화를 경험할 수 있다. 향온은 발효의 미학 속에서 피어나는 향기로 술 빚는 사람과 술 즐기는 사람의 마음을 이어주며 전통주의 맛과 멋을 즐기는 힐링 여행을 선사한다.\n");
                break;
            case R.id.cf6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/47/2821547_image2_1.JPG").into(binding.cfImage);
                binding.cfTitle.setText("꽃이 머무는 자리(찬고을)");
                binding.cfTel.setText("");
                binding.cfAddress.setText("충청남도 청양군 사수터길 99-14");
                binding.cfoverview.setText("2021년 관광두레 주민사업체에 선정되어 카페 ‘꽃이 머무는 자리’를 개장하고 꽃차 판매와 꽃차 아카데미 교실을 운영하고 있다. 아름다운 꽃차 농원과 포토존, 꽃차와 어울리는 디저트, 쿠킹클래스를 체험하며 즐길 수 있으며, 매월 셋째 주 토요일 팜파티, 매년 6월에는 마리골드 축제를 개최한다.\n");
                break;
            case R.id.cf7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/14/2821314_image2_1.JPG").into(binding.cfImage);
                binding.cfTitle.setText("휴식레스토랑(백제에프앤비영농조합)");
                binding.cfTel.setText("");
                binding.cfAddress.setText("충청남도 청양군 청양읍 월촌길 56-2");
                binding.cfoverview.setText("“당신을 위한 맛있는 휴식” 백제에프앤비영농조합은 충남의 알프스 청정도시 청양에서 로컬푸드인 구기자, 맥문동, 청양고추, 표고버섯 등을 활용한 향토 퓨전형 바비큐 레스토랑 ‘휴식레스토랑’을 운영한다. 대한민국조리기능장과 함께하는 쿠킹클래스(요리, 제과제빵), 먹는 즐거움과 휴식이 있는 체험 교육을 하고 있으며, 지역의 랜드마크로 거듭나고 있다. 지역 먹거리 특색을 살린 6차산업과 농촌의 가치 창출을 위해 관광두레 사업과 연계하여 대한민국 조리 기능장과 함께하는 “휴식에서 휴식을” 푸드투어 상품을 개발 판매하며, 여행자와 함께하는 힐링 가족 중심형, 연인 중심형 식사와 체험을 통해 청양 속에서 힐링할 수 있도록 시설과 공간을 준비하여 최고의 음식과 서비스를 제공한다. 휴식레스토랑에서는 청양의 대표 농특산물인 구기자, 맥문동을 활용한 건강한 천연발효종 빵을 만들어 판매하며, 체험과 밀키트(식사 꾸러미)를 연계하여 전국 제일의 융복합레스토랑을 구축 운영한다. 또한, 음식재료(루꼴라, 채소, 허브)를 직접 재배하여 건강한 먹거리를 제공하고 있다. 대표메뉴로는 청양 스테이크맨, 소고기큐부채살브스테이크, 단호박파스타, 루꼴라피자, 버섯앙쿠르트 스프 등이 있다. * 체험 프로그램 : 대한민국조리기능장 바비큐체험, 구기자천연발효종 치아바타, 피자, 스콘 빵체험, 원데이쿠킹클래스, 제과제빵 체험\n");
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
                .replace(R.id.containers, chungCheongFoodFragment).commit();
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