package itachi_waiyan.com.hotelbuyingandrankingapp.data.model;

import itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent.HotelDataAgent;
import itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent.HttpUrlConnectionDataAgentImpl;
import itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent.OkHttpDataAgentImpl;

public class BaseModel {
    protected HotelDataAgent mDataAgent;

    BaseModel(){
        mDataAgent= OkHttpDataAgentImpl.getObjInstance();
    }
}
