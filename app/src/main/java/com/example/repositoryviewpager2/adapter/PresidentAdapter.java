package com.example.repositoryviewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositoryviewpager2.OnImageCancelClickedAction;
import com.example.repositoryviewpager2.model.President;
import com.example.repositoryviewpager2.R;
import com.example.repositoryviewpager2.viewHolder.PresidentViewHolder;

import java.util.ArrayList;

public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {
    private ArrayList<President>listPresidents;
    private OnImageCancelClickedAction onImageCancelClickedAction;

    public PresidentAdapter(ArrayList<President> listPresidents, OnImageCancelClickedAction onImageCancelClickedAction) {
        this.listPresidents = listPresidents;
        this.onImageCancelClickedAction = onImageCancelClickedAction;
    }

    public void setListPresidents(ArrayList<President> listPresidents) {
        this.listPresidents = listPresidents;
    }

    @NonNull
    @Override
    public PresidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_president_list,parent,false);
        return new PresidentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PresidentViewHolder holder, int position) {
        holder.bind(listPresidents.get(position),onImageCancelClickedAction);
    }

    @Override
    public int getItemCount() {
        return listPresidents.size();
    }
}
