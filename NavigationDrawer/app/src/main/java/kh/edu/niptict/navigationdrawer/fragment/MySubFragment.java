package kh.edu.niptict.navigationdrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.niptict.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MySubFragment extends Fragment {

    public static MySubFragment newInstance() {
        return new MySubFragment();
    }

    public MySubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_sub, container, false);
    }

}
