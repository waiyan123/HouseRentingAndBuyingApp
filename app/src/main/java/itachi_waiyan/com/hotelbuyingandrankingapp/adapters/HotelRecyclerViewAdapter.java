package itachi_waiyan.com.hotelbuyingandrankingapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.R;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModel;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;
import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;
import itachi_waiyan.com.hotelbuyingandrankingapp.viewHolders.RvHoltelViewHolder;

public class HotelRecyclerViewAdapter extends BaseRecyclerAdapter{
    EventHotelItemDelegate mEventItemDelegate;
    List<HotelVO>hotelList;
    Context context;

    public HotelRecyclerViewAdapter(Context context, EventHotelItemDelegate eventItemDelegate, List<HotelVO>list){

        mEventItemDelegate = eventItemDelegate;
        hotelList = list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_hotel_item_view,viewGroup,false);
        return new RvHoltelViewHolder(itemView,mEventItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RvHoltelViewHolder rvHoltelViewHolder = (RvHoltelViewHolder) viewHolder;
        Glide.with(context.getApplicationContext())
                .load(hotelList.get(i).getHouseImageUrl())
                .apply(RequestOptions.centerCropTransform().error(R.drawable.ic_map_white).placeholder(R.drawable.ic_map_white))
                .into(rvHoltelViewHolder.imgHotel);
        rvHoltelViewHolder.tvPrice.setText(String.valueOf(hotelList.get(i).getPrice()));
        rvHoltelViewHolder.tvLocation.setText(hotelList.get(i).getLatitude()+","+
                hotelList.get(i).getLongitude());
        rvHoltelViewHolder.tvArea.setText(String.valueOf(hotelList.get(i).getSquareFeet()));
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }
}
