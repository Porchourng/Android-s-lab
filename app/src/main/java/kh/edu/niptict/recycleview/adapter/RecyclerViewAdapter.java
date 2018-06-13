package kh.edu.niptict.recycleview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kh.edu.niptict.recycleview.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderCustom> {

    private ArrayList<String> movieNameList;

    public RecyclerViewAdapter(ArrayList<String> movieNameList) {
        this.movieNameList = movieNameList;
    }

    //Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolderCustom onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolderCustom(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolderCustom holder, int position) {
        holder.moviename.setText(movieNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieNameList.size();
    }

    public class ViewHolderCustom extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView moviename;
        Button button;

        public ViewHolderCustom(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            moviename = itemView.findViewById(R.id.movieName);
            button = itemView.findViewById(R.id.button3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), moviename.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), moviename.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
