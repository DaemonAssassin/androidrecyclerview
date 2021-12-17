package com.gmail.mateendev3.androidrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    List<Car> cars;
    Context mContext;

    public CarAdapter(List<Car> cars, Context context) {
        this.cars = cars;
        mContext = context;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row, parent, false);
        return new CarViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.tvCarName.setText(car.getCarName());
        holder.ivCarImage.setImageResource(car.getCarImageResId());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    //This is the ViewHolder class which holds the view
    class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCarImage;
        TextView tvCarName;

        //rootView is the root of the custom layout file
        //this root view is come from onCreateViewHolder class
        public CarViewHolder(@NonNull View rootView) {
            super(rootView);
            ivCarImage = rootView.findViewById(R.id.iv_car_image);
            tvCarName = rootView.findViewById(R.id.tv_car_name);

            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, cars.get(getAdapterPosition()).getCarName() + "clicked", Toast.LENGTH_SHORT).show();
                }
            });

            rootView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    cars.remove(getAdapterPosition());
                    CarAdapter.this.notifyItemRemoved(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
