package kh.edu.niptict.viewpagerwithindicator;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import kh.edu.niptict.viewpagerwithindicator.adapter.ViewPagerAdapter;
import kh.edu.niptict.viewpagerwithindicator.fragment.GameFragment;
import kh.edu.niptict.viewpagerwithindicator.fragment.HomeFragment;
import kh.edu.niptict.viewpagerwithindicator.fragment.MovieFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.viewpager);
        ArrayList<Fragment> listFrag = new ArrayList<>();
        listFrag.add(HomeFragment.newInstance());
        listFrag.add(GameFragment.newInstance());
        listFrag.add(MovieFragment.newInstance());

        ArrayList<String> listNamePage = new ArrayList<>();
        listNamePage.add("Home");
        listNamePage.add("Game");
        listNamePage.add("Movie");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),listFrag, listNamePage);

        viewPager.setAdapter(adapter);

        RadioGroup radioGroup = findViewById(R.id.radiogroup);

        final RadioButton radioButton = findViewById(R.id.radioButton);
        final RadioButton radioButton1 = findViewById(R.id.radioButton2);
        final RadioButton radioButton2 = findViewById(R.id.radioButton3);

        radioButton.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radioButton2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radioButton3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioButton.setChecked(true);
                        break;
                    case 1:
                        radioButton1.setChecked(true);
                        break;
                    case 2:
                        radioButton2.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
