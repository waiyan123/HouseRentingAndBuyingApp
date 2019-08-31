package itachi_waiyan.com.hotelbuyingandrankingapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.activities.BaseActivity;
import itachi_waiyan.com.hotelbuyingandrankingapp.activities.DetailActivity;
import itachi_waiyan.com.hotelbuyingandrankingapp.adapters.MainViewPagerAdapter;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModel;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;
import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;
import itachi_waiyan.com.hotelbuyingandrankingapp.fragments.HomeFragment;

public class MainActivity extends BaseActivity implements EventHotelItemDelegate {

    ViewPager viewPager;
    MainViewPagerAdapter adapter;
    TabLayout tabs;
    Fragment fragmentForYou, fragmentBookmark, fragmentFavourite,fragmentLocation,fragmentProfile,fragmentSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hotelModel.getHotels(new HotelModel.GetHotelsFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<HotelVO> hotelList) {

            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(getApplicationContext(),errorMessage,Toast.LENGTH_LONG).show();
            }
        });


        viewPager = findViewById(R.id.main_view_pager);
        tabs = findViewById(R.id.main_tab_layout);
        tabs.setupWithViewPager(viewPager);
        setupWithViewPager(viewPager);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.black);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.iconColorSecondary);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.black);
        tabs.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);



    }

    private void setupWithViewPager(ViewPager vp) {
        fragmentForYou = new HomeFragment();
        fragmentBookmark = new HomeFragment();
        fragmentFavourite = new HomeFragment();
        fragmentLocation = new HomeFragment();
        fragmentProfile = new HomeFragment();
        fragmentSetting = new HomeFragment();
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentForYou, "For you");
        adapter.addFragment(fragmentBookmark, "Bookmark");
        adapter.addFragment(fragmentFavourite, "Favourite");
        adapter.addFragment(fragmentLocation, "Location");
        adapter.addFragment(fragmentProfile, "Profile");
        adapter.addFragment(fragmentSetting, "Setting");
        viewPager.setAdapter(adapter);
        tabs.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.for_you));
        tabs.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_map_white));
        tabs.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        tabs.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_explore_black_24dp));
        tabs.getTabAt(4).setIcon(getResources().getDrawable(R.drawable.ic_person_black_24dp));
        tabs.getTabAt(5).setIcon(getResources().getDrawable(R.drawable.ic_more_horiz_black_24dp));



    }

    @Override
    public void onTabEventItem() {
        startActivity(new Intent(MainActivity.this, DetailActivity.class));
    }
}
