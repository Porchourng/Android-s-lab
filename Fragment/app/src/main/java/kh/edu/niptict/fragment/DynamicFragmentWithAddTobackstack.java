package kh.edu.niptict.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import kh.edu.niptict.fragment.cons.Const;
import kh.edu.niptict.fragment.fragment.FriendRequestsFragment;
import kh.edu.niptict.fragment.fragment.MyProfileFragment;
import kh.edu.niptict.fragment.fragment.NewFeedFragment;
import kh.edu.niptict.fragment.fragment.NotificationFragment;
import kh.edu.niptict.fragment.fragment.SettingFragment;

public class DynamicFragmentWithAddTobackstack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        ImageButton newFeedBtn = findViewById(R.id.imageButton3);
        ImageButton friendReqBtn = findViewById(R.id.imageButton4);
        ImageButton myProBtn = findViewById(R.id.imageButton7);
        ImageButton notiBtn = findViewById(R.id.imageButton8);
        ImageButton settingBtn = findViewById(R.id.imageButton9);

        NewFeedFragment newFeedFragment = NewFeedFragment.newInstance();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragmentcontainer, newFeedFragment, Const.NewFeed_tag).commit();

        newFeedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewFeedFragment fr = (NewFeedFragment) fragmentManager.findFragmentByTag(Const.NewFeed_tag);
                if (fr == null) {
                    NewFeedFragment newFeedFragment = NewFeedFragment.newInstance();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragmentcontainer, newFeedFragment, Const.NewFeed_tag).addToBackStack(null).commit();
                } else {
                    Toast.makeText(DynamicFragmentWithAddTobackstack.this, "Found NewFeedFragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        friendReqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FriendRequestsFragment fr = (FriendRequestsFragment) fragmentManager.findFragmentByTag(Const.Fri_tag);
                if (fr == null) {
                    final FriendRequestsFragment friendRequestsFragment = FriendRequestsFragment.newInstance();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragmentcontainer, friendRequestsFragment, Const.Fri_tag).addToBackStack(null).commit();
                } else {
                    Toast.makeText(DynamicFragmentWithAddTobackstack.this, "Found FriendRequestsFragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        myProBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProfileFragment fr = (MyProfileFragment) fragmentManager.findFragmentByTag(Const.Prof_tag);
                if (fr == null) {
                    final MyProfileFragment myProfileFragment = MyProfileFragment.newInstance();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragmentcontainer, myProfileFragment, Const.Prof_tag).addToBackStack(null).commit();
                } else {
                    Toast.makeText(DynamicFragmentWithAddTobackstack.this, "Found MyProfileFragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        notiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationFragment fr = (NotificationFragment) fragmentManager.findFragmentByTag(Const.Noti_tag);
                if (fr == null) {
                    final NotificationFragment notificationFragment = NotificationFragment.newInstance();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragmentcontainer, notificationFragment, Const.Noti_tag).addToBackStack(null).commit();
                } else {
                    Toast.makeText(DynamicFragmentWithAddTobackstack.this, "Found NotificationFragment", Toast.LENGTH_SHORT).show();
                }
            }
        });

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingFragment fr = (SettingFragment) fragmentManager.findFragmentByTag(Const.Setting_tag);
                if (fr == null) {
                    final SettingFragment settingFragment = SettingFragment.newInstance();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragmentcontainer, settingFragment, Const.Setting_tag).addToBackStack(null).commit();
                } else {
                    Toast.makeText(DynamicFragmentWithAddTobackstack.this, "Found SettingFragment", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
