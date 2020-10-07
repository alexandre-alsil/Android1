package com.allone.Alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.SoftReference;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool, precoGasolina;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.textAlcool);
        precoGasolina = findViewById(R.id.textGasolina);
        textoResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view) {

        String precoAlcoolCal = precoAlcool.getText().toString();
        String precoGasolinaCal = precoGasolina.getText().toString();

        Boolean validar = validarCampos(precoAlcoolCal, precoGasolinaCal);

        if(validar){

            Double valorAlcool = Double.parseDouble(precoAlcoolCal);
            Double valorGasolina = Double.parseDouble(precoGasolinaCal);

            Double resultado = valorAlcool/valorGasolina;

            if (resultado>=0.7){
                textoResultado.setText("Abasteça com Gasolina");
            } else {
                textoResultado.setText("Abasteça com Álcool");
            }

        } else {
            textoResultado.setText("Preencha todos os campos para calcular!");
        }

    }


    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }

        return camposValidados;

    }

}
