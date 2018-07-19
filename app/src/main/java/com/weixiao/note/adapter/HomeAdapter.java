package com.weixiao.note.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.weixiao.note.R;
import com.weixiao.note.model.Note;

import java.util.List;

/**
 * Created by weixiao on 18/7/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final static String TAG = "HomeAdapter";

    private Context context;
    private List<Note> noteList;
    private int width;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder = " + position);
    }

    @Override
    public int getItemCount() {
        return noteList == null ? 0 : noteList.size();
    }

    public void refreshAllData(List<Note> notes) {
        noteList = notes;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_view);
        }
    }
}
