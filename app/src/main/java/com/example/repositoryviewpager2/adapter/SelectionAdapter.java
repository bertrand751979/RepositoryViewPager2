package com.example.repositoryviewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositoryviewpager2.model.President;
import com.example.repositoryviewpager2.R;
import com.example.repositoryviewpager2.viewHolder.SelectionViewHolder;

import java.util.ArrayList;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionViewHolder> {
    private ArrayList<President>listSelections;

    public SelectionAdapter(ArrayList<President> listSelections) {
        this.listSelections = listSelections;
    }

    public void setListSelections(ArrayList<President> listSelections) {
        this.listSelections = listSelections;
    }

    @NonNull
    @Override
    public SelectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_selection_list,parent,false);
        return new SelectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectionViewHolder holder, int position) {
        holder.bind(listSelections.get(position));
    }

    @Override
    public int getItemCount() {
        return listSelections.size();
    }
}
