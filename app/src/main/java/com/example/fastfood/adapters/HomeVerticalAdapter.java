package com.example.fastfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.modules.HomeVerticalModule;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ViewHolder>{
    private BottomSheetDialog bottomSheetDialog;
    Context context;
   ArrayList<HomeVerticalModule> list;

    public HomeVerticalAdapter(Context context, ArrayList<HomeVerticalModule> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeVerticalAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final  String bname = list.get(position).getProduct_name();
        final  String bdelivery = list.get(position).getDelivery();
        final  String bprice = list.get(position).getPrice();
        final  String brating = list.get(position).getRating();
        final  int bimage = list.get(position).getImage();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getProduct_name());
        holder.delivery.setText(list.get(position).getDelivery());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);
                 View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet,null);
                 sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
                         bottomSheetDialog.dismiss();
                     }
                 });
                 ImageView bottomImage = sheetView.findViewById(R.id.bottom_menu_image);
                 TextView bottomName = sheetView.findViewById(R.id.bname);
                 TextView bottomPrice = sheetView.findViewById(R.id.bmeal_price);
                 TextView bottomRating = sheetView.findViewById(R.id.brating);
                 TextView bottomTime = sheetView.findViewById(R.id.btimings);
                 bottomName.setText(bname);
                 bottomRating.setText(brating);
                 bottomPrice.setText(bprice);
                 bottomImage.setImageResource(bimage);
                 bottomTime.setText(bdelivery);

                 bottomSheetDialog.setContentView(sheetView);
                 bottomSheetDialog.show();

            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,delivery,rating,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.breakfast);
            name = itemView.findViewById(R.id.product_name);
            delivery = itemView.findViewById(R.id.Delivery);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);

        }
    }
}
