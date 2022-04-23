package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<ListItem> progressList;
    private onItemClickListener listener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener (onItemClickListener listener) {
        this.listener = listener;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView novelName;
        public TextView novelAuthor;
        public TextView progress;
        public TextView status;

        public ListViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            novelName = itemView.findViewById(R.id.txtListName);
            novelAuthor = itemView.findViewById(R.id.txtListAuthor);
            progress = itemView.findViewById(R.id.txtListProgress);
            status = itemView.findViewById(R.id.txtListStatus);

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
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        ListViewHolder lvh = new ListViewHolder(view, listener);
        return lvh;
    }

    public ListAdapter(ArrayList<ListItem> progressList) {
        this.progressList = progressList;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListItem currentItem = progressList.get(position);

        holder.novelName.setText(currentItem.getListName());
        holder.novelAuthor.setText(currentItem.getListAuthor());
        holder.progress.setText(String.format("%s / %s chp", currentItem.getNumRead(), currentItem.getNumChaps()));
        holder.status.setText(currentItem.getCurrStatus());

    }

    @Override
    public int getItemCount() {
        return progressList.size();
    }




}
