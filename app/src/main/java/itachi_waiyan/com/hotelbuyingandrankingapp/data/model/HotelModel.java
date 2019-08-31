package itachi_waiyan.com.hotelbuyingandrankingapp.data.model;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;

public interface HotelModel {

    void getHotels(GetHotelsFromDataLayerDelegate dataLayerDelegate);

    interface GetHotelsFromDataLayerDelegate{
        void onSuccess(List<HotelVO> houseList);
        void onFailure(String errorMessage);
    }
}
