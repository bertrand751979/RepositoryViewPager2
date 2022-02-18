package com.example.repositoryviewpager2.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositoryviewpager2.ApplicationData;
import com.example.repositoryviewpager2.R;
import com.example.repositoryviewpager2.adapter.SelectionAdapter;
import com.example.repositoryviewpager2.model.President;

import java.util.ArrayList;
import java.util.Collections;

public class CountrySelectionPresidentFragment extends Fragment {
    private RecyclerView recyclerView;
    private SelectionAdapter selectionAdapter;
    private ArrayList<President>sortList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        sortList = new ArrayList<>(ApplicationData.getInstance().mySearchingList);
        selectionAdapter.setListSelections(sortList);
        selectionAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_selection_list,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_view_list_selection);

        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        selectionAdapter = new SelectionAdapter(sortList);
        recyclerView.setAdapter(selectionAdapter);

    }
}
