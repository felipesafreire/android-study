package com.felipesafreire.festafinaldeano.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;
    private static final String NOME_SHARED_PREFERENCES = "FimDeAno";

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(this.NOME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoreString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

}
