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
import com.example.tripfair.databinding.FragmentGyeonggiFoodBinding;
import com.example.tripfair.databinding.FragmentGyeonggiTourBinding;
import com.example.tripfair.databinding.FragmentGyeongsangFoodBinding;


public class GyeongsangFoodFragment extends Fragment implements MainActivity.OnBackPressedListener{

    GyeongsangFoodFragment gyeongsangFoodFragment;
    private FragmentGyeongsangFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGyeongsangFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        gyeongsangFoodFragment = new GyeongsangFoodFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gyeongsang_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("경상 맛집/음식관광"); // 툴바 제목 설정

        binding.gsfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.gsf1.setOnClickListener(this::onClick);
        binding.gsf2.setOnClickListener(this::onClick);
        binding.gsf3.setOnClickListener(this::onClick);
        binding.gsf4.setOnClickListener(this::onClick);
        binding.gsf5.setOnClickListener(this::onClick);
        binding.gsf6.setOnClickListener(this::onClick);


        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/43/2820343_image2_1.jpg").into(binding.gsfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/38/2820338_image2_1.jpg").into(binding.gsfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/35/2820335_image2_1.jpg").into(binding.gsfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/05/2820505_image2_1.jpg").into(binding.gsfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/36/2610936_image2_1.bmp").into(binding.gsfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/78/2552778_image2_1.JPG").into(binding.gsfImg6);
        

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.gsfAll.setVisibility(View.GONE);
        binding.gsfFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.gsf1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/43/2820343_image2_1.jpg").into(binding.gsfImage);
                binding.gsfTitle.setText("예원가");
                binding.gsfTel.setText("");
                binding.gsfAddress.setText("경상남도 창녕군 창녕시장길 66");
                binding.gsfoverview.setText("예원가는 전통 한과, 정과, 잼을 생산하는 업체이다. 양파 시배지인 창녕에서 생산되는 적양파에 정향, 허브 등을 넣은 적양파정향잼은 특유의 양파향 중 향긋함만 남기고 허브향이 강한 고급 수제 잼이다. 예원가에서 생산되는 상품은 모두 개별 수작업으로 이루어지기 때문에 따로 주문이나 위치한 창녕 전통시장 내 매장에서만 맛볼 수 있다. 우리나라에서 거대 전통장에 속하는 창녕 전통5일장은 창녕고분, 창녕 박물관이 1km 이내에 있어 가야시대 유물과 석빙고, 국보탑 등이 산재한 창녕 읍내를 도보로 둘러볼 수 있는 위치에 자리하고 있다.\n");
                break;
            case R.id.gsf2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/38/2820338_image2_1.jpg").into(binding.gsfImage);
                binding.gsfTitle.setText("더하리스토리 항아리 전통장 체험");
                binding.gsfTel.setText("");
                binding.gsfAddress.setText("경상남도 창녕군 학동길 18");
                binding.gsfoverview.setText("발효 식품을 기반으로 수제 과일청과 체험 상품을 판매하는 더 하리스토리 주식회사는 창녕읍에 본사를 두고 우포늪 근처 캠핑이 가능한 도자기 체험장 ‘그륵꿈는집’과 함께 운영되고 있다. 전통 가마와 수영장이 있는 도자기 체험장은 아이들과 함께, 친구끼리 가족끼리 많이 찾는 창녕의 숨겨진 명소로 실내 암장과 도자기 만들기 체험이 가능하다. ‘더하리스토리항아리 전통장 체험’은 530g, 300g 두 종류의 옹기항아리에 창녕의 특산물인 마늘고추장과 된장을 직접 담구어 가져갈 수 있는 체험이다. 기다림 끝에 얻을 수 있는 깊은 장맛을 직접 경험하기 좋아하는 아이들과 부모님들의 큰 호응을 얻고 있다.\n");
                break;
            case R.id.gsf3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/35/2820335_image2_1.jpg").into(binding.gsfImage);
                binding.gsfTitle.setText("우포에 버들국수");
                binding.gsfTel.setText("");
                binding.gsfAddress.setText("경상남도 창녕군 쟁반2길 13");
                binding.gsfoverview.setText("농업회사법인 주식회사 유화는 한자이름 유화(柳化:버드나무의 꽃)에서 알수 있듯이 버드나무와 관련된 주민사업체이다. 버드나무로 만드는 체험 ‘우포에 약차체험’과 아스피린의 원료인 소염진통제인 버들나무 껍질이 함유된 국수인 ‘우포에 버들국수’는 창녕 지역인들에게 치유 음식으로 많이 알려졌다. 진짜 버드나무 껍질을 첨가한 평범하지 않은 버들 국수는 창녕 심심산골 깨끗한 곳에서 야생으로 자란 버드나무를 재료로 사용하기 때문에 깐깐한 공정과 긴 시간이 필요한 음식이다.\n");
                break;
            case R.id.gsf4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/05/2820505_image2_1.jpg").into(binding.gsfImage);
                binding.gsfTitle.setText("영주소백팜");
                binding.gsfTel.setText("010-3522-1001");
                binding.gsfAddress.setText("경상북도 영주시 의상로116번길 43");
                binding.gsfoverview.setText("영주소백팜의 설립 목적은 건강한 땅에서 생산되는 먹거리로 건강한 사람과 생활의 구현, 자연재배와 친환경적인 농업의 실천과 현실적응, 그리고 6차산업화로 인한 수익형 사업 실현이다. 또한, 지역 내 경쟁력을 갖춘 명품 농장들이 힘을 모아 유일무이한 영주 농촌체험 관광상품을 개발하고 있다. 야생화농장, 목장, 사과농장의 운영으로 계절마다 아름다운 농장의 매력을 극대화 할 체험관광과 청정목장의 치즈, 요거트와 사과, 감자, 쌀 등 직접 재배·생산하고 있는 농특산물을 활용한 먹거리도 개발하고 있다. 이를 차별성 있게 보여주고자 팜마켓, 팜파티, 팜웨딩 등 농장에서만 즐길 수 있는 여유로움과 힐링의 시간을 제공한다.\n");
                break;
            case R.id.gsf5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/36/2610936_image2_1.bmp").into(binding.gsfImage);
                binding.gsfTitle.setText("화전별곡꽃잠");
                binding.gsfTel.setText("");
                binding.gsfAddress.setText("경상남도 남해군 남해읍 화전로38번길 8");
                binding.gsfoverview.setText("남해군관광두레 주민사업체인 화전별곡꽃잠에서는 꽃차전문가들이 직접 생산에서 가공까지 모든 공정을 수제로 제품을 생산하고 있다. 주민이 직접 정성을 다해 제작한 남해군보물섬의 수제꽃차의 맛과 멋을 즐길 수 있다. 화전별곡꽃잠에서는 버려지는 논과 밭을 주민소득창출의 장으로 탈바꿈시키기 위해 서로 노력하고 있으며 예쁜 꽃밭을 조성하여 관광객에는 즐길 수 있는 공간 조성, 주민들에게는 또 다른 수익창출의 공간으로서의 가치를 추구하기 위해 땀을 흘리고 있다. 꽃을 활용한 다양한 체험, 자격증반을 운영하고 있다. 오늘도 꽃을 키우고 사람을 키우는 \"화전별곡꽃잠\"은 지역의 활성화를 위해 나아가고자 한다.\n");
                break;
            case R.id.gsf6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/78/2552778_image2_1.JPG").into(binding.gsfImage);
                binding.gsfTitle.setText("왓쇼이");
                binding.gsfTel.setText("055-943-2582");
                binding.gsfAddress.setText("경상남도 거창군 거창읍 시장2길 37");
                binding.gsfoverview.setText("<왓쇼이>는 일본 출신 결혼이주 여성 6명이 다문화가정의 쉼터로 만든 '다정카페'가 발전해서 일본음식점이 된 일본가정식전문점이다. 다문화가정이 지역사회의 구성원으로 자립하고, 거창의 농특산물을 적극 활용해 한-일 문화교류를 위해 힘쓰겠다는 목표로 오픈한 <왓쇼이>는 이러한 가치실현을 위해 수익의 일부를 기부하고 있고 <왓쇼이>가 소재하고 있는 거창시장의 홍보일꾼으로도 활약하고 있다. <왓쇼이>는 한국의 재료로 일본 본토의 맛을 재현하기 위해 특별한 레시피로 개발한 돈가츠카레, 돈코츠라멘, 타코야키, 메밀국수 등 다양한 일본가정식 요리를 선보이고 있다.\n");
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
                .replace(R.id.containers, gyeongsangFoodFragment).commit();
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