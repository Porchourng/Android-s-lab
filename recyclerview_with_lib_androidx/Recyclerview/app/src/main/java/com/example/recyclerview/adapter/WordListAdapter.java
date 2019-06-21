package com.example.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Cons.Const;
import com.example.recyclerview.DetailActivity;
import com.example.recyclerview.model.Movie;
import com.example.recyclerview.R;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    LayoutInflater mInflater;
    LinkedList<Movie> moviesList;
    Context context;

    public WordListAdapter(Context context, LinkedList<Movie> moviesList) {
        mInflater = LayoutInflater.from(context);
        this.moviesList = moviesList;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.wordlist_view, parent, false);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Movie m2 = moviesList.get(position);

        String title = m2.getTitle();
        holder.titleTv.setText(title);
        String des = m2.getDes();
        holder.desTv.setText(des);
        int image = m2.getImg();
        holder.imageView.setImageResource(image);

//        String title = moviesList.get(position).getTitle();
//        holder.wordItemView.setText(title);
//        Log.d("Position ", position+"");

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        TextView desTv;
        ImageView imageView;
        RecyclerView.Adapter mAdapter;
        Button btn;

        public WordViewHolder(final View itemView, WordListAdapter adapter) {
            super(itemView);
            // Get the layout
            titleTv = itemView.findViewById(R.id.titleTv);
            desTv = itemView.findViewById(R.id.desTv);
            imageView = itemView.findViewById(R.id.imageView);
            // Associate with this adapter
            this.mAdapter = adapter;
            // Add click listener, if desired
            //itemView.setOnClickListener(this);

            btn = itemView.findViewById(R.id.ratingBtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Yeah " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, titleTv.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    // transfer data from activity to other activity
                    intent.putExtra("KEY_TITLE", titleTv.getText().toString());
                    context.startActivity(intent);
                }
            });

            desTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, titleTv.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    // transfer data from activity to other activity
                    intent.putExtra(Const.KEY_TITLE, desTv.getText().toString());
                    context.startActivity(intent);
                }
            });

          //  itemView.setOnClickListener(this);
        }


//        @Override
//        public void onClick(View v) {
//            Toast.makeText(context, titleTv.getText().toString(), Toast.LENGTH_SHORT).show();
//        }
    }
}
