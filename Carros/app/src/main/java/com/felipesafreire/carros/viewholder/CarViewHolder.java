package com.felipesafreire.carros.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.felipesafreire.carros.R;
import com.felipesafreire.carros.entities.Car;
import com.felipesafreire.carros.listener.OnListClickInteractionListener;

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mTextModel = itemView.findViewById(R.id.text_model);
    }

    public void bindData(final Car car, final OnListClickInteractionListener listener){
        this.mTextModel.setText(car.model);
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(car.id);
            }
        });
    }
}
