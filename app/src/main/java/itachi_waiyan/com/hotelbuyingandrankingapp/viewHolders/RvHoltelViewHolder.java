package itachi_waiyan.com.hotelbuyingandrankingapp.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import itachi_waiyan.com.hotelbuyingandrankingapp.R;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;
import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;

public class RvHoltelViewHolder extends BaseViewHolder<HotelVO> {

    private EventHotelItemDelegate mEventHotelItemDelegate;

    public ImageView imgHotel;
    public TextView tvPrice,tvLocation,tvArea,tvBedrooms;

    public RvHoltelViewHolder(@NonNull View itemView,EventHotelItemDelegate eventHotelItemDelegate) {
        super(itemView);
        imgHotel = itemView.findViewById(R.id.img_hotel);
        tvPrice = itemView.findViewById(R.id.tv_price);
        tvLocation = itemView.findViewById(R.id.tv_location);
        tvArea = itemView.findViewById(R.id.tv_area);
        tvBedrooms = itemView.findViewById(R.id.tv_bedrooms);
        this.mEventHotelItemDelegate = eventHotelItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEventHotelItemDelegate.onTabEventItem();
            }
        });
    }

    @Override
    public void bindData(HotelVO data) {

    }
}
