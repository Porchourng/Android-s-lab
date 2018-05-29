package kh.edu.niptict.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import kh.edu.niptict.fragment.fragment.FriendRequestsFragment;
import kh.edu.niptict.fragment.fragment.MyProfileFragment;
import kh.edu.niptict.fragment.fragment.NewFeedFragment;
import kh.edu.niptict.fragment.fragment.NotificationFragment;
import kh.edu.niptict.fragment.fragment.SettingFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        ImageButton newFeedBtn = findViewById(R.id.imageButton3);
        ImageButton friendReqBtn = findViewById(R.id.imageButton4);
        ImageButton myProBtn = findViewById(R.id.imageButton7);
        ImageButton notiBtn = findViewById(R.id.imageButton8);
        ImageButton settingBtn = findViewById(R.id.imageButton9);

        FriendRequestsFragment friendRequestsFragment = FriendRequestsFragment.newInstance();
        final MyProfileFragment myProfileFragment = MyProfileFragment.newInstance();
        final NewFeedFragment newFeedFragment = NewFeedFragment.newInstance();
        final NotificationFragment notificationFragment = NotificationFragment.newInstance();
        final SettingFragment settingFragment = SettingFragment.newInstance();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragmentcontainer, friendRequestsFragment).commit();

        newFeedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FriendRequestsFragment fr = (FriendRequestsFragment) fm.findFragmentByTag("FriendRequestsFragment");
                if (fr == null) {
                    final FriendRequestsFragment friendRequestsFragment = FriendRequestsFragment.newInstance();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentcontainer, friendRequestsFragment, "FriendRequestsFragment").commit();

                } else {
                    Toast.makeText(DynamicFragmentActivity.this, "Found", Toast.LENGTH_SHORT).show();
                }



            }
        });

        friendReqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragmentcontainer, myProfileFragment).commit();
            }
        });

        myProBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        notiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
