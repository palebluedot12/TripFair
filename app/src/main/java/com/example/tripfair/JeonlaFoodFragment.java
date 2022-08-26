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
import com.example.tripfair.databinding.FragmentJeonlaFoodBinding;
import com.example.tripfair.databinding.FragmentJeonlaTourBinding;

public class JeonlaFoodFragment extends Fragment implements MainActivity.OnBackPressedListener {

    JeonlaFoodFragment jeonlaFoodFragment;
    private FragmentJeonlaFoodBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentJeonlaFoodBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        jeonlaFoodFragment = new JeonlaFoodFragment();

        Toolbar toolbar = v.findViewById(R.id.toolbar_jeonla_food);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("전라 맛집/음식 관광"); // 툴바 제목 설정

        binding.jfFrame.setVisibility(View.GONE); //FrameLayout 일단 처음엔 안보이게. (클릭해야 나오게)

        binding.jf1.setOnClickListener(this::onClick);
        binding.jf2.setOnClickListener(this::onClick);
        binding.jf3.setOnClickListener(this::onClick);
        binding.jf4.setOnClickListener(this::onClick);
        binding.jf5.setOnClickListener(this::onClick);
        binding.jf6.setOnClickListener(this::onClick);

        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/93/2819893_image2_1.jpg").into(binding.jfImg1);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/91/2820791_image2_1.jpg").into(binding.jfImg2);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/85/2820785_image2_1.jpg").into(binding.jfImg3);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/67/2820967_image2_1.jpg").into(binding.jfImg4);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2819639_image2_1.jpg").into(binding.jfImg5);
        Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/80/2819880_image2_1.jpg").into(binding.jfImg6);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        binding.jfAll.setVisibility(View.GONE);
        binding.jfFrame.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.jf1:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/93/2819893_image2_1.jpg").into(binding.jfImage);
                binding.jfTitle.setText("순천 브루어리");
                binding.jfTel.setText("");
                binding.jfAddress.setText("전라남도 순천시 영동길 48");
                binding.jfoverview.setText("순천브루어리는 대한민국 생태 수도 순천의 청정 자연환경과 다양한 유/무형 자원을 활용해 개성있는 수제 맥주를 만드는 수제 맥주 스타트업 유한책임회사인 ''농업회사법인 순천 맥주''의 매장이다. 매장에서는 순천의 재료로 만든 수제 버거 ‘크레인버거’를 수제 맥주와 함께 즐길 수 있으며 전용잔과 티셔츠, 병따개 등 다양한 굿즈를 구입할 수 있다. 예약을 통해 수제 맥주 체험&교육 프로그램 진행이 가능하며, 2022년 5월 기준 순천 3곳의 지점과 4곳의 협력 매장에서 순천 맥주를 즐길 수 있다.\n");
                break;
            case R.id.jf2:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/91/2820791_image2_1.jpg").into(binding.jfImage);
                binding.jfTitle.setText("위인더랜드");
                binding.jfTel.setText("");
                binding.jfAddress.setText("전라남도 장성군 역전로 105");
                binding.jfoverview.setText("위인더랜드는 장성 지역 생산자들의 숨겨진 가치를 발굴하여 외부관광객은 물론 지역주민에게 소개하며 자체적으로는 지속적인 메뉴개발 및 상품개발을 통해 관광 앵커지를 지향한다. 첫 시도로 수제햄을 기반으로 하는 샌드위치 개발을 진행 중이며, 지역 식재료를 적극 활용할 예정이다. 방문객들은 위인더랜드의 공간 방문으로 트랜디하면서도 전통을 담은 아이템들을 접하게 되고 장성 관광의 로드맵을 그릴 수 있는 정보를 얻게 된다. 주기적으로 열리게 되는 수제햄 체험공방은 어린이들 체험 프로그램의 한 소스가 될 전망이다.\n");
                break;
            case R.id.jf3:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/85/2820785_image2_1.jpg").into(binding.jfImage);
                binding.jfTitle.setText("별내리마을");
                binding.jfTel.setText("");
                binding.jfAddress.setText("전라남도 장성군 남창로 351");
                binding.jfoverview.setText("주식회사 별내리마을은 주민 공동체에서 출발하여 10여년의 체험 휴양마을 운영의 노하우를 바탕으로 지역 청년 중심의 경영체제로 전환하면서 결성되었다. 기존 천문체험, 도예체험, 숲체험 등 다양한 경험이 있으며 주식회사 설립을 통해 농촌에서 만드는 나만의 수제맥주 컨셉으로 양조전문가를 양성하고 새롭게 체험장을 조성하게 되었다. 아울러 기존 숙박의 퀄리티를 높이고 양질의 서비스를 제공하고자 어메니티 고급화, 친절 교육 등을 수료하고 전문 경영컨설팅을 높여 자립하는 청년기업으로 성장하고 있다. 1. 농촌수제맥주 체험 : 농촌체험마을에서 직접 제조하는 수제맥주로 8종의 수제맥주를 비롯해 개인취향 맥주 레시피 개발, 제조, 시음하는 체험 프로그램 2. 산촌숙박 체험 : 내장산 국립공원에 있어 청정한 숲속에 있는 산촌마을이며 장성 8경 가운데 하나인 남창계곡에 위치해 치유와 놀이가 가능한 숙박 시설로 6인실, 4인실, 2인실로 구성되어 있음\n");
                break;
            case R.id.jf4:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/67/2820967_image2_1.jpg").into(binding.jfImage);
                binding.jfTitle.setText("토토마마");
                binding.jfTel.setText("");
                binding.jfAddress.setText("전라남도 장성군 북일면 오산리");
                binding.jfoverview.setText("전라남도 장성군 북일면에 위치한 토토마마는 여성농업인이자 청년 농업인으로 장성에 귀농하여 대추 방울토마토 농장을 운영하고 있다. 사람들이 평소에도 맛 좋은 토마토를 즐겨 찾고 건강하고 행복한 삶을 살 수 있기를 바라는 마음에 토마토를 활용한 다양한 체험활동도 진행한다. 토토마마를 찾는 아이들에게는 재미와 즐거움, 추억을 선사하고 함께하는 부모들에게는 쉼이 있는 공간이 되도록 노력하고 있다.\n");
                break;
            case R.id.jf5:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/39/2819639_image2_1.jpg").into(binding.jfImage);
                binding.jfTitle.setText("적정온도(순향가)");
                binding.jfTel.setText("");
                binding.jfAddress.setText("전라남도 순천시 해룡로 579 참좋은시골집");
                binding.jfoverview.setText("건강한 식재료를 사용해 몸과 마음을 치유하는 ‘발효 치유식’을 테마로 자연이 선사하는 영양과 편안함을 체험할 수 있는 치유 테마파크 '적정온도'를 조성했다. 현재 치유식 원데이/구독형 클래스를 준비하고 있으며, 집에서도 쉽게 순천의 맛을 담은 치유식을 맛볼 수 있도록 밀키트와 도시락상품을 기획하고 있다. '순향가'는 순천의 치유식을 여행객들이 다양하게 접할 수 있는 콘텐츠를 끊임없이 모색하는 중이며, 방문하는 고객들이 그들만의 적정온도를 찾을 수 있는 기회를 제공하고자 한다.\n");
                break;
            case R.id.jf6:
                Glide.with(getActivity()).load("http://tong.visitkorea.or.kr/cms/resource/80/2819880_image2_1.jpg").into(binding.jfImage);
                binding.jfTitle.setText("다올재 협동조합");
                binding.jfTel.setText("");
                binding.jfAddress.setText("전라남도 순천시 금곡길 60");
                binding.jfoverview.setText("“이 세상 좋은 일이 다 들어온다”라는 뜻의 다올재는 한국관광공사 인증 관광두레로 순천 문화의 거리에 위치한 카페 겸 펜션이다. 아파트로 가득한 도심에서는 쉽게 만나기 힘든, 옛 할머니 집처럼 정다운 느낌의 한옥이다. 다올재 카페에서는 전통차를 즐기며 편안한 여유를 만끽할 수 있다. 손님들은 말차, 녹차, 쌍화차 등 다양한 전통차를 체험한다. 특히 다올재에서 직접 순천의 홍매실을 주재료로 하여 만든 쌍화매실차는 남녀노소 모두에게 인기 있는 메뉴다. 예약하면 숙박도 가능하다. 넓은 마당이 내다보이고 아기자기한 전통 소품으로 가득한 방에서 하루를 보내며 묵은 피로가 풀리는 차 훈증 체험도 할 수 있어 명실공히 치유여행소라 할만하다. 도보 4분 거리에 조선시대 문화유적지인 순천향교가 있다.\n");
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
                .replace(R.id.containers, jeonlaFoodFragment).commit();
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