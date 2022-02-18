package com.example.repositoryviewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.repositoryviewpager2.fragment.CountrySelectionPresidentFragment;
import com.example.repositoryviewpager2.fragment.PresidentListFragment;

public class IntroductionViewPagerAdapter extends FragmentStateAdapter {
    public IntroductionViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            Fragment fragment = new PresidentListFragment();
            return fragment;
        } else {
            Fragment fragment = new CountrySelectionPresidentFragment();
            return fragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
