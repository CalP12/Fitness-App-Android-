package com.example.fitapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter2 extends FragmentStateAdapter {
    public FragmentAdapter2(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position)
        {
            case 1:
                return new gainFragment2();
            case 2:
                return new gainFragment3();
            case 3:
                return new gainFragment4();
            case 4:
                return new gainFragment5();
            case 5:
                return new gainFragment6();
            case 6:
                return new gainFragment7();
        }
        return new gainFragment1();
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
