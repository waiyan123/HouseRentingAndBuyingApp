package itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;

public interface HotelDataAgent {

    void getHotelsFromNetwork(GetHotelsFromNetworkDelegate networkDelegate);

    interface GetHotelsFromNetworkDelegate{
        void onSuccess(List<HotelVO> houseList);
        void onFailure(String errorMessage);
    }
}
