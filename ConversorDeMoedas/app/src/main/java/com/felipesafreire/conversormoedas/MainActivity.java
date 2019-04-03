package com.felipesafreire.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder nViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nViewHolder.editValue = findViewById(R.id.edit_value);
        this.nViewHolder.textDolar = findViewById(R.id.text_dollar);
        this.nViewHolder.textEuro = findViewById(R.id.text_euro);
        this.nViewHolder.buttonCalculator = findViewById(R.id.button_calculate);

        this.nViewHolder.buttonCalculator.setOnClickListener(this);
        this.clearValues();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_calculate) {
            Double value = Double.valueOf(this.nViewHolder.editValue.getText().toString());
            this.nViewHolder.textDolar.setText(String.format("%.2f", value * 3));
            this.nViewHolder.textEuro.setText(String.format("%.2f", value * 4));
        }
    }

    private void clearValues() {
        this.nViewHolder.textDolar.setText("");
        this.nViewHolder.textEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculator;
    }

}
