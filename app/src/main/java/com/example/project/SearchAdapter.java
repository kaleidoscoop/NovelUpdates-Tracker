package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private ArrayList<SearchItem> searchList;
    private onItemClickListener listener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener (onItemClickListener listener) {
        this.listener = listener;
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        public TextView novelName;
        public TextView novelAuthor;

        public SearchViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            novelName = itemView.findViewById(R.id.txtName);
            novelAuthor = itemView.findViewById(R.id.txtAuthor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }

                }
            });

        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        SearchViewHolder svh = new SearchViewHolder(view, listener);
        return svh;
    }

    public SearchAdapter(ArrayList<SearchItem> searchList) {
        this.searchList = searchList;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchItem currentItem = searchList.get(position);

        holder.novelName.setText(currentItem.getNovelName());
        holder.novelAuthor.setText(currentItem.getNovelAuthor());
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }


}
