package com.example.repositoryviewpager2;


import android.util.Log;

import com.example.repositoryviewpager2.fragment.PresidentListFragment;
import com.example.repositoryviewpager2.model.President;
import java.util.ArrayList;

public class ApplicationData {
    private President presidentItem;
    private President presidentSortItem;
    public ArrayList<President>mySearchingList = new ArrayList<>();
    public ArrayList<President> myPresidentList = new ArrayList<>();


    private ApplicationData() {
    }

    private static ApplicationData INSTANCE = null;

    public static ApplicationData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationData();
        }
        return INSTANCE;
    }

    public ArrayList<President> getMyPresidentList() {
        return myPresidentList;
    }

    public void setMyPresidentList(ArrayList<President> myPresidentList) {
        this.myPresidentList = myPresidentList;
    }

    public President getPresidentItem() {
        return presidentItem;
    }

    public void setPresidentItem(President presidentItem) {
        this.presidentItem = presidentItem;
    }

    public President getPresidentSortItem() {
        return presidentSortItem;
    }

    public void setPresidentSortItem(President presidentSortItem) {
        this.presidentSortItem = presidentSortItem;
    }

    public void add(President president){
        myPresidentList.add(president);
    }

    public void delete(President president){
        myPresidentList.remove(president);
    }



    public void searchChoice(String countryName) {
        mySearchingList.clear();
        if (countryName.equals("")) {
            return;
        }
            for (President president : myPresidentList) {
                if (president.getPresidentCountry().toLowerCase().contains(countryName.toLowerCase())) {
                    mySearchingList.add(president);
                    ApplicationData.getInstance().setPresidentSortItem(president);
                    //Log.d("List ", String.valueOf(list.size()));
                    Log.d("List2 ", String.valueOf(mySearchingList.size()));
                }
        }
    }



}