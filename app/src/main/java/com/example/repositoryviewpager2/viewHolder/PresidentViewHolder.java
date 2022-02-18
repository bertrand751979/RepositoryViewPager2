package com.example.repositoryviewpager2.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositoryviewpager2.OnImageCancelClickedAction;
import com.example.repositoryviewpager2.model.President;
import com.example.repositoryviewpager2.R;

public class PresidentViewHolder extends RecyclerView.ViewHolder {
    private TextView vhPresidentName;
    private TextView vhPresidentCountry;
    private ImageView vhImgCancel;

    public PresidentViewHolder(@NonNull View view) {
        super(view);
        vhPresidentName = view.findViewById(R.id.raw_president_name);
        vhPresidentCountry = view.findViewById(R.id.raw_president_country);
        vhImgCancel = view.findViewById(R.id.raw_btn_cancel);
    }

    public TextView getVhPresidentName() {
        return vhPresidentName;
    }

    public void setVhPresidentName(TextView vhPresidentName) {
        this.vhPresidentName = vhPresidentName;
    }

    public TextView getVhPresidentCountry() {
        return vhPresidentCountry;
    }

    public void setVhPresidentCountry(TextView vhPresidentCountry) {
        this.vhPresidentCountry = vhPresidentCountry;
    }

    public ImageView getVhImgCancel() {
        return vhImgCancel;
    }

    public void setVhImgCancel(ImageView vhImgCancel) {
        this.vhImgCancel = vhImgCancel;
    }

    public void bind(President president, OnImageCancelClickedAction onImageCancelClickedAction){
        vhPresidentName.setText(president.getPresidentName());
        vhPresidentCountry.setText(president.getPresidentCountry());
        vhImgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageCancelClickedAction.deleteItem(president);
            }
        });
    }

}
