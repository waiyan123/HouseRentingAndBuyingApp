package itachi_waiyan.com.hotelbuyingandrankingapp.network;

import com.google.gson.annotations.SerializedName;

import itachi_waiyan.com.hotelbuyingandrankingapp.network.response.HotelResponse;
import itachi_waiyan.com.hotelbuyingandrankingapp.util.Constant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroApi {

    @POST("/getAllHouses")
    Call<HotelResponse>getHotelResponse();
}
