package android.example.com.myapplazada.adapter;
import android.content.Context;
import android.example.com.myapplazada.R;
import android.example.com.myapplazada.model.Sanpham;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ViewHolder> {

    Context context;
    ArrayList<Sanpham> sanphamArrayList;

    public SanphamAdapter(Context context, ArrayList<Sanpham> sanphamArrayList) {
        this.context = context;
        this.sanphamArrayList = sanphamArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.dong_sanphammoinhat, viewGroup,false);
        return new ViewHolder(itemView);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    /*    viewHolder.txttensanpham.setText(sanphamArrayList.get(i).getTensanpham());
        viewHolder.txtgiasanpham.setText(sanphamArrayList.get(i).getGiasanpham());
        viewHolder.imghinhsanpham.setImageResource(R.drawable.ic_launcher_background);*/


        Sanpham sanpham = sanphamArrayList.get(i);
        viewHolder.txttensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiasanpham.setText("Gía: "+ decimalFormat.format(sanpham.getGiasanpham()) + "Đ");

        Picasso.with(context).load(sanpham.getHinhsanpham())
                .placeholder(R.drawable.loo)
                .error(R.drawable.imgloaderror)
                .into(viewHolder.imghinhsanpham);
    }

    @Override
    public int getItemCount() {
        return sanphamArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhsanpham;
        TextView txttensanpham, txtgiasanpham;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhsanpham = (ImageView) itemView.findViewById(R.id.imageViewsanpham);
            txtgiasanpham  = (TextView) itemView.findViewById(R.id.textViewgiasanpham);
            txttensanpham = (TextView) itemView.findViewById(R.id.textViewtensanpham);
        }
    }
}
