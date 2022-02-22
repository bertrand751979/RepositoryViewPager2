package com.example.repositoryviewpager2.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.repositoryviewpager2.ApplicationData;
import com.example.repositoryviewpager2.model.President;
import java.util.ArrayList;

public class PresidentListFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<President>> presidentList = new MutableLiveData<>();
    public LiveData<ArrayList<President>> presidentLiveData = presidentList;

    public void publishPresidentList(){
        presidentList.postValue(ApplicationData.getInstance().getMyPresidentList());
    }

    public void addPresident(President president){
        ApplicationData.getInstance().add(president);
        publishPresidentList();
    }

    public void deletedPresident(President president){
        ApplicationData.getInstance().delete(president);
        publishPresidentList();
    }

}
