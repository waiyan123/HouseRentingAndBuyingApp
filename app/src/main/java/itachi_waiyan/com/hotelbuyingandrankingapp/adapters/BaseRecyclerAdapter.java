package itachi_waiyan.com.hotelbuyingandrankingapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import itachi_waiyan.com.hotelbuyingandrankingapp.viewHolders.BaseViewHolder;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>,W> extends RecyclerView.Adapter<T> {

    List<W>mData;

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
