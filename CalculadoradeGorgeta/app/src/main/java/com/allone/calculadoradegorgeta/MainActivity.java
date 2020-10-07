package com.allone.calculadoradegorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valorConta;
    private TextView valorPercent, valorGorjeta, valorTotal;
    private SeekBar seekGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorConta      = findViewById(R.id.txtViewValorConta);
        valorPercent    = findViewById(R.id.txtViewPercent);
        valorGorjeta    = findViewById(R.id.txtViewValorGorjeta);
        valorTotal      = findViewById(R.id.txtViewValorTotal);
        seekGorjeta     = findViewById(R.id.seekBarGorjeta);

        //listener
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                valorPercent.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){

        String valorContaTxt = valorConta.getText().toString();

        if((valorContaTxt == null) || (valorContaTxt.equals(""))){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite o valor da conta",
                    Toast.LENGTH_LONG
            ).show();

        } else {

            double valorContaDB     = Double.parseDouble(valorContaTxt);

            double valorGorjetaDB   = valorContaDB * (porcentagem/100);
            double valorTotalDB     = valorGorjetaDB + valorContaDB;

            valorGorjeta.setText("R$ " + Math.round(valorGorjetaDB ) + ",00");
            valorTotal.setText("R$ " + valorTotalDB);


        }

    }



}
