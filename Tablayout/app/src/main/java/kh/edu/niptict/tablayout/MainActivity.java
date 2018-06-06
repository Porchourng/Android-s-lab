package kh.edu.niptict.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import kh.edu.niptict.googleplay.R;
import kh.edu.niptict.tablayout.adapter.ViewPagerAdapter;
import kh.edu.niptict.tablayout.fragment.GameFragment;
import kh.edu.niptict.tablayout.fragment.HomeFragment;
import kh.edu.niptict.tablayout.fragment.MovieFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);

        ArrayList<Fragment> listFrag = new ArrayList<>();
        listFrag.add(HomeFragment.newInstance());
        listFrag.add(GameFragment.newInstance());
        listFrag.add(MovieFragment.newInstance());
        listFrag.add(HomeFragment.newInstance());
        listFrag.add(GameFragment.newInstance());
        listFrag.add(MovieFragment.newInstance());
        listFrag.add(HomeFragment.newInstance());
        listFrag.add(GameFragment.newInstance());
        listFrag.add(MovieFragment.newInstance());

        ArrayList<String> listNamePage = new ArrayList<>();
        listNamePage.add("Home");
        listNamePage.add("Game");
        listNamePage.add("Movie");
        listNamePage.add("Home");
        listNamePage.add("Game");
        listNamePage.add("Movie");
        listNamePage.add("Home");
        listNamePage.add("Game");
        listNamePage.add("Movie");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),listFrag, listNamePage);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
