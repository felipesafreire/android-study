package com.felipesafreire.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.felipesafreire.carros.R;
import com.felipesafreire.carros.adapter.CarListAdapter;
import com.felipesafreire.carros.constants.CarroContants;
import com.felipesafreire.carros.data.CarMock;
import com.felipesafreire.carros.entities.Car;
import com.felipesafreire.carros.listener.OnListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder nViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mContext = this;

        CarMock carMock = new CarMock();
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        this.nViewHolder.recyclerCars = this.findViewById(R.id.recycler_cars);

        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarroContants.CARRO_ID, id);

                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        };

        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.nViewHolder.recyclerCars.setAdapter(carListAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.nViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);

    }

    private static class ViewHolder{
        RecyclerView recyclerCars;
    }

}
