package com.example.project;

import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {
    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new SearchFragment();
        }
        return new ReadingListFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
