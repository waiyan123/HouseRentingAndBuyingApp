package itachi_waiyan.com.hotelbuyingandrankingapp.data.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;
import itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent.HotelDataAgent;
import itachi_waiyan.com.hotelbuyingandrankingapp.util.Constant;

public class HotelModelImpl extends BaseModel implements HotelModel{

    private static HotelModelImpl objInstance;
    private Map<Integer, HotelVO> mDataRepository;

    private  HotelModelImpl(){
        mDataRepository=new HashMap<>();
    }



    public static HotelModelImpl getObjInstance(){
        if(objInstance == null)
            objInstance=new HotelModelImpl();
        return objInstance;
    }

    @Override
    public void getHotels(final GetHotelsFromDataLayerDelegate dataLayerDelegate) {
        mDataAgent.getHotelsFromNetwork(new HotelDataAgent.GetHotelsFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HotelVO> hotelList) {
                dataLayerDelegate.onSuccess(hotelList);
            }

            @Override
            public void onFailure(String errorMessage) {
                dataLayerDelegate.onFailure(errorMessage);
            }
        });
    }

}
