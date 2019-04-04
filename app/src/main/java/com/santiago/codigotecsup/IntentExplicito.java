package com.santiago.codigotecsup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentExplicito extends AppCompatActivity {
    Button b;
    EditText t;
    public static final int TEXT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicito);
        setTitle("Ejemplo Intent Explicito");
        b = findViewById(R.id.boton);
        t = findViewById(R.id.texto);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntentExplicitoSegundo.class);
                intent.putExtra("message", t.getText().toString());
                startActivityForResult(intent,TEXT_REQUEST);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra("respuesta");
                t.setText(reply);
            }
        }
    }
}
