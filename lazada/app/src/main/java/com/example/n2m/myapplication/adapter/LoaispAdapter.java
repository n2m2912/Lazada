package com.example.n2m.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.n2m.myapplication.R;
import com.example.n2m.myapplication.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//* Create day
// Anh.Tran 5/12/2018
//  And Create file
// *// Layout/dong_listview_Loaisp.xml



public class LoaispAdapter extends BaseAdapter {

    ArrayList<Loaisp> arrayListloaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListloaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

     public class ViewHolder{
        TextView txtTenloaisp ;
        ImageView imgLoaisp;

     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.txtTenloaisp = (TextView) convertView.findViewById(R.id.textViewloaisanpham);
            viewHolder.imgLoaisp = (ImageView) convertView.findViewById(R.id.imageViewLoaisp);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
            Loaisp loaisp=(Loaisp)getItem(position);
            viewHolder.txtTenloaisp.setText(loaisp.getTenloaisp());
            Picasso.with(context).load(loaisp.getHinhanhloaisp())
                    .placeholder(R.drawable.cliff) // cho load
                    .error(R.drawable.clouds) // load khong co anh
                    .into(viewHolder.imgLoaisp);
        }
        return convertView;
    }
}
