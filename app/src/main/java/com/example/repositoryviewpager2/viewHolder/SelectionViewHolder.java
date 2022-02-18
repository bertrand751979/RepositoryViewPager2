package com.example.repositoryviewpager2.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositoryviewpager2.model.President;
import com.example.repositoryviewpager2.R;

public class SelectionViewHolder extends RecyclerView.ViewHolder {
    private TextView vhSelectionPresidentName;
    private TextView vhSelectionPresidentCountry;

    public SelectionViewHolder(@NonNull View view) {
        super(view);
        vhSelectionPresidentName = view.findViewById(R.id.raw_selection_president_name);
        vhSelectionPresidentCountry = view.findViewById(R.id.raw_selection_president_country);
    }

    public TextView getVhSelectionPresidentName() {
        return vhSelectionPresidentName;
    }

    public void setVhSelectionPresidentName(TextView vhSelectionPresidentName) {
        this.vhSelectionPresidentName = vhSelectionPresidentName;
    }

    public TextView getVhSelectionPresidentCountry() {
        return vhSelectionPresidentCountry;
    }

    public void setVhSelectionPresidentCountry(TextView vhSelectionPresidentCountry) {
        this.vhSelectionPresidentCountry = vhSelectionPresidentCountry;
    }

    public void bind(President president){
        vhSelectionPresidentName.setText(president.getPresidentName());
        vhSelectionPresidentCountry.setText(president.getPresidentCountry());
    }
}
