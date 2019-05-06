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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.santiago.codigotecsup.R;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class DemoRealm extends AppCompatActivity {
    FloatingActionButton fab;
    ListView lv;
    AdaptadorContenedores adapter;

    RealmResults<Contenedor> data;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_realm);
        fab = findViewById(R.id.fab_boton);
        lv = findViewById(R.id.list);
        realm = Realm.getDefaultInstance();
        data = realm.where(Contenedor.class).findAll();
        data.addChangeListener(new RealmChangeListener<RealmResults<Contenedor>>() {
            @Override
            public void onChange(RealmResults<Contenedor> contenedors) {
                adapter.notifyDataSetChanged();
            }
        });
        Log.d("data", data.size()+" ");
        adapter = new AdaptadorContenedores(this, data, R.layout.list_item_contenedor);
        lv.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertCreateContenedor("Crear Contenedor", "Ingrese nombre de contenedor");
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ActivityEntrada.class);
                i.putExtra("id", data.get(position).id);
                startActivity(i);
            }
        });

    }

    void CrearNuevoContenedor(String nombre){
        Contenedor c = new Contenedor(nombre);
        realm.beginTransaction();
        realm.copyToRealm(c);
        realm.commitTransaction();
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
                CrearNuevoContenedor(nombre);
            }
        });
        b.show();

    }
}
