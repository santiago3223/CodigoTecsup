package com.santiago.codigotecsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentExplicito extends AppCompatActivity {
    Button b;// declaramos el boton a usar
    EditText t;// declaramos el Edit Text a usar
    public static final int TEXT_REQUEST = 1;

    //Se llama al iniciar la aplicación
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamamos al metodo del padre
        setContentView(R.layout.activity_intent_explicito);// Setteamos layout
        setTitle("Ejemplo Intent Explicito"); // Cambiamos el titulo
        b = findViewById(R.id.boton); // Asignamos nuestro boton
        t = findViewById(R.id.texto); // Asignamos nuestro edit text

        //Asignamos el evento Click a nuestro boton
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//Metodo llamado al apretar el boton
                //Creamos un intent para cambiar de actividad
                Intent intent = new Intent(getApplicationContext(), IntentExplicitoSegundo.class);
                // a nuestro intent le agregamos un mensaje sacado de nuestro edittext
                intent.putExtra("message", t.getText().toString());
                //
                //startActivity(intent);
                startActivityForResult(intent,TEXT_REQUEST);
            }
        });

    }

    // Metodo que se llama al retornar de una actividad
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        //llamo al metodo del padre
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                //Obtengo mi respuesta de un extra
                String reply =
                        data.getStringExtra("respuesta");
                t.setText(reply);
            }
        }
    }
}
