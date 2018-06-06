package kh.edu.niptict.viewpager.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import kh.edu.niptict.viewpager.fragment.FoodFragment;
import kh.edu.niptict.viewpager.fragment.GeneralFragment;
import kh.edu.niptict.viewpager.fragment.ResortFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return FoodFragment.newInstance();
            case 1: return GeneralFragment.newInstance();
            case 2: return ResortFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
