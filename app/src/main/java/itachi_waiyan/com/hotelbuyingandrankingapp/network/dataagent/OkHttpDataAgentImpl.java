package itachi_waiyan.com.hotelbuyingandrankingapp.network.dataagent;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import itachi_waiyan.com.hotelbuyingandrankingapp.network.response.HotelResponse;
import itachi_waiyan.com.hotelbuyingandrankingapp.util.Constant;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Timeout;

public class OkHttpDataAgentImpl implements HotelDataAgent{
    public static OkHttpDataAgentImpl objInstance;
    private OkHttpClient okHttpClient;

    private OkHttpDataAgentImpl(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

    }


    public static OkHttpDataAgentImpl getObjInstance(){
        if(objInstance == null)
            objInstance=new OkHttpDataAgentImpl();
        return objInstance;
    }

    @Override
    public void getHotelsFromNetwork(GetHotelsFromNetworkDelegate networkDelegate) {
        new GetHotelTask(networkDelegate,okHttpClient).execute();
    }

    public static class GetHotelTask extends AsyncTask<Void,Void, HotelResponse> {
        private GetHotelsFromNetworkDelegate networkDelegate;
        private OkHttpClient okHttpClient;
        private String mAccessToken;

        private GetHotelTask(GetHotelsFromNetworkDelegate networkDelegate, OkHttpClient okHttpClient) {
            this.networkDelegate = networkDelegate;
            this.okHttpClient = okHttpClient;

        }

        @Override
        protected HotelResponse doInBackground(Void... voids) {
            RequestBody formBody = new FormBody.Builder()
                    .build();

            Request request = new Request.Builder()
                    .url(Constant.BASE_URL+Constant.GET_HOUSES)
                    .post(formBody)
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()){
                    String responseString = response.body().string();
                    HotelResponse hotelResponse = new Gson().fromJson(responseString,HotelResponse.class);
                            return hotelResponse;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(HotelResponse getHotelResponse) {
            super.onPostExecute(getHotelResponse);
            if(getHotelResponse !=null){
                if(getHotelResponse.isResponseOk()){
                    networkDelegate.onSuccess(getHotelResponse.getHotelList());
                }
                else{
                    networkDelegate.onFailure(getHotelResponse.getMessage());
                }
            }else{
                networkDelegate.onFailure(Constant.EM_NULL_EVENT_RESPONSE);
            }
        }
    }
}
