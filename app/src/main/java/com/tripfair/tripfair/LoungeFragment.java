package com.tripfair.tripfair;


import android.Manifest;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class LoungeFragment extends Fragment {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseFirestore firestore;

    public TextView toolbar_username;
    public ImageView toolbar_btn_back;
    public ImageView toolbar_title_image;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private View view;

    //리싸이클러뷰 사용을 위한 선언↓
    private RecyclerView detailviewfragment_recyclerview;
    private DetailAdapter adapter;
    private LinearLayoutManager layoutManager;
    ArrayList<ContentDTO> contentDTOs = new ArrayList<>();
    ArrayList<String> contentUidList = new ArrayList<>();
    String uid;

    private ImageView detailviewitem_favrite_imageview;

    private Uri imageUri;

    private NotificationManager manager;
    private NotificationCompat.Builder builder;

    private String CHANNEL_ID = "channel1";
    private String CHANEL_NAME = "Channel1";
    FloatingActionButton fab;



    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lounge, container, false);
        fab = (FloatingActionButton)v.findViewById(R.id.fab_btn);
        mFirebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
//        toolbar_username = v.findViewById(R.id.toolbar_username);
//        toolbar_btn_back = v.findViewById(R.id.toolbar_btn_back);
//        toolbar_title_image = v.findViewById(R.id.toolbar_title_image);

        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        detailviewfragment_recyclerview = v.findViewById(R.id.detailviewfragment_recyclerview);
        detailviewfragment_recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,true);
        layoutManager.setStackFromEnd(true);
        detailviewfragment_recyclerview.setLayoutManager(layoutManager);
        //adapter에 contentDTOs를 담아서
        //리싸이클러뷰에 적용 시킨다.
        adapter = new DetailAdapter(getActivity(),contentDTOs);
        detailviewfragment_recyclerview.setAdapter(adapter);
        detailviewitem_favrite_imageview = v.findViewById(R.id.detailviewitem_favrite_imageview);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), AddPhotoActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(getActivity(), "외부 저장소 사용을 위해 읽기/쓰기 필요", Toast.LENGTH_SHORT).show();
                }

                requestPermissions(new String[]
                        {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 2);

            }


        }
//        frag1 = new Frag1();
//        setFrag(0);


//        setToolbarDefault();
        registerPushToken();
//        registerFollow();
        return v;
    }
//    public void setFrag(int n){
//        fm = getParentFragmentManager();
//        ft = fm.beginTransaction();
//        switch (n){
//            case 0:
//                ft.replace(R.id.main_content,frag1);
//                ft.commit();
//                break;}
//    }
    //    getHashKey();





    /*
    //해시값 추출 하는 방법
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }*/

//    private void setToolbarDefault() {
//        toolbar_username.setVisibility(View.GONE);
//        toolbar_btn_back.setVisibility(View.GONE);
//        toolbar_title_image.setVisibility(View.VISIBLE);
//
//    }
//    public static void hello(){
//        toolbar_btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toolbar_username.setVisibility(View.GONE);
//                toolbar_btn_back.setVisibility(View.GONE);
//                toolbar_title_image.setVisibility(View.VISIBLE);
//
//            }
//        });
//    }
    public void registerPushToken(){
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e("TOKEN_NONE", "registerPushToken: "+task.getException());
                        return;
                    }
                    Map<String,String> push_token  = new HashMap<>();
                    String token = task.getResult();
                    push_token.put("pushToken",token);
                    Log.e("TOKEN", "registerPushToken: "+token);
                    FirebaseFirestore.getInstance().collection("pushTokens")
                            .document(mFirebaseAuth.getUid()).set(push_token);
                });
    }
/**
 @Override
 protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
 super.onActivityResult(requestCode, resultCode, data);

 if(requestCode == Frag5.PICK_PROFILE_FROM_ALBUM && resultCode == Activity.RESULT_OK){
 imageUri = data.getData();
 String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
 StorageReference storageRef = FirebaseStorage.getInstance().getReference()
 .child("userProfileImages").child(uid);
 UploadTask uploadTask = storageRef.putFile(imageUri);
 Map<String, Object > map  = new HashMap<>();
 map.put(storageRef.getDownloadUrl().toString(),imageUri);
 uploadTask.addOnFailureListener(new OnFailureListener() {
 @Override
 public void onFailure(@NonNull Exception e) {
 }
 }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
 @Override
 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

 storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
 @Override
 public void onSuccess(Uri uri) {
 String img_uri = uri.toString();
 ProfileImage profileimage = new ProfileImage();
 profileimage.setImageUri(img_uri);
 Toast.makeText(getApplication(),"성공",Toast.LENGTH_SHORT).show();
 firestore.collection("profileImage").document(uid)
 .set(profileimage).addOnSuccessListener(new OnSuccessListener<Void>() {
 @Override
 public void onSuccess(Void unused) {
 setResult(Activity.RESULT_OK);
 }
 }).addOnFailureListener(new OnFailureListener() {
 @Override
 public void onFailure(@NonNull Exception e) {
 Toast.makeText(CommunityActivity.this,"다시 시도해주세요",Toast.LENGTH_SHORT).show();

 }
 });

 }
 });
 }
 });
 }
 }
 **/
/**
 public void pushAlarm(){
 builder = null;
 manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
 //버전 오레오 이상일 경우
 if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
 manager.createNotificationChannel(
 new NotificationChannel(CHANNEL_ID, CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
 );
 builder = new NotificationCompat.Builder(this,CHANNEL_ID);
 //하위 버전일 경우
 }else{
 builder = new NotificationCompat.Builder(this);
 }
 //알림창 제목
 builder.setContentTitle("알림");
 //알림창 메시지
 builder.setContentText("알림 메시지");
 //알림창 아이콘
 builder.setSmallIcon(R.drawable.ic_baseline_favorite_24);
 Notification notification = builder.build();
 //알림창 실행
 manager.notify(1,notification);
 }

 **/


}