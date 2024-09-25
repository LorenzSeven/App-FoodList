package com.example.food_list_app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.food_list_app.activity.utenteConsumer.ListaRicetteActivity;


import java.util.Objects;

public class SearchBar {
    private final Context context;
    private  final Activity activity;
    private EditText editTextSearchBar;
    private ImageButton imgBtnBack;


    //editTextIndirizzo
    private EditText editTextIndirizzo;

    public SearchBar(Context context, Activity activity, EditText editTextSearchBar, ImageButton imgBtnBack) {
        this.context = context;
        this.activity = activity;
        this.editTextSearchBar = editTextSearchBar;
        this.imgBtnBack = imgBtnBack;

        gestioneListenerSearchBar();
    }

    public SearchBar(Context context, Activity activity, EditText editTextIndirizzo) { //CarrelloActivity

        this.context = context;
        this.activity = activity;
        this.editTextSearchBar = editTextIndirizzo;

        gestioneListenerSearchBar();
    }


    private void gestioneListenerSearchBar() {
        focusChangeEditText(false);

        gestioneListenerImgBtnBack(); //listener imgBtn Back

        editTextSearchBar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                tastieraOnOff(hasFocus);
                Log.w("HomeAcitivty", "Focus -->" + hasFocus);
            }
        });

        editTextSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                focusChangeEditText(true);

                //on  tastiera pop up
                tastieraOnOff(true);

                Log.i("HomeActivity", "Click editText");
            }
        });


        if(imgBtnBack != null) {
            editTextSearchBar.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    // If the event is a key-down event on the "enter" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press

                        //editTextSearchBar.clearFocus();//?

                        startIntentPutExtra(); // controllo input editText e creazione Intent
                        tastieraOnOff(false); //tasstiera off
                        focusChangeEditText(false); //cambio focus

                        Toast.makeText(context, "Mamma Mia, it's Mario  ", Toast.LENGTH_SHORT).show();

                        return true;
                    }
                    return false;
                }
            });
        }
    }

    private void gestioneListenerImgBtnBack() {

        if (imgBtnBack != null) {
            imgBtnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    focusChangeEditText(false);

                    tastieraOnOff(false);  //off tastiera pop up
                }
            });
        }
    }

    private void startIntentPutExtra() {
        Intent intent = new Intent(context, ListaRicetteActivity.class);
        String input = String.valueOf(Objects.requireNonNull(editTextSearchBar).getText()); //fail-fast //input della bar search

        if (!input.equals("")) {
            String ricerca = String.valueOf(editTextSearchBar.getText());
            intent.putExtra("scelta", ricerca);
            intent.putExtra("from", "search");
            context.startActivity(intent);
        } else
            Toast.makeText(context, "Inserisci nome ricetta", Toast.LENGTH_SHORT).show();
    }

    private void focusChangeEditText(boolean focus) {
        editTextSearchBar.setText("");
        editTextSearchBar.setFocusable(focus);
        editTextSearchBar.setFocusableInTouchMode(focus);
        editTextSearchBar.requestFocus();
    }

    private void tastieraOnOff(boolean input) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (input) {
            imm.showSoftInput(editTextSearchBar, InputMethodManager.SHOW_IMPLICIT);

            if (imgBtnBack != null) {
                imgBtnBack.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }

        } else {
            imm.hideSoftInputFromWindow(editTextSearchBar.getWindowToken(), 0);
            if (imgBtnBack != null) {
                imgBtnBack.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }
    }
}
