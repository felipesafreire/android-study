package com.felipesafreire.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;

import com.felipesafreire.carros.R;
import com.felipesafreire.carros.adapter.CarListAdapter;
import com.felipesafreire.carros.data.CarMock;
import com.felipesafreire.carros.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder nViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarMock carMock = new CarMock();
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        this.nViewHolder.recyclerCars = this.findViewById(R.id.recycler_cars);

        CarListAdapter carListAdapter = new CarListAdapter(carList);
        this.nViewHolder.recyclerCars.setAdapter(carListAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.nViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);

    }

    private static class ViewHolder{
        RecyclerView recyclerCars;
    }

}
