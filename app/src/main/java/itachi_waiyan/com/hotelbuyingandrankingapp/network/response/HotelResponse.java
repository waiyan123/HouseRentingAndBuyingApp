package itachi_waiyan.com.hotelbuyingandrankingapp.network.response;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;

public class HotelResponse {

    private String message;
    private int code;
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
}
