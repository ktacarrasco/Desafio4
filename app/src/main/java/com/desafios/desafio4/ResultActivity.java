package com.desafios.desafio4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private Button btnURL,btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btnURL= (Button) this.findViewById(R.id.btnAbrirWeb);

                btnURL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "http://www.desafiolatam.com/";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        Toast.makeText(ResultActivity.this, "Validación OK enviando a DesafioLatam.com  ", Toast.LENGTH_SHORT).show();



                    }
                });

                btnShare=(Button) this.findViewById(R.id.btnCompartir);

                btnShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        share(v);
                        Toast.makeText(ResultActivity.this, "Validación OK compartir ", Toast.LENGTH_SHORT).show();

                    }
                });

        }

    public void share(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "¡Hola! te comparto : " );
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }
    }


