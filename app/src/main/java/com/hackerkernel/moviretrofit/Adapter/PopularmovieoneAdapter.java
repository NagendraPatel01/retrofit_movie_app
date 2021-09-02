package com.hackerkernel.moviretrofit.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragment.PopularmovieinfoFragment;

public class PopularmovieoneAdapter extends FragmentPagerAdapter {

    String persion_id;

    public PopularmovieoneAdapter( FragmentManager fm,String persion_id) {
        super(fm);
        this.persion_id=persion_id;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
               return new PopularmovieinfoFragment(persion_id);

            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return 1;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){

            case 0:
                return "info";

            default:
                return null;
        }
    }
}
