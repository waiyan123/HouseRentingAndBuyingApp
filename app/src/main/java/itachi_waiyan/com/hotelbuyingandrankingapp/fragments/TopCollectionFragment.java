package itachi_waiyan.com.hotelbuyingandrankingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itachi_waiyan.com.hotelbuyingandrankingapp.R;
import itachi_waiyan.com.hotelbuyingandrankingapp.adapters.HotelRecyclerViewAdapter;
import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;

public class TopCollectionFragment extends Fragment {
    EventHotelItemDelegate mEventHotelItemDelegate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_collection,container,false);
        RecyclerView rvHotel = view.findViewById(R.id.rv_hotel);
        HotelRecyclerViewAdapter adapter = new HotelRecyclerViewAdapter(mEventHotelItemDelegate);
        rvHotel.setAdapter(adapter);
        rvHotel.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mEventHotelItemDelegate = (EventHotelItemDelegate) context;
    }
}
