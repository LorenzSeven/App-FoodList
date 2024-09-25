package com.example.food_list_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.food_list_app.R;
import com.example.food_list_app.oggetti.Ingrediente;

import java.util.ArrayList;

public class IngredientiDescrizionePiattoArrayAdapter extends ArrayAdapter<Ingrediente>
{
    Context ctx = null;

    public IngredientiDescrizionePiattoArrayAdapter(Context context, int resource, ArrayList<Ingrediente> ingredienti){
        super(context, resource, ingredienti);
        ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentview = li.inflate(R.layout.lista_item_ingredienti_descrizione_piatto, parent, false);

        TextView nome = contentview.findViewById(R.id.textView_ingrediente_descr_piatto);
        TextView valore = contentview.findViewById(R.id.textView_valore_descr_piatto);
        TextView peso = contentview.findViewById(R.id.textView_peso_descr_piatto);


        Ingrediente ingr = getItem(position);
        String valore_testo = String.valueOf(Math.round(ingr.getValore()));
        nome.setText(ingr.getNome());
        if (valore_testo.equals("0"))
        {
            valore_testo = "";
        }
        valore.setText(valore_testo);
        peso.setText(ingr.getUnitàMisura());

        return contentview;
    }
}
