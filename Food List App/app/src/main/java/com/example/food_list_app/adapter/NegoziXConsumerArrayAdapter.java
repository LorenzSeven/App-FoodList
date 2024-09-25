package com.example.food_list_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food_list_app.R;
import com.example.food_list_app.oggetti.Negozio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class NegoziXConsumerArrayAdapter extends ArrayAdapter<Negozio> {

    static int totaleIngredientiUtente;

    public NegoziXConsumerArrayAdapter(Context context, int resource, ArrayList<Negozio> negozi) {
        super(context, resource, negozi);

    }

    public NegoziXConsumerArrayAdapter(Context context, int resource, ArrayList<Negozio> negozi, int totaleIngredientiUtente) {
        super(context, resource, negozi);
        NegoziXConsumerArrayAdapter.totaleIngredientiUtente = totaleIngredientiUtente;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = li.inflate(R.layout.lista_item_negozio_consumer, parent, false);

        RelativeLayout relativeLayout = contentView.findViewById(R.id.relativeLayoutNegozio);
        TableLayout tableLayout = contentView.findViewById(R.id.tableLayoutInfoNegozio);
        ImageView imageViewNegozio = contentView.findViewById(R.id.imageViewNegozio);
        TextView textViewNomeNegozio = contentView.findViewById(R.id.textViewNomeNegozio);
        TextView textViewIndirizzo = contentView.findViewById(R.id.textViewIndirizzo);
        TextView textViewCostoSpesa = contentView.findViewById(R.id.textViewCostoSpesa);
        TextView textViewDistanza = contentView.findViewById(R.id.textViewDistanza);
        TextView textViewIngredieniUtente = contentView.findViewById(R.id.textViewIngredientiUtente);


        Negozio tempNegozio = getItem(position);

        Glide.with(getContext()).load(tempNegozio.getImmagineNegozio()).into(imageViewNegozio);

        textViewNomeNegozio.setText(tempNegozio.getNome());
        textViewIndirizzo.setText(tempNegozio.getIndirizzo());
        textViewCostoSpesa.setText(String.format("%s€", tempNegozio.getPrezzoTotaleIngredienti()));

        BigDecimal bd = BigDecimal.valueOf(tempNegozio.getDistanza()).setScale(2, RoundingMode.HALF_UP);
        double newInput = bd.doubleValue();
        textViewDistanza.setText(String.format("%s km", newInput));

        textViewIngredieniUtente.setText(String.format( "%s/" +totaleIngredientiUtente +" ing.", tempNegozio.getIngredientiPresenti()));

        if (totaleIngredientiUtente == tempNegozio.getIngredientiPresenti()) {
            tableLayout.setBackgroundResource(R.drawable.border_green);
        } else tableLayout.setBackgroundResource(R.drawable.border_red);


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
