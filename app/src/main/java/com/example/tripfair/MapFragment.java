package com.example.tripfair;

import static android.content.Context.LOCATION_SERVICE;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.tripfair.databinding.FragmentGyeonggiTourBinding;
import com.example.tripfair.databinding.FragmentMapBinding;


import net.daum.android.map.MapViewEventListener;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

class TestData {
    String name;
    Double latitude;
    Double longitude;
    //setter, getter, toString 오버라이딩

    TestData (String name, Double latitude, Double longitude) {
        // 전역 변수에 인풋으로 들어온 변수값 매핑
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}

public class MapFragment extends Fragment {

    private static final String LOG_TAG = "MapFragment";
    private FragmentMapBinding binding;
    private MapView mapView;
    private ViewGroup mapViewContainer;
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        mapView = new MapView(getActivity());
        mapViewContainer = (ViewGroup) v.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
        //mapView.setMapViewEventListener((MapViewEventListener) getActivity());
        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
        if (!checkLocationServicesStatus()) {
            showDialogForLocationServiceSetting();
        }else {
            checkRunTimePermission();
        }


        //지도 마커
        ArrayList<MapPOIItem> markerArr = new ArrayList<MapPOIItem>();
        ArrayList<TestData> dataArr = new ArrayList<TestData>();

        //경인 관광
        dataArr.add(new TestData("누구나투어",37.9004222865,127.2064823011));
        dataArr.add(new TestData("힐데루시 자연치유 협동조합",37.9584924074,127.1580072674));
        dataArr.add(new TestData("남한산성 전통무예",37.4570436453,127.2263376898));
        dataArr.add(new TestData("도자누리",37.4165630791,127.2734345658));
        dataArr.add(new TestData("사르르목장",38.0729841938,127.2875587267));
        dataArr.add(new TestData("협동조합 문화와함께",37.1503174105,127.3454966897));
        dataArr.add(new TestData("4.16 희망목공소",37.3436914471,126.8349847878));
        dataArr.add(new TestData("평화오르골",37.8826266399,126.8722883917));
        dataArr.add(new TestData("시흥하이갯골",37.3898434734,126.7812689472));
        dataArr.add(new TestData("가치가",37.8497027373,127.4843167566));
        dataArr.add(new TestData("동동카누",37.4653484933,127.5454001670));
        dataArr.add(new TestData("구석구석여행사",38.0225444535,127.0708383863));
        //경인 맛집
        dataArr.add(new TestData("파머스키친",37.8454222915,127.1598714889));
        dataArr.add(new TestData("비둘기낭99",38.0739440696,127.2263781906));
        dataArr.add(new TestData("안성밀당",37.0066076474,127.2704075003));
        dataArr.add(new TestData("포천 로컬푸드마켓",37.8454389543,127.1597437225));

        //강원 관광
        dataArr.add(new TestData("삼척 감성공작소",37.4419901843,129.1633412260));
        dataArr.add(new TestData("와우미탄",37.2917399274,128.5410709995));
        dataArr.add(new TestData("행복한 숲",37.6926364031,127.7165335762));
        dataArr.add(new TestData("대관령마켓",37.6723547787,128.7093304907));
        dataArr.add(new TestData("평창사랑",37.4909569494,128.4535784664));
        dataArr.add(new TestData("오대산힐링빌리지",37.6100860694,128.5175413370));
        dataArr.add(new TestData("평창캠프닉",37.5788278091,128.3317534820));
        dataArr.add(new TestData("무네미농장",37.8043385470,128.2251007871));
        dataArr.add(new TestData("마린데크",37.4567778155,129.1860748475));
        dataArr.add(new TestData("나전역",37.4498769075,128.6683381599));
        dataArr.add(new TestData("나릿골 감성마을",37.4393742985,129.1878557797));
        dataArr.add(new TestData("대화면TV(너나드리)",37.4927790362,128.4575252782));
        dataArr.add(new TestData("DUO 가족농원",37.5738325171,127.8122783806));
        dataArr.add(new TestData("무코바란",37.5499655814,129.1096121568));
        //강원 맛집
        dataArr.add(new TestData("몽트비어",38.2044117557,128.5281193548));
        dataArr.add(new TestData("강릉 100년방앗간",37.7551821455,128.8955111710));
        dataArr.add(new TestData("방림별곡카페",37.4264993838,128.3946856968));
        dataArr.add(new TestData("예술",37.7945663951,128.1690533826));
        dataArr.add(new TestData("응골딸기Lab",38.1816398638,128.5516734796));
        dataArr.add(new TestData("유황오미자",37.7822288489,127.8693476072));
        dataArr.add(new TestData("용오름맥주마을",37.7209317630,128.2361772976));

