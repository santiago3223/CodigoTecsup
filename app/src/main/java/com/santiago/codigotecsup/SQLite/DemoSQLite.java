package com.santiago.codigotecsup.SQLite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.santiago.codigotecsup.R;

public class DemoSQLite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_sqlite);
        AutoSQLHelper dbHelper = new AutoSQLHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();

        dbHelper.getReadableDatabase();
        Cursor cursor=db.query("AUTO", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Log.d("db",cursor.getString(1));
        }

    }
}
