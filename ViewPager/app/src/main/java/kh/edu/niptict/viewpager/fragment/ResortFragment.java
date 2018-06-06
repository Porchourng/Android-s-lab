package kh.edu.niptict.viewpager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.niptict.viewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResortFragment extends Fragment {


    public ResortFragment() {
        // Required empty public constructor
    }

    public static ResortFragment newInstance() {
        return new ResortFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resort, container, false);
    }

}
