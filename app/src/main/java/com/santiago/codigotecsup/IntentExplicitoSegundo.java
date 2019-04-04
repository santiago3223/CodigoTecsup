package com.santiago.codigotecsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentExplicitoSegundo extends AppCompatActivity {
    TextView textView;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicito_segundo);
        // Obtengo el intent enviado desde la actividad anterior
        Intent intent = getIntent();
        // Saco el extra llamano message
        Bundle bb = intent.getExtras();
        String message = bb.getString("message");

        textView = findViewById(R.id.texto1);
        textView.setText(message);


        b = findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creo un nuevo intent
                Intent replyIntent = new Intent();
                // pongo mi respuesta como extra
                replyIntent.putExtra("respuesta", "respuesta del segundo intent");
                //setteo el resultado y mi intent
                setResult(RESULT_OK, replyIntent);
                // cierro mi actividad
                finish();
            }
        });
    }
}
