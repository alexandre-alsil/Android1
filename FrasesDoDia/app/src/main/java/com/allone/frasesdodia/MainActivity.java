package com.allone.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){

        String[] frases = {
                "O importante não é vencer todos os dias, mas lutar sempre. Waldemar Valle Martins",
                "Maior que a tristeza de não haver vencido é a vergonha de não ter lutado! Rui Barbosa",
                "É melhor conquistar a si mesmo do que vencer mil batalhas. Buda",
                "Quem ousou conquistar e saiu pra lutar, chega mais longe! Charlie Brown Jr",
                "Enquanto houver vontade de lutar haverá esperança de vencer. Santo Agostinho",
                "Difícil é ganhar um amigo em uma hora; fácil é ofendê-lo em um minuto. Provérbio Chinês"
        };

        int numero = new Random().nextInt(6);

        TextView texto = findViewById(R.id.textoFrase);

        texto.setText( frases[numero] );

    }

}
