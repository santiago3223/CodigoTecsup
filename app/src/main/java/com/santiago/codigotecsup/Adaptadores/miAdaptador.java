package com.santiago.codigotecsup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.santiago.codigotecsup.R;

import java.util.List;

public class miAdaptador extends BaseAdapter {
    public Context context;
    public int layout;
    public List<String> nombres;

    public miAdaptador(Context context, int layout, List<String> nombres) {
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return nombres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item,null);
        TextView tv = v.findViewById(R.id.textView);
        tv.setText(nombres.get(position));
        return v;
    }
}
