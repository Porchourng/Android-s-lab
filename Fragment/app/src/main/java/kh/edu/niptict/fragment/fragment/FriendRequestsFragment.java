package kh.edu.niptict.fragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import kh.edu.niptict.fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendRequestsFragment extends Fragment {


    public FriendRequestsFragment() {
        // Required empty public constructor
    }

    public static FriendRequestsFragment newInstance() {
        return new FriendRequestsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_requests, container, false);
        final TextView textView = view.findViewById(R.id.fri_req_text_id);
        final Button btn = view.findViewById(R.id.friend_req_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Close");
            }
        });

        return view;
    }

}
