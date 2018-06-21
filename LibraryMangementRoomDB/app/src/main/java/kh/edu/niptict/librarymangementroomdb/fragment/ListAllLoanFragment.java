package kh.edu.niptict.librarymangementroomdb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.niptict.librarymangementroomdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListAllLoanFragment extends Fragment {

    public static ListAllLoanFragment newInstance() {
        return new ListAllLoanFragment();
    }

    public ListAllLoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_all_loan, container, false);
    }

}
