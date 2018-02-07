package com.masum.alphabetindexer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.masum.alphabetindexer.model.ListItem;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
 
    private List<ListItem> itemList;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
 
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }
 
 
    public ListAdapter(List<ListItem> list) {
        this.itemList = list;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ListItem movie = itemList.get(position);
        holder.title.setText(movie.getTitle());
    }
 
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}