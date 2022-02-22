package com.example.repositoryviewpager2.fragment;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.repositoryviewpager2.ApplicationData;
import com.example.repositoryviewpager2.model.President;

import java.util.ArrayList;

public class CountrySelectionPresidentFragmentViewModel extends ViewModel {
        //Deux live data dont un modifiable.
    private MutableLiveData<ArrayList<President>> searchList = new MutableLiveData<>();
    public LiveData<ArrayList<President>> searchLiveData = searchList;

    private MutableLiveData<Boolean> result = new MutableLiveData<>();
    public LiveData<Boolean> resultLifeData = result;

    public void toPostMyListSelection(){
        searchList.postValue(ApplicationData.getInstance().getMyPresidentList());
    }

    public void searchChoice(String countryName) {
        ApplicationData.getInstance().mySearchingList.clear();
        if (countryName.equals("")) {
            return;
        }
        for (President president : ApplicationData.getInstance().myPresidentList) {
            if (president.getPresidentCountry().toLowerCase().contains(countryName.toLowerCase())) {
                ApplicationData.getInstance().mySearchingList.add(president);
                ApplicationData.getInstance().setPresidentSortItem(president);
                //Log.d("List ", String.valueOf(list.size()));
                //Log.d("List2 ", String.valueOf(mySearchingList.size()));

            }
        }
    }

    public void countrySearching(String countryResearch){
        if(ApplicationData.getInstance().searchCountry(countryResearch)==true){
            searchList.postValue(ApplicationData.getInstance().getMyPresidentList());
            result.postValue(true);
        }else{
            result.postValue(false);
        }
    }




}
