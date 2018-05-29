package kh.edu.niptict.fragment2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.niptict.fragment2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

// Factory Method
    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setContentView(R.layout.activity_main);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        return view;
    }

}
