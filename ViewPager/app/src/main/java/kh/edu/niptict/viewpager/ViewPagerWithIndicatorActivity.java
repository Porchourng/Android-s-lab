package kh.edu.niptict.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import kh.edu.niptict.viewpager.adapter.ViewPagerAdapter;

public class ViewPagerWithIndicatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_indicator_activity);

        final ViewPager viewPager = findViewById(R.id.viewpager2);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        final RadioGroup radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
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

        final RadioButton radioButton = findViewById(R.id.radioButton);
        final RadioButton radioButton2 = findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = findViewById(R.id.radioButton3);
        radioButton.setChecked(true);

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
                        radioButton2.setChecked(true);
                        break;
                    case 2:
                        radioButton3.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        Button button = findViewById(R.id.button5);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Tst", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
