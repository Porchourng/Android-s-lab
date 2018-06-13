package kh.edu.niptict.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kh.edu.niptict.recyclerview.R;
import kh.edu.niptict.recyclerview.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    ArrayList<Movie> movieList;

    public MovieAdapter(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        holder.titleTv.setText(movieList.get(position).getTitle());
        holder.desTv.setText(movieList.get(position).getDes());
        holder.yearTv.setText(movieList.get(position).getYear()+"");
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView titleTv;
        TextView desTv;
        TextView yearTv;
        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.title);
            desTv = itemView.findViewById(R.id.des);
            yearTv = itemView.findViewById(R.id.year);
        }
    }
}
