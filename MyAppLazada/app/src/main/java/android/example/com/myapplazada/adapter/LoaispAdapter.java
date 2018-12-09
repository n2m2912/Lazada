package android.example.com.myapplazada.adapter;
import android.example.com.myapplazada.R;
import android.content.Context;
import android.example.com.myapplazada.model.Loaisp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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
        return 0;
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
            convertView = inflater.inflate(R.layout.dong_listview_loaisp, null);
            viewHolder.txtTenloaisp = (TextView) convertView.findViewById(R.id.textViewloaisanpham);
            viewHolder.imgLoaisp = (ImageView) convertView.findViewById(R.id.imageViewLoaisp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }
        Loaisp loaisp=(Loaisp)getItem(position);
        viewHolder.txtTenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.chotaianh) // cho load
                .error(R.drawable.imgloaderror) // load khong co anh
                .into(viewHolder.imgLoaisp);

        return convertView;
    }
}
