package com.example.food_list_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.food_list_app.R;
import com.example.food_list_app.oggetti.Ingrediente;

import java.util.ArrayList;


public class CarrelloArrayAdpter extends ArrayAdapter<Ingrediente> {
    Context context = null;

    public CarrelloArrayAdpter(Context context, int resource, ArrayList<Ingrediente> ingredienti) {
        super(context, resource, ingredienti);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = li.inflate(R.layout.lista_item_ingrediente_carrello_checkbox, parent, false);

        TextView nometextviewingrediente = contentView.findViewById(R.id.TextViewNomeIngrediente);

        CheckBox checkBox = contentView.findViewById(R.id.CheckboxIngrFalse);
        Ingrediente ingr = getItem(position);
        nometextviewingrediente.setText(ingr.getNome());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(!checkBox.isChecked()) ingr.setIsChecked(false);
                else if(checkBox.isChecked()) ingr.setIsChecked(true);
            }
        });

        return contentView;
    }
}