        //충청 관광지지
        dataArr.add(new TestData("어슬티굿밤",36.4878261091,126.8226481079));
        dataArr.add(new TestData("별신(삼버들협동조합)",36.5277589412,127.3701506403));
        dataArr.add(new TestData("괴산 그곳에 가면 협동조합",36.8420954311,127.8505182559));
        dataArr.add(new TestData("산막이옛길 협동조합",36.7616822350,127.8391826569));
        dataArr.add(new TestData("마을여행사 청보리",36.4385461196,126.8493997933));
        dataArr.add(new TestData("공방 이플아토",36.4520382195,126.8035924412));
        dataArr.add(new TestData("리틀파머스",36.6726480588,127.2248152798));
        dataArr.add(new TestData("비녀랑 한복이랑",36.6297679841,127.2872775071));
        dataArr.add(new TestData("생생마을 여행사",37.0271284544,127.6302911405));
        dataArr.add(new TestData("아홉 살이 관광",36.2149062428,126.7558613238));
        dataArr.add(new TestData("정림스튜디오",36.2759464771,126.9164842011));
        dataArr.add(new TestData("부여 선샤인",36.2742322782,126.8873201945));
        dataArr.add(new TestData("만세장터영농조합법인",36.1899003585,126.8928691464));
        dataArr.add(new TestData("뒷개한옥촌민박협의회",36.2929057858,126.9245163652));
        dataArr.add(new TestData("쌍류포도정원협동조합",36.2929057858,126.9245163652));
        dataArr.add(new TestData("해미읍성",36.7136093089,126.5503805299));
        dataArr.add(new TestData("상점195",36.7866769792,126.4528679606));
        dataArr.add(new TestData("행복한여행나눔",36.5822735910,126.6626377803));
        //충청맛집
        dataArr.add(new TestData("가을농원",36.6816703458,127.7499317913));
        dataArr.add(new TestData("수북로1945",36.2722963914,126.8874757872));
        dataArr.add(new TestData("꽃동네제빵소",36.8905819037,127.5663340812));
        dataArr.add(new TestData("향온",36.4040055827,126.8462482174));
        dataArr.add(new TestData("꽃이 머무는 자리(찬고을)",36.4040055827,126.8462482174));
        dataArr.add(new TestData("휴식레스토랑",36.4511884853,126.8132471518));

