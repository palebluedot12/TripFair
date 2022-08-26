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
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.tripfair.databinding.FragmentGangwonFoodBinding;
import com.example.tripfair.databinding.FragmentGangwonTourBinding;


public class GangwonFoodFragment extends Fragment implements MainActivity.OnBackPressedListener {

    GangwonFoodFragment gangwonFoodFragment;
    private FragmentGangwonFoodBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        binding = FragmentGangwonFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        binding.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        gangwonFoodFragment = new GangwonFoodFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_gangwon_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("강원 맛집/음식관광"); // 툴바 제목 설정

        binding.gwfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.gwf1.setOnClickListener(this::onClick);
        binding.gwf2.setOnClickListener(this::onClick);
        binding.gwf3.setOnClickListener(this::onClick);
        binding.gwf4.setOnClickListener(this::onClick);
        binding.gwf5.setOnClickListener(this::onClick);
        binding.gwf6.setOnClickListener(this::onClick);
        binding.gwf7.setOnClickListener(this::onClick);

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2732813_image2_1.jpg").into(binding.gwfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/80/2773880_image2_1.jpg").into(binding.gwfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/73/2820873_image2_1.JPG").into(binding.gwfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2698695_image2_1.bmp").into(binding.gwfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/93/2698793_image2_1.bmp").into(binding.gwfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/42/2707042_image2_1.jpeg").into(binding.gwfImg6);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/06/2610806_image2_1.bmp").into(binding.gwfImg7);


        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.gwfAll.setVisibility(View.GONE);
        binding.gwfFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.gwf1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/13/2732813_image2_1.jpg").into(binding.gwfImage);
                binding.gwfTitle.setText("몽트비어");
                binding.gwfTel.setText("033-636-9010");
                binding.gwfAddress.setText("강원도 속초시 학사평길 7-1");
                binding.gwfoverview.setText("속초 몽트비어는 지역을 대표하는 수제맥주 브랜드이다. 속초 IC 입구에 신선한 맥주를 생산하는 수제맥주공장과 레스토랑이 위치해 있다. 몽트비어는 맥주 만들기 동호회 회원들이 모여 만든 독특한 이력을 갖고 있다. 홈브루잉을 통해 축적한 오랜 노하우를 바탕으로 지금의 몽트비어를 만들어냈다. 몽트비어는 효모가 살아 있는 신선한 맥주를 지향하는데 직접 재배한 국내산 홉을 이용한 페일에일과 IPA가 인기다. 이 밖에 딸기와 복숭아, 샤인머스캣 등 지역 농가들과 협업해 과일과 맥주를 콜라보레이션한 제품도 호응이 높다. 완벽한 양조 설비를 갖춘 맥주공장 2층은 울산바위가 보이는 전망 좋은 레스토랑이다. 날씨가 좋은 날엔 3층 루프탑을 이용하면 더욱 운치 있다. 몽트(MONT)는 프랑스어로 ‘산’을 뜻한다. 몽트비어를 처음 방문하다면 먼저 샘플러를 주문해 자신에게 맞는 맥주를 찾아보자. 맥주효모로 발효시킨 피자와 수제맥주로 숙성시킨 부드러운 육질의 통수제육포, 몰트와 효모를 넣어 만든 쫄깃하고 쌉쌀한 맥주 효모빵 등 다양한 메뉴들이 더욱 입맛을 돋운다.\n" +
                        "\n" +
                        "[주요시설&부대시설]\n" +
                        "양조장");
                break;
            case R.id.gwf2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/80/2773880_image2_1.jpg").into(binding.gwfImage);
                binding.gwfTitle.setText("100년임당방앗간");
                binding.gwfTel.setText("");
                binding.gwfAddress.setText("강원도 강릉시 경강로2095번길 7");
                binding.gwfoverview.setText("강릉 임당동에서 100여 년 동안 방앗간으로 운영되었던 공간을 재구성한 카페다. 입구에 세워진 절기 방아가 이 같은 공간의 정체성을 상징적으로 보여준다. 100년 임당방앗간은 옛 방앗간의 원형을 오롯이 보존하고 있는데, 카페에 들어서면 가장 먼저 거대한 목조 정맥기와 제분기가 맞아준다. 안쪽에는 고추 빻는 기계 '콩두방'과 기름 짜는 기계가 전시되어 있다. 이곳의 대표메뉴는 '방앗간 라떼'다. 주문 즉시 핸드메이드로 제작하는 부드러운 크림과 귀리가루, 에스프레소가 어우러져 고소한 풍미가 느껴진다. 또 다른 인기 메뉴인 '방앗간 미숫가루'는 강원 지역에서 생산된 곡물 7가지를 직접 방앗간에 맡겨 만든다.\n");
                break;
            case R.id.gwf3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/73/2820873_image2_1.JPG").into(binding.gwfImage);
                binding.gwfTitle.setText("방림별곡카페");
                binding.gwfTel.setText("010-7320-9120");
                binding.gwfAddress.setText("강원도 평창군 방림면 서동로 1339");
                binding.gwfoverview.setText("해피방방 방림별곡제빵소는 방림면사무소 옆 방림드림센터 안에 위치하고 있다. 메밀, 감자, 밤 등 지역의 농특산물을 활용한 커피, 제빵 메뉴와 더불어 직접 만들고 맛볼 수 있는 체험을 진행하고 있으며, 플리마켓과 음악회 등 다양한 문화 행사를 개최하고 있다.\n");
                break;
            case R.id.gwf4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/95/2698695_image2_1.bmp").into(binding.gwfImage);
                binding.gwfTitle.setText("예술");
                binding.gwfTel.setText("");
                binding.gwfAddress.setText("강원도 홍천군 내촌면 동창복골길 259-9");
                binding.gwfoverview.setText("예술은 관광두레 주민사업체인 '컬러팜포레스트웨딩 협동조합' 소속으로 우리 전통주를 몸소 체험할 수 있는 전통 주조 공방이다. ‘예로부터 내려온 술’이라는 뜻으로 품격있는 우리 전통주를 복원․발전시키기 위해 노력하고 있다. 예술은 10년된 한옥을 개조해 자연과 어우러져 있어 산책을 즐기기에도 좋고 결혼식도 올릴 수 있다.\n");
                break;
            case R.id.gwf5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/93/2698793_image2_1.bmp").into(binding.gwfImage);
                binding.gwfTitle.setText("응골딸기Lab(응골딸기마을영농조합법인)");
                binding.gwfTel.setText("");
                binding.gwfAddress.setText("강원도 속초시 응골길 44-46");
                binding.gwfoverview.setText("설악산의 맑은 공기와 동해의 청정함이 느껴지는 속초응골딸기나라는 매년 12월부터 다음해 6월까지 싱싱한 딸기를 맛 볼 수 있는 딸기체험 마을이다. 가족, 연인, 친구들과 함께 딸기따기체험, 쿠키만들기체험 등을 경험할 수 있다.\n");
                break;
            case R.id.gwf6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/42/2707042_image2_1.jpeg").into(binding.gwfImage);
                binding.gwfTitle.setText("유황오미자");
                binding.gwfTel.setText("");
                binding.gwfAddress.setText("강원도 홍천군 북방면 성동로 1003-10");
                binding.gwfoverview.setText("관광두레 주민사업체 컬러팜웨딩포레스트 협동조합 중 한 곳인 유황오미자는 청정 홍천에서 유황으로 키운 오미자농장이다. 오미자를 직접 수확도 하고 청까지 담글 수 있는 오미자 농장체험을 운영하고있다.\n");
                break;
            case R.id.gwf7:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/06/2610806_image2_1.bmp").into(binding.gwfImage);
                binding.gwfTitle.setText("용오름맥주마을");
                binding.gwfTel.setText("");
                binding.gwfAddress.setText("강원도 홍천군 서석면 검산길 263");
                binding.gwfoverview.setText("물맑고 공기좋은 강원도 홍천 서석면 산골의 계곡에서 수제맥주를 마시고 레게음악을 들으며, 상시 파티가 열리는 이색적인 마을에 평범했던 마을에 괴짜 청년이 귀농하며 맥주의 원료인 홉을 재배하기 시작했다. 미디어와 SNS를 통해 빠르게 알려지며 관광객이 증가하고 있다. 대한민국에서 생산된 유기농, 친환경 보리와 홉, 그리고 효모를 사용한 세상에서 가장 건강한 맥주를 만들고 싶다는 신선한 목표가 관광객의 마음을 흐뭇하게 만들어 놓는다. 한번 오기시작하면 두번 세번 오고 싶은 관광지. 단체관광객에게는 예약제로 수제맥주 만들기체험, 농촌체험 프로그램이 운영되며, 토종사탕수수를 재배하여 색다른 경험을 선사한다.\n");
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
                .replace(R.id.containers, gangwonFoodFragment).commit();
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