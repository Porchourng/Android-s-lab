package kh.edu.niptict.librarymangementroomdb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kh.edu.niptict.librarymangementroomdb.R;
import kh.edu.niptict.librarymangementroomdb.database.entity.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    List<Book> lists;
    Context context;

    public BookAdapter(Context context, List<Book> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get()
                .load("https://images.gr-assets.com/books/1340809944l/12337461.jpg")
                .placeholder(R.drawable.ic_cloud_off)
                //.into(holder.imageView);
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("LoadImage", "true");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("LoadImage", e.getMessage());
                    }
                });
        holder.titleLb.setText(lists.get(position).getTitle());
        holder.isbnLb.setText(lists.get(position).getIsbn());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public void addNewList(List<Book> books) {
        this.lists = books;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView titleLb;
        private TextView isbnLb;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.bookImg);
            titleLb = itemView.findViewById(R.id.nameLb);
            isbnLb = itemView.findViewById(R.id.isbnLb);
        }
    }
}
