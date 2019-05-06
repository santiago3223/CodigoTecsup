package com.santiago.codigotecsup.Realm;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MiApp extends Application {
    public static AtomicInteger EntradaId = new AtomicInteger();
    public static AtomicInteger ContenedorId = new AtomicInteger();
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance();

        EntradaId = getIdByTable(realm, Entrada.class);
        ContenedorId = getIdByTable(realm, Contenedor.class);
        realm.close();
    }

    <T extends RealmObject> AtomicInteger getIdByTable(Realm realm,Class<T> object){
        RealmResults<T> results = realm.where(object).findAll();
        return (results.size()>0)? new AtomicInteger(results.max("id").
                intValue()): new AtomicInteger();
    }
}
