package com.felipesafreire.carros.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felipesafreire.carros.R;
import com.felipesafreire.carros.entities.Car;
import com.felipesafreire.carros.viewholder.CarViewHolder;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> mCarList;

    public CarListAdapter(List<Car> cars) {
        this.mCarList = cars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View carView = inflater.inflate(R.layout.row_car_list, viewGroup, false);
        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {
        Car car = this.mCarList.get(i);
        carViewHolder.bindData(car);
    }

    @Override
    public int getItemCount() {
        return this.mCarList.size();
    }
}
