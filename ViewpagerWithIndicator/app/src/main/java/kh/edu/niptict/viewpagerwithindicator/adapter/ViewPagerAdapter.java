package kh.edu.niptict.viewpagerwithindicator.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> listPage;
    private ArrayList<String> namePage;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment>listPage, ArrayList<String> namePage) {
        super(fm);
        this.listPage = listPage;
        this.namePage = namePage;
    }

    @Override
    public Fragment getItem(int position) {

        return listPage.get(position);
    }

    @Override
    public int getCount() {
        return listPage.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return namePage.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        Log.d("DestroyItem", ""+position);
    }
}
