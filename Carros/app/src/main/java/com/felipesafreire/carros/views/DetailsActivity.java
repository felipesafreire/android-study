package com.felipesafreire.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.felipesafreire.carros.R;
import com.felipesafreire.carros.constants.CarroContants;
import com.felipesafreire.carros.data.CarMock;
import com.felipesafreire.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder nViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mCarMock = new CarMock();

        this.nViewHolder.textModel = findViewById(R.id.text_model);
        this.nViewHolder.textHorsePower = findViewById(R.id.text_horse);
        this.nViewHolder.textPrice = findViewById(R.id.text_price);

        this.getDataFromActivity();
        this.setData();

    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            this.mCar = this.mCarMock.get(extras.getInt(CarroContants.CARRO_ID));
        }
    }

    private void setData(){
        this.nViewHolder.textModel.setText(this.mCar.model);
        this.nViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.nViewHolder.textPrice.setText(String.valueOf(this.mCar.price));
    }

    private static class ViewHolder {
        TextView textModel;
        TextView textHorsePower;
        TextView textPrice;
    }
}
