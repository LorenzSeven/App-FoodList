package com.example.food_list_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food_list_app.R;
import com.example.food_list_app.oggetti.Ricetta;

import java.util.ArrayList;
import java.util.Objects;

public class RicetteArrayAdapter extends ArrayAdapter<Ricetta> {

    public RicetteArrayAdapter(Context context, int resource, ArrayList<Ricetta> preferiti) {
        super(context, resource, preferiti);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = li.inflate(R.layout.lista_item_piatto, parent, false);
        ImageView fotoRicettaImgView = contentView.findViewById(R.id.ImageViewPiatto);
        TextView titoloRicettaTextView = contentView.findViewById(R.id.TextViewNomePiatto);
        TextView tempoPrepTextView = contentView.findViewById(R.id.TextViewTempo);
        TextView diffTextView = contentView.findViewById(R.id.TextViewDif);
        TextView textViewNazional = contentView.findViewById(R.id.textViewNazionalità);

        Ricetta tempR = getItem(position);

        String uri = Objects.requireNonNull(tempR.getImmagine());

        Glide.with(getContext()).load(uri).into(fotoRicettaImgView);


        titoloRicettaTextView.setText(tempR.getNome());
        tempoPrepTextView.setText(tempR.getTempo_preparazione());
        diffTextView.setText(tempR.getDifficoltà());
        textViewNazional.setText(tempR.getNazionalità());

        return contentView;
    }
}
