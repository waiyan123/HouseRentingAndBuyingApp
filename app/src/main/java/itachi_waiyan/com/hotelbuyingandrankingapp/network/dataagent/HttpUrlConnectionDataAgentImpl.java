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

import itachi_waiyan.com.hotelbuyingandrankingapp.network.response.HotelResponse;
import itachi_waiyan.com.hotelbuyingandrankingapp.util.Constant;

public class HttpUrlConnectionDataAgentImpl implements HotelDataAgent{
    public static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl(){}


    public static HttpUrlConnectionDataAgentImpl getObjInstance(){
        if(objInstance == null)
            objInstance=new HttpUrlConnectionDataAgentImpl();
        return objInstance;
    }


    @Override
    public void getHotelsFromNetwork(GetHotelsFromNetworkDelegate networkDelegate) {
        new GetHotelTask(networkDelegate).execute();
    }

    public static class GetHotelTask extends AsyncTask<Void,Void, HotelResponse> {
        private GetHotelsFromNetworkDelegate networkDelegate;

        private GetHotelTask(GetHotelsFromNetworkDelegate networkDelegate) {
            this.networkDelegate = networkDelegate;
        }

        @Override
        protected HotelResponse doInBackground(Void... voids) {
            URL url;
            BufferedReader bufferedReader=null;
            StringBuilder stringBuilder;

            try {
                url=new URL(Constant.BASE_URL + Constant.GET_HOUSES);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setReadTimeout(15 * 10000);
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.connect();

                bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder=new StringBuilder();
                String line=null;
                while (((line=bufferedReader.readLine()) != null)){
                    stringBuilder.append(line + " \n");
                }

                String responseString=stringBuilder.toString();
                Gson gson = new GsonBuilder().create();
                HotelResponse response=new Gson().fromJson(responseString,HotelResponse.class);

                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(bufferedReader !=null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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
