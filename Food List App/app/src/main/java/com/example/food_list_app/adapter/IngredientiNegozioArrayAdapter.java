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

public class IngredientiNegozioArrayAdapter extends ArrayAdapter<Ingrediente>{
        Context context = null;

        public IngredientiNegozioArrayAdapter(Context context, int resource, ArrayList<Ingrediente> Ingredienti_sede){
            super(context, resource, Ingredienti_sede);
            this.context = context;
        }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentview = li.inflate(R.layout.lista_item_ingrediente_negozio, parent, false);

        TextView nome = contentview.findViewById(R.id.Textview_nome);
        TextView marca = contentview.findViewById(R.id.Textview_marca);
        TextView peso = contentview.findViewById(R.id.Textview_peso);
        TextView costo = contentview.findViewById(R.id.Textview_costo);


        Ingrediente ingr = getItem(position);
        nome.setText(ingr.getNome());
        marca.setText(ingr.getMarca());
        costo.setText(String.valueOf(ingr.getPrezzo())+"€");
        peso.setText(String.valueOf(ingr.getValore())+ingr.getUnitàMisura());


        return contentview;
    }
}