        //경상관광지
        dataArr.add(new TestData("룰루낭만협동조합",35.2355884098,128.8813523187));
        dataArr.add(new TestData("더휴앤",35.8736192331,128.7271481984));
        dataArr.add(new TestData("폴링 인 진주",35.1669436949,128.1327307213));
        dataArr.add(new TestData("배건네공작소",35.1862572903,128.0821790879));
        dataArr.add(new TestData("주티스트",36.8428666846,128.5509833438));
        dataArr.add(new TestData("잇다오지",35.3897526829,128.4820052670));
        dataArr.add(new TestData("우포여행가방",35.5603155274,128.4124178570));
        dataArr.add(new TestData("관사골작업실 협동조합",36.8286362591,128.6187304939));
        dataArr.add(new TestData("소백산 꽃차이야기",36.8831761998,128.5640365571));
        dataArr.add(new TestData("서리단길 뮤지션 협동조합",35.3099157630,129.0094085584));
        dataArr.add(new TestData("하모예",35.2466692375,128.0427587304));
        dataArr.add(new TestData("밀알영농조합",35.0817097701,128.1857894328));
        dataArr.add(new TestData("이랑협동조합",34.8294450903,128.4258112245));
        dataArr.add(new TestData("비손농장(포항체험잇다)",36.1976103215,129.3174231251));
        dataArr.add(new TestData("힐링로드",36.1954835228,129.3559975722));
        dataArr.add(new TestData("명품옻골1616",35.9077618439,128.6868424580));
        dataArr.add(new TestData("모냥",35.8804007320,128.6695641893));
        dataArr.add(new TestData("소백명품서클",36.9999811702,128.6538612168));
        //경상맛집
        dataArr.add(new TestData("예원가",35.5403609890,128.4972498375));
        dataArr.add(new TestData("더하리스토리 항아리 전통장 체험",35.5317917166,128.4536205693));
        dataArr.add(new TestData("우포에 버들국수",35.5763003186,128.4390484145));
        dataArr.add(new TestData("영주소백팜",36.8491370953,128.6402307544));
        dataArr.add(new TestData("화전별곡꽃잠",34.8356128121,127.8956906572));
        dataArr.add(new TestData("왓쇼이",35.6866950180,127.9128612375));
        //전라관광
        dataArr.add(new TestData("순솝",34.9470990737,127.5050081509));
        dataArr.add(new TestData("두만꽃피오리(두만숲속학교)",34.9470990737,127.5050081509));
        dataArr.add(new TestData("문화가꽃피다",35.3237140265,126.8012912729));
        dataArr.add(new TestData("별이랑",34.8688074911,127.4831453899));
        dataArr.add(new TestData("사우스마켓(남쪽동네)",34.9454713961,127.5002197240));
        dataArr.add(new TestData("드로잉라이프",34.9512593457,127.4834627151));
        dataArr.add(new TestData("밀림슈퍼 연구소",34.9478460811,127.4974365750));
        dataArr.add(new TestData("두레아트",34.9503872565,127.4854847818));
        dataArr.add(new TestData("토요오픈스튜디오",35.2753667053,127.4498684844));
        dataArr.add(new TestData("금오도캠핑장",34.5349580009,127.7614072576));
        //전라맛집
        dataArr.add(new TestData("순천 브루어리",34.9570308878,127.4816238410));
        dataArr.add(new TestData("위인더랜드",35.3017383853,126.7805131111));
        dataArr.add(new TestData("별내리마을",35.4551665134,126.8433731091));
        dataArr.add(new TestData("토토마마",35.3897398403,126.7988120521));
        dataArr.add(new TestData("적정온도(순향가)",34.8728328128,127.5280635695));
        dataArr.add(new TestData("다올재 협동조합",34.9552699552,127.4804989851));

        for (TestData data : dataArr) {
            MapPOIItem marker = new MapPOIItem();
            marker.setMapPoint(MapPoint.mapPointWithGeoCoord(data.getLatitude(), data.getLongitude()));
            marker.setItemName(data.getName());
            markerArr.add(marker);
        }
        mapView.addPOIItems(markerArr.toArray(new MapPOIItem[markerArr.size()]));

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapViewContainer.removeAllViews();
    }

    public void onCurrentLocationUpdate(MapView mapView, MapPoint currentLocation, float accuracyInMeters) {
        MapPoint.GeoCoordinate mapPointGeo = currentLocation.getMapPointGeoCoord();
        Log.i(LOG_TAG, String.format("MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)", mapPointGeo.latitude, mapPointGeo.longitude, accuracyInMeters));
    }

    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {
    }


    public void onCurrentLocationUpdateFailed(MapView mapView) {
    }


    public void onCurrentLocationUpdateCancelled(MapView mapView) {
    }

    private void onFinishReverseGeoCoding(String result) {
//        Toast.makeText(LocationDemoActivity.this, "Reverse Geo-coding : " + result, Toast.LENGTH_SHORT).show();
    }

    // ActivityCompat.requestPermissions를 사용한 퍼미션 요청의 결과를 리턴받는 메소드
    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        if ( permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면
            boolean check_result = true;

            // 모든 퍼미션을 허용했는지 체크합니다.
            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }

            if ( check_result ) {
                Log.d("@@@", "start");
                //위치 값을 가져올 수 있음

            }
            else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있다
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), REQUIRED_PERMISSIONS[0])) {
                    Toast.makeText(getActivity(), "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                    getActivity().finish();
                }else {
                    Toast.makeText(getActivity(), "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    void checkRunTimePermission(){

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION);

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED ) {
            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)
            // 3.  위치 값을 가져올 수 있음

        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.
            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), REQUIRED_PERMISSIONS[0])) {
                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(getActivity(), "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(getActivity(), REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(getActivity(), REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }
        }
    }

    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하시겠습니까?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case GPS_ENABLE_REQUEST_CODE:
                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {
                        Log.d("@@@", "onActivityResult : GPS 활성화 되있음");
                        checkRunTimePermission();
                        return;
                    }
                }
                break;
        }
    }

    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    public void onMapViewInitialized(MapView mapView) {

    }

    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }
}
