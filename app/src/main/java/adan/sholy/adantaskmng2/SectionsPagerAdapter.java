package adan.sholy.adantaskmng2;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

class SectionsPagerAdapter extends PagerAdapter {
    public SectionsPagerAdapter(MainTasksActivity mainTasksActivity, FragmentManager supportFragmentManager) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
