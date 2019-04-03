package com.felipesafreire.festafinaldeano.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.felipesafreire.festafinaldeano.R;
import com.felipesafreire.festafinaldeano.constants.FimDeAnoConstants;
import com.felipesafreire.festafinaldeano.util.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder nViewHolder = new ViewHolder();
    private SecurityPreferences nSecurityPreferences;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nViewHolder.textToday = findViewById(R.id.text_today);
        this.nViewHolder.textDaysLeft = findViewById(R.id.text_day_left);
        this.nViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.nViewHolder.buttonConfirm.setOnClickListener(this);

        this.nSecurityPreferences = new SecurityPreferences(this);

        this.nViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeftToEndOfYear()), getString(R.string.dias));
        this.nViewHolder.textDaysLeft.setText(daysLeft);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPreferences();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirm) {
            String presence = this.nSecurityPreferences.getStoreString(FimDeAnoConstants.PRESENCE);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(FimDeAnoConstants.PRESENCE, presence);
            startActivity(intent);
        }
    }

    private int getDaysLeftToEndOfYear(){
        Calendar CalendarToDay = Calendar.getInstance();
        int today = CalendarToDay.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay =  Calendar.getInstance();
        int dayDecember31 = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);
        return  dayDecember31 - today;
    }

    private void verifyPreferences() {
        String preference = this.nSecurityPreferences.getStoreString(FimDeAnoConstants.PRESENCE);
        if (preference.equals("")) {
            this.nViewHolder.buttonConfirm.setText(R.string.nao_confirmado);
        } else if (preference.equals(FimDeAnoConstants.CONFIRM_WILL_GO)) {
            this.nViewHolder.buttonConfirm.setText(R.string.sim);
        } else {
            this.nViewHolder.buttonConfirm.setText(R.string.nao);
        }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }

}
