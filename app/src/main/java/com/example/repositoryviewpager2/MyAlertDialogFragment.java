package com.example.repositoryviewpager2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.repositoryviewpager2.fragment.CountrySelectionPresidentFragmentViewModel;

public class MyAlertDialogFragment extends DialogFragment {
    public static EditText mEditText;
    private Button done;
    private Button cancel;
    private CountrySelectionPresidentFragmentViewModel viewModelSearch;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelSearch = new ViewModelProvider(this).get(CountrySelectionPresidentFragmentViewModel.class);

    }

    public MyAlertDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        done =view.findViewById(R.id.btnDone);
        cancel =view.findViewById(R.id.btnCancel);
        mEditText = (EditText) view.findViewById(R.id.txt_your_search);
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(done==view){
                    viewModelSearch.searchChoice(mEditText.getText().toString());
                    ApplicationData.getInstance().setSearchValue(mEditText.getText().toString());
                    Toast.makeText(MyAlertDialogFragment.this.getContext(),"le mot"+mEditText.getText().toString(),Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public static MyAlertDialogFragment newInstance(String title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


}
