package com.cra.safedriver.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cra.safedriver.R;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends FragmentStatePagerAdapter {



    ArrayList<Fragment> fragList ;

    FragmentManager fragmentManager;

    public ScreenSlidePageFragment(@NonNull  ArrayList<Fragment> fragList, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.fragList = fragList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return (Fragment)(fragList.get(position));
    }

    @Override
    public int getCount() {
        return fragList.size();
    }
}