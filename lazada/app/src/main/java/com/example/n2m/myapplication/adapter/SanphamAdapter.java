package com.example.n2m.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.n2m.myapplication.model.Sanpham;

import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {

    Context context;
    ArrayList<Sanpham> sanphamArrayList;

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhsanpham;
        public TextView txttensanpham, txtgiasanpham;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            //imghinhsanpham = (ImageView) itemView.findViewById(R.id.imageViewsanpham);
           // txtgiasanpham  = (TextView) itemView.findViewById(R.id.textViewgiasanpham);
           // txttensanpham = (TextView) itemView.findViewById(R.id.textViewtensanpham);

        }
    }

}
