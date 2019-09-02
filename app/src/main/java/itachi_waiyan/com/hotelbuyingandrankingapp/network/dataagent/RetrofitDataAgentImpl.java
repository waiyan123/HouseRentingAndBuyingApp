package itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent;

import java.util.concurrent.TimeUnit;

import itachi_waiyan.com.hotelbuyingandrankingapp.network.RetroApi;
import itachi_waiyan.com.hotelbuyingandrankingapp.util.Constant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements HotelDataAgent{

    public static RetrofitDataAgentImpl objInstance;
    private RetroApi retroApi;

    private RetrofitDataAgentImpl(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retroApi = retrofit.create(RetroApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance == null)
            objInstance=new RetrofitDataAgentImpl();
        return objInstance;
    }
    @Override
    public void getHotelsFromNetwork(GetHotelsFromNetworkDelegate networkDelegate) {

    }
}
