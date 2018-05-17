package kh.edu.niptict.spinnercustomlayout.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kh.edu.niptict.spinnercustomlayout.R;
import kh.edu.niptict.spinnercustomlayout.model.Items;

/*
This class should extend ArrayAdapter<T> class where T should be replaced
by the type of data that you want to display.
In this case I replace T with class Items
 */
public class ItemsAdapter extends ArrayAdapter<Items> {
    private List<Items> itemsList;
    private LayoutInflater inflater;
    private int resourceLayout;

    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        itemsList = objects;
        inflater = LayoutInflater.from(context);
        resourceLayout = resource;
    }

    /*
    Override method getDropDownView and getView inorder to
    which return item views for spinner in normal state and drop down state respectively.
     */
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, parent);
    }

    private View createItemView(int position, ViewGroup parent) {
        View view = inflater.inflate(resourceLayout, parent, false);

        Items item = itemsList.get(position);

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(item.getName());
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(item.getImage());

        return view;
    }
}
