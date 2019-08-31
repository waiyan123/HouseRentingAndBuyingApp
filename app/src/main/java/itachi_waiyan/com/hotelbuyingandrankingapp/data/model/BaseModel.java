package itachi_waiyan.com.hotelbuyingandrankingapp.data.model;

import itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent.HotelDataAgent;
import itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent.HttpUrlConnectionDataAgentImpl;

public class BaseModel {
    protected HotelDataAgent mDataAgent;

    BaseModel(){
        mDataAgent= HttpUrlConnectionDataAgentImpl.getObjInstance();
    }
}
