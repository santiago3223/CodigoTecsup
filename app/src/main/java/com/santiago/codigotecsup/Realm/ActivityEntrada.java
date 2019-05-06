package com.santiago.codigotecsup.Realm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.santiago.codigotecsup.R;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;

public class ActivityEntrada extends AppCompatActivity {
    FloatingActionButton fab;
    ListView lv;
    AdaptadorEntrada adapter;

    RealmList<Entrada> data;
    Realm realm;
    Contenedor contenedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        int contenedor_id = 0;
        if(getIntent().getExtras() != null){
            contenedor_id = getIntent().getExtras().getInt("id");

        }

        fab = findViewById(R.id.fab_boton);
        lv = findViewById(R.id.list);
        realm = Realm.getDefaultInstance();
        contenedor = realm.where(Contenedor.class).equalTo("id",contenedor_id).findFirst();

        data = contenedor.getEntradas();
        data.addChangeListener(new RealmChangeListener<RealmList<Entrada>>() {
            @Override
            public void onChange(RealmList<Entrada> entradas) {
                adapter.notifyDataSetChanged();
            }
        });
        Log.d("data", data.size()+" ");
        adapter = new AdaptadorEntrada(this, data, R.layout.list_item_contenedor);
        lv.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertCreateContenedor("Crear Contenedor", "Ingrese nombre de contenedor");
            }
        });
    }

    void showAlertCreateContenedor(String tittle, String message){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(tittle);
        b.setMessage(message);

        View v = LayoutInflater.from(this).inflate(R.layout.crear_contenedor,null);
        b.setView(v);
        final EditText input = v.findViewById(R.id.edit_nombre);
        b.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre = input.getText().toString();
                CrearNuevaEntrada(nombre);
            }
        });
        b.show();
    }

    void CrearNuevaEntrada(String nombre){
        Entrada c = new Entrada(nombre);
        realm.beginTransaction();
        realm.copyToRealm(c);

        contenedor.getEntradas().add(c);
        realm.commitTransaction();
    }
}
