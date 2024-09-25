package com.example.food_list_app.activity.utenteAzienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ingrediente;

public class AggiungiIngredientiNegozioActivity extends AppCompatActivity implements SyncCall {

    Button bottoneIngrediente = null;
    EditText EditTextNome = null;
    EditText EditTextMarca = null;
    EditText EditTextPeso = null;
    EditText EditTextCosto = null;

    EditText EditTextMisura = null;
    WebCtrl webCtrl;

    Ingrediente ingCreato = new Ingrediente(0,"", "", 0, "");

    int idNegozio;
    float peso, costo;
    String misura;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_ingredienti_negozio);
        bottoneIngrediente = findViewById(R.id.BottoneAggiungiIngrediente);
        EditTextNome = findViewById(R.id.EditTextNome);
        EditTextMarca = findViewById(R.id.EditTextMarca);
        EditTextPeso = findViewById(R.id.EditTextPeso);
        EditTextCosto = findViewById(R.id.EditTextCosto);
        EditTextMisura = findViewById(R.id.EditTextMisura);

        webCtrl = WebCtrl.getINSTACE(this);


        bottoneIngrediente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AggiungiIngredientiNegozioActivity.this, VisualizzaIngredientiNegozioActivity.class);
                EditText[] lista = {EditTextNome, EditTextMarca, EditTextPeso, EditTextCosto};
                if (!controlloCampiEditText(lista)) return;
                ; //se il campo vuoto esci

                String nome = EditTextNome.getText().toString();
                String marca = EditTextMarca.getText().toString();
                String pesotext = EditTextPeso.getText().toString();
                String costotext = EditTextCosto.getText().toString();
                misura = EditTextMisura.getText().toString();



                try {
                    peso = Float.parseFloat(pesotext);
                    costo = Float.parseFloat(costotext);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                ingCreato.setNome(nome);
                ingCreato.setMarca(marca);
                ingCreato.setPrezzo(costo);
                ingCreato.setValore(peso);
                ingCreato.setUnitàMisura(misura);

                Ingrediente i = new Ingrediente(nome, marca);
                webCtrl.addIngrediente(i);
                //webCtrl.getUltimoIngrediente();

                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    idNegozio = bundle.getInt("id negozio");
                    webCtrl.getNegozio(idNegozio);
                    intent.putExtra("id negozio", idNegozio);

                } else
                    Toast.makeText(AggiungiIngredientiNegozioActivity.this, "getIntent ID negozio == null", Toast.LENGTH_SHORT).show();




            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneBarMenuNavigazione(R.id.itemNegozi); //listener bar menu azienda
    }

    private boolean controlloCampiEditText(EditText[] listaEditTexts) {
        for (EditText e :
                listaEditTexts) {
            if ("".equals(e.getText().toString())) {
                Toast.makeText(AggiungiIngredientiNegozioActivity.this, "Campi non riempiti!! ", Toast.LENGTH_LONG).show();
                return false;
            }

        }
        return true;
    }


    private void gestioneBarMenuNavigazione(int itemSelected) {
        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity

    }

    @Override
    public void handleAsync(Object obj) {
        if(obj instanceof Ingrediente) {
            ingCreato.setId(((Ingrediente) obj).getId());
            webCtrl.associaNegozio(ingCreato.getId(), ingCreato.getValore(), ingCreato.getPrezzo(), ingCreato.getUnitàMisura(), idNegozio);
            startActivity(intent);
        }
    }
}
