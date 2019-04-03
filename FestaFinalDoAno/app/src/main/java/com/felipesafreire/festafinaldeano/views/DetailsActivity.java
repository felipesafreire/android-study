package com.felipesafreire.festafinaldeano.views;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.felipesafreire.festafinaldeano.R;
import com.felipesafreire.festafinaldeano.constants.FimDeAnoConstants;
import com.felipesafreire.festafinaldeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder nViewHolder = new ViewHolder();
    private SecurityPreferences nSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.nSecurityPreferences = new SecurityPreferences(this);

        this.nViewHolder.checkParticipate = findViewById(R.id.check_participate);

        this.nViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.check_participate) {
            if (this.nViewHolder.checkParticipate.isChecked()) {
                this.nSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRM_WILL_GO);
            } else {
                this.nSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRM_WONT_GO);
            }
        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(FimDeAnoConstants.PRESENCE);
            if (presence.equals(FimDeAnoConstants.CONFIRM_WILL_GO)) {
                this.nViewHolder.checkParticipate.setChecked(true);
            } else {
                this.nViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }

}
