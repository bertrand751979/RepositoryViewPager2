package com.example.repositoryviewpager2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositoryviewpager2.ApplicationData;
import com.example.repositoryviewpager2.MyAlertDialogFragment;
import com.example.repositoryviewpager2.OnImageCancelClickedAction;
import com.example.repositoryviewpager2.model.President;
import com.example.repositoryviewpager2.adapter.PresidentAdapter;
import com.example.repositoryviewpager2.R;

import java.util.ArrayList;

public class PresidentListFragment extends Fragment {
    private RecyclerView recyclerView;
    private PresidentAdapter presidentAdapter;
    private EditText editPresidentName;
    private EditText editPresidentCountry;
    private Button btnToAdd;
    public static MenuItem itemSearch;
    public static MenuItem itemMenu;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        President president1 = new President("Clinton", "USA");
        President president2 = new President("Eyadema", "TOGO");
        President president3 = new President("Olympio", "TOGO");
        President president4 = new President("Bush", "USA");
        President president5 = new President("Kim", "COREE DU NORD");
        President president6 = new President("Obama", "USA");
        President president7 = new President("Nixon", "USA");
        ApplicationData.getInstance().myPresidentList.add(president1);
        ApplicationData.getInstance().myPresidentList.add(president2);
        ApplicationData.getInstance().myPresidentList.add(president3);
        ApplicationData.getInstance().myPresidentList.add(president4);
        ApplicationData.getInstance().myPresidentList.add(president5);
        ApplicationData.getInstance().myPresidentList.add(president6);
        ApplicationData.getInstance().myPresidentList.add(president7);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_president_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.recycler_view_display);
        editPresidentName = view.findViewById(R.id.edit_name);
        editPresidentCountry = view.findViewById(R.id.edit_country);
        btnToAdd = view.findViewById(R.id.btn_save);
        btnToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPresidentToList();
            }
        });
        setViewItem();
    }

    private void setViewItem (){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnImageCancelClickedAction onImageCancelClickedAction = new OnImageCancelClickedAction() {
            @Override
            public void deleteItem(President president) {
                ApplicationData.getInstance().myPresidentList.remove(president);
                presidentAdapter.setListPresidents(ApplicationData.getInstance().myPresidentList);
                presidentAdapter.notifyDataSetChanged();
            }
        };
        presidentAdapter = new PresidentAdapter(ApplicationData.getInstance().myPresidentList,onImageCancelClickedAction);
        recyclerView.setAdapter(presidentAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
        itemMenu=menu.findItem(R.id.menu_icon);
        itemSearch = menu.findItem(R.id.display_president_by_country);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_icon:
                return (true);

            case R.id.display_president_by_country:
                showAlertDialog();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    private void showAlertDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        MyAlertDialogFragment alertDialog = MyAlertDialogFragment.newInstance("Some title");
        alertDialog.show(fm, "fragment_alert");
    }

    private void addPresidentToList(){
        President president = new President();
        president.setPresidentName(editPresidentName.getText().toString());
        president.setPresidentCountry(editPresidentCountry.getText().toString());
        ApplicationData.getInstance().myPresidentList.add(president);
        presidentAdapter.setListPresidents(ApplicationData.getInstance().myPresidentList);
        presidentAdapter.notifyDataSetChanged();
        ApplicationData.getInstance().getPresidentItem();
        Toast.makeText(PresidentListFragment.this.getContext(),"Ajout??",Toast.LENGTH_SHORT).show();
    }

}
