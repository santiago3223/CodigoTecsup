package com.santiago.codigotecsup.Realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.santiago.codigotecsup.R;

import java.util.List;

public class AdaptadorEntrada extends BaseAdapter {
    Context context;
    List<Entrada> datos;
    int layout;

    public AdaptadorEntrada(Context context, List<Entrada> datos, int layout) {
        this.context = context;
        this.datos = datos;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdaptadorEntrada.ViewHolder vh;
        if(convertView== null){
            convertView = LayoutInflater.from(context).inflate(layout,null);
            vh = new AdaptadorEntrada.ViewHolder();
            vh.titulo = convertView.findViewById(R.id.titulo);
            vh.hijos = convertView.findViewById(R.id.hijos);

            convertView.setTag(vh);
        }else{
            vh = (AdaptadorEntrada.ViewHolder) convertView.getTag();
        }

        vh.titulo.setText(datos.get(position).getDescripcion());
        vh.hijos.setText(datos.get(position).getF_creacion().toString());


        return convertView;
    }

    public class ViewHolder{
        TextView titulo;
        TextView hijos;


    }

}
