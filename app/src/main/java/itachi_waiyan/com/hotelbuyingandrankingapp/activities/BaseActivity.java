package itachi_waiyan.com.hotelbuyingandrankingapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModel;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModelImpl;

public class BaseActivity extends AppCompatActivity {
    protected HotelModel hotelModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotelModel = HotelModelImpl.getObjInstance();
    }
}
