package kh.edu.niptict.fragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kh.edu.niptict.fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFeedFragment extends Fragment {


    public NewFeedFragment() {
        // Required empty public constructor
    }

    public static NewFeedFragment newInstance() {
        return new NewFeedFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_feed, container, false);
        final TextView nameTv = view.findViewById(R.id.getNameTv);
        final EditText nameEd = view.findViewById(R.id.nameET);
        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTv.setText(nameEd.getText().toString());
            }
        });

        return view;
    }

}
