package itachi_waiyan.com.hotelbuyingandrankingapp.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;

public class RvHoltelViewHolder extends RecyclerView.ViewHolder {

    private EventHotelItemDelegate mEventHotelItemDelegate;

    public RvHoltelViewHolder(@NonNull View itemView,EventHotelItemDelegate eventHotelItemDelegate) {
        super(itemView);
        this.mEventHotelItemDelegate = eventHotelItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEventHotelItemDelegate.onTabEventItem();
            }
        });
    }
}
