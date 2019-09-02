package itachi_waiyan.com.hotelbuyingandrankingapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.R;
import itachi_waiyan.com.hotelbuyingandrankingapp.adapters.HotelRecyclerViewAdapter;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModel;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.model.HotelModelImpl;
import itachi_waiyan.com.hotelbuyingandrankingapp.data.vos.HotelVO;
import itachi_waiyan.com.hotelbuyingandrankingapp.delegates.EventHotelItemDelegate;

public class TopCollectionFragment extends Fragment {
    EventHotelItemDelegate mEventHotelItemDelegate;
    HotelModel hotelModel;
    List<HotelVO>hotelVOList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_collection,container,false);
        RecyclerView rvHotel = view.findViewById(R.id.rv_hotel);
        Log.d("test---","onCreateView TopCollection");


        HotelRecyclerViewAdapter adapter = new HotelRecyclerViewAdapter(container.getContext(),mEventHotelItemDelegate,hotelVOList);
        rvHotel.setAdapter(adapter);
        rvHotel.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("test---","onViewCreated TopCollection");
        hotelModel = HotelModelImpl.getObjInstance();
        hotelModel.getHotels(new HotelModel.GetHotelsFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<HotelVO> hotelList) {
                hotelVOList = hotelList;
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(view.getContext(),errorMessage,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mEventHotelItemDelegate = (EventHotelItemDelegate) context;
        Log.d("test---","onAttach TopCollection");
    }
}
