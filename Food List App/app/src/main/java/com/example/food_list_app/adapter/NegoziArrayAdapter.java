package com.example.food_list_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food_list_app.oggetti.Negozio;
import com.example.food_list_app.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class NegoziArrayAdapter extends ArrayAdapter<Negozio> {



    public NegoziArrayAdapter(Context context, int resource, ArrayList<Negozio> negozi) {
        super(context, resource, negozi);

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = li.inflate(R.layout.lista_item_negozio_azienda, parent, false);
        ImageView fotoNegozioImgView = contentView.findViewById(R.id.ImageViewNegozio);
        TextView nomeAziendaTextView = contentView.findViewById(R.id.TextViewNomeNegozio);
        TextView indirizzoNegozioTextView = contentView.findViewById(R.id.TextViewIndirizzo);
        TextView textViewOre = contentView.findViewById(R.id.TextViewOre);

        Negozio tempNegozio = getItem(position);

        Glide.with(getContext()).load(tempNegozio.getImmagineNegozio()).into(fotoNegozioImgView);

        nomeAziendaTextView.setText(tempNegozio.getNome());
        indirizzoNegozioTextView.setText(tempNegozio.getIndirizzo());

        textViewOre.setText(tempNegozio.getOrari());



        return contentView;
    }
}
        /*
        nomeNegozioTextView.setText(temp.getNomeNegozio());
        indirizzoNegozioTextView.setText(temp.getIndirizzoNegozio());
        distanzaNegozioTextView.setText(temp.getDistanzaNegozio());
        totaleNegozioTextView.setText(temp.getTotaleNegozio());
        ingredientimancantiNegozioTestoTextView.setText(temp.getIngredientiMancantiNegozio());
        ingredientimancantiNegozioNumeroTextView.setText(temp.getNumeroingredientiMancantiNegozio());
        ingredientimancantiNegzioNomeTextView.setText(temp.getListaIngredientiMancanti());
        immagineNegozioImageView.setImageResource(temp.getImmagineNegozio());

        TextView lun = contentView.findViewById(R.id.lunedì);
        TextView mar = contentView.findViewById(R.id.martedì);
        TextView mer = contentView.findViewById(R.id.mercoledì);
        TextView gio = contentView.findViewById(R.id.giovedì);
        TextView ven = contentView.findViewById(R.id.venerdì);
        TextView sab = contentView.findViewById(R.id.sabato);
        TextView dom = contentView.findViewById(R.id.domenica);

        lun.setText(temp.getLunediNegozio());
        mar.setText(temp.getMartediNegozio());
        mer.setText(temp.getMercolediNegozio());
        gio.setText(temp.getGiovediNegozio());
        ven.setText(temp.getVenerdiNegozio());
        sab.setText(temp.getSabatoNegozio());
        dom.setText(temp.getDomenicaNegozio());

        */

        /*int num_i_m = Integer.parseInt(ingredientimancantiNegozioNumeroTextView.getText().toString());

        if (num_i_m >0)
        {
            bordoNegozioBoarder.setBackgroundResource(R.drawable.bordo_rosso);
            contenitore_nomi_ingr_manc.setBackgroundResource(R.drawable.bordo_rosso);
        }
        else if (num_i_m == 0)
        {
            bordoNegozioBoarder.setBackgroundResource(R.drawable.bordo_verde);
            contenitore_nomi_ingr_manc.setBackgroundResource(R.drawable.bordo_verde);
        }
        bordoNegozioBoarder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (num_i_m>0)
                {
                    if (contenitore_o_n.getVisibility() == View.GONE)
                    {
                        contenitore_o_n.setVisibility(View.VISIBLE);
                        contenitore_nomi_ingr_manc.setVisibility(View.VISIBLE);
                    }
                    else if (contenitore_o_n.getVisibility() == View.VISIBLE)
                    {
                        contenitore_o_n.setVisibility(View.GONE);
                        contenitore_nomi_ingr_manc.setVisibility(View.GONE);
                    }
                }
                if (num_i_m == 0)
                {
                    if (contenitore_o_n.getVisibility() == View.GONE)
                    {
                        contenitore_o_n.setVisibility(View.VISIBLE);
                    }
                    else if (contenitore_o_n.getVisibility() == View.VISIBLE)
                    {
                        contenitore_o_n.setVisibility(View.GONE);
                    }
                }
            }
        });

        return contentView;
    }
}*/
