package itachi_waiyan.com.hotelbuyingandrankingapp.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;
import itachi_waiyan.com.hotelbuyingandrankingapp.util.Constant;

public class HotelResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<HotelVO> hotelList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<HotelVO> getHotelList() {
        return hotelList;
    }

    public void setHouseList(List<HotelVO> hotelList) {
        this.hotelList = hotelList;
    }

    public boolean isResponseOk(){
        return code == Constant.CODE_RESPONSE_OK && hotelList!= null;
    }
}
