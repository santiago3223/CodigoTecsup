package com.santiago.codigotecsup.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AutoSQLHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "AutosDb" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    public AutoSQLHelper(Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE AUTO(" +
                " _id INTEGER PRIMARY KEY," +
                " auto_marca TEXT , " +
                " auto_color TEXT, " +
                " auto_placa TEXT)" );


        Log.i(this.getClass().toString(), "Tabla HIPOTECA creada");

        /*
         * Insertamos datos iniciales
         */
        db.execSQL("INSERT INTO AUTO(_id, auto_marca, auto_color, auto_placa)" +
                " VALUES(1,'Mercedes', 'Negro', 'XQWE')");

        Log.i(this.getClass().toString(), "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "AUTO");

        // Create a new one.
        onCreate(db);
    }
}
