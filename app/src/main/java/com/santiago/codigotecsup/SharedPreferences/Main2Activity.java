package com.santiago.codigotecsup.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.santiago.codigotecsup.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                "Demo Preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Inicio Sesión",  true);
        editor.commit();

        boolean logeado = sharedPref.getBoolean("Inicio Sesión",false);
    }
}
