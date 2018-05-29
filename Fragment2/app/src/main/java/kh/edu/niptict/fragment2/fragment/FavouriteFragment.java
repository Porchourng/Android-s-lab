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
public class FavouriteFragment extends Fragment {

    public static FavouriteFragment newInstance() {
        return new FavouriteFragment();
    }

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

}
