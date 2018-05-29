package kh.edu.niptict.fragment2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kh.edu.niptict.fragment2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFeedFragment extends Fragment {

    public static NewFeedFragment newInstance(){
        return new NewFeedFragment();
    }

    public NewFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_feed, container, false);
        Button button = view.findViewById(R.id.button4);
        final TextView textView = view.findViewById(R.id.textView3);
        final EditText editText = view.findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
            }
        });
        return view;
    }

}
