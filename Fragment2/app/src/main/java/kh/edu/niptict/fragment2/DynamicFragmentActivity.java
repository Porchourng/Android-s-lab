package kh.edu.niptict.fragment2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import kh.edu.niptict.fragment2.fragment.AccountFragment;
import kh.edu.niptict.fragment2.fragment.FavouriteFragment;
import kh.edu.niptict.fragment2.fragment.NewFeedFragment;
import kh.edu.niptict.fragment2.fragment.ProfileFragment;
import kh.edu.niptict.fragment2.fragment.SettingFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        final NewFeedFragment newFeedFragment = NewFeedFragment.newInstance();
        final AccountFragment acFg = AccountFragment.newInstance();
        final FavouriteFragment fvFg = FavouriteFragment.newInstance();
        final ProfileFragment prFg = ProfileFragment.newInstance();
        final SettingFragment settFg = SettingFragment.newInstance();

        final FragmentManager fm = getSupportFragmentManager();

//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(R.id.container, newFeedFragment);
//          ft.addToBackStack(null);
//        ft.commit();
        fm.beginTransaction().add(R.id.container, newFeedFragment).addToBackStack(null).commit();

        ImageButton accBtn = findViewById(R.id.accBtnId);
        accBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.container, acFg).commit();
                fm.beginTransaction().replace(R.id.container, acFg).addToBackStack(null).commit();
            }
        });

        ImageButton favBtn = findViewById(R.id.favBtnId);
        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.container, fvFg).commit();
                fm.beginTransaction().replace(R.id.container, fvFg).commit();
            }
        });

        ImageButton newFeedBtn = findViewById(R.id.newFeedBtnId);
        newFeedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // If newFeedFragment is not found it'll replace by NewFeedFragment
                if (fm.findFragmentByTag("newFeedFragment") == null) {
//                    FragmentTransaction ft = fm.beginTransaction();
//                    ft.replace(R.id.container, newFeedFragment, "newFeedFragment").commit();
                    fm.beginTransaction().replace(R.id.container, newFeedFragment, "newFeedFragment").commit();
                }

            }
        });

        ImageButton profileBtn = findViewById(R.id.proBtnId);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, prFg).commit();
            }
        });

        ImageButton settingBtn = findViewById(R.id.settingBtnId);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, settFg).commit();
            }
        });
    }
}
