package com.anapaulagomes.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

    private EditText cidadeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cidadeEditText = (EditText) findViewById(R.id.cidadeEditText);

        Button pesquisarButton = (Button) findViewById(R.id.pesquisarButton);
        pesquisarButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cidadeEditText != null && cidadeEditText.getText() != null && cidadeEditText.getText().toString().length() > 0) {
                    pesquisarTempoCidade();
                } else {
                    Toast.makeText(getApplicationContext(), "Cidade não preenchida!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void pesquisarTempoCidade() {
        //Método que irá efetuar a busca

        //Chama outra Activity passando o nome da cidade
        Intent i = new Intent(getApplicationContext(), ResultadoTempoActivity.class);
        i.putExtra("nomeCidade", cidadeEditText.getText().toString());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
