package itachi_waiyan.com.hotelbuyingandrankingapp.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.MainActivity;
import itachi_waiyan.com.hotelbuyingandrankingapp.R;
import itachi_waiyan.com.hotelbuyingandrankingapp.adapters.HomeViewPagerAdapter;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModel;

public class HomeFragment extends Fragment{
    ViewPager viewPager ;
    TabLayout tabs;
    HomeViewPagerAdapter adapter;
    Fragment topCollectionFragment,nearMeFragment,lowToHighFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        viewPager = view.findViewById(R.id.home_view_pager);

        tabs = view.findViewById(R.id.home_tab_layout);
        tabs.setupWithViewPager(viewPager);
        setUpWithViewPager(viewPager);
        tabs.setHorizontalScrollBarEnabled(false);

        return view;
    }



    public void setUpWithViewPager(ViewPager vp){
        topCollectionFragment = new TopCollectionFragment();
        nearMeFragment = new NearMeFragment();
        lowToHighFragment = new LtoHFragment();
        adapter = new HomeViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(topCollectionFragment,getResources().getString(R.string.top_collection));
        adapter.addFragment(nearMeFragment,getResources().getString(R.string.near_me));
        adapter.addFragment(lowToHighFragment,getResources().getString(R.string.low_to_high));
        vp.setAdapter(adapter);
    }
}
