package com.desafios.desafio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn,btn2;
    private ImageView img;
    private String valida;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacionamos con el XML
        img = (ImageView) this.findViewById(R.id.imagengrande);
        btn = (Button) this.findViewById(R.id.btn);
        //Añadimos el Listener Boton
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent para llamar a la Camara
                dispatchTakePictureIntent();
                valida="ok";


            }
        });

        btn2 = (Button) this.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (valida == "ok") {
                    intentExample();

                } else {
                    Toast.makeText(MainActivity.this, "Es Obligatorio la fotografía ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


        private void dispatchTakePictureIntent () {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                img.setImageBitmap(imageBitmap);

            }
        }

        private void intentExample () {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("BOOLEAN", true);
            intent.putExtra("String", "http://www.desafiolatam.com/");
            startActivity(intent);


        }

    }


