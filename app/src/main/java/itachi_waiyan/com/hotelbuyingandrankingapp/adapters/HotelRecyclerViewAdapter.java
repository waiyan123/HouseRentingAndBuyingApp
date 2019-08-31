package itachi_waiyan.com.hotelbuyingandrankingapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itachi_waiyan.com.hotelbuyingandrankingapp.R;
import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;
import itachi_waiyan.com.hotelbuyingandrankingapp.viewHolders.RvHoltelViewHolder;

public class HotelRecyclerViewAdapter extends RecyclerView.Adapter{
    EventHotelItemDelegate mEventItemDelegate;

    public HotelRecyclerViewAdapter(EventHotelItemDelegate eventItemDelegate){
        mEventItemDelegate = eventItemDelegate;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_hotel_item_view,viewGroup,false);
        return new RvHoltelViewHolder(itemView,mEventItemDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
