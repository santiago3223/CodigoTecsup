package com.santiago.codigotecsup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemo extends AppCompatActivity {

    GridView gv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);
        gv = (GridView) findViewById(R.id.gv);

        List<String> nombres = new ArrayList<String>();
        nombres.add("Santiago");
        nombres.add("Leo");
        nombres.add("Willy");

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        miAdaptador adapter = new miAdaptador(this, android.R.layout.simple_list_item_1, nombres);

        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
