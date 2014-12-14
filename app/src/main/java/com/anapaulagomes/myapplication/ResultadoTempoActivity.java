package com.anapaulagomes.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class ResultadoTempoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_tempo);

        if (savedInstanceState == null) {
            //Recupera o nome da cidade passado pela intent da activity anterior
            Intent i = getIntent();
            String nomeCidade = i.getStringExtra("nomeCidade");

            //Passando o nome da cidade para a tela
            TextView nomeCidadeTextView = (TextView) findViewById(R.id.cidadeInformadaTextView);
            nomeCidadeTextView.setText(nomeCidade);

            

        }
    }
}
