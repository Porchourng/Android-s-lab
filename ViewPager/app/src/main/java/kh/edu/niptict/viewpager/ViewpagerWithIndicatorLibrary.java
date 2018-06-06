package kh.edu.niptict.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuhart.bubblepagerindicator.BubblePageIndicator;

import kh.edu.niptict.viewpager.adapter.ViewPagerAdapter;

public class ViewpagerWithIndicatorLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_with_indicator_library);

        ViewPager pager = findViewById(R.id.viewpager3);
        BubblePageIndicator indicator = findViewById(R.id.indicator);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

    }
}
