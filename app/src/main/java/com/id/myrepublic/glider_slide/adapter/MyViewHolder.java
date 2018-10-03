package com.id.myrepublic.glider_slide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.id.myrepublic.glider_slide.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView thumbnail;

    public MyViewHolder(View view) {
        super(view);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
    }
}
