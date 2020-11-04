package com.example.robensoncadet_ev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Creditos;

public class Prestamos_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spin1 = (Spinner)findViewById(R.id.spinClientes);
        spin2 = (Spinner)findViewById(R.id.spinCreditos);
        text = (TextView)findViewById(R.id.tv);


        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void CalcularPrestamo( View v) {
        String cliente = spin1.getSelectedItem().toString();
        String creditos = spin2.getSelectedItem().toString();

        Creditos cred = new Creditos();

        int resultCredHipotecario = 750000 + cred.getCreditoHipotecario();
        int resultcredAuto = 900000 + cred.getCreditoAutomotriz();


        if (cliente.equals("Axel") && creditos.equals("CreditoHipotecario")) {
            text.setText("El Saldo final de " + cliente + " es: " + resultCredHipotecario);
        }

        if (cliente.equals("Roxana") && creditos.equals("CreditoAutomotriz")) {
            text.setText("El Saldo final de " + cliente + " es: " + resultcredAuto);
        }
    }

   public void CalcularDeudas(View v)
   {
       String cliente = spin1.getSelectedItem().toString();
       String creditos = spin2.getSelectedItem().toString();

       Creditos cred = new Creditos();

       int resultCredHipotecario = 750000 + cred.getCreditoHipotecario();
       int resultcredAuto = 900000 + cred.getCreditoAutomotriz();

       int cuotasHipotecario = resultCredHipotecario / 12;
       int cuotasAutomotriz = resultcredAuto /8;

       if (cliente.equals("Axel") && creditos.equals("CreditoHipotecario")) {
           text.setText("El Saldo final de " + cliente + " es: " + cuotasHipotecario);
       }

       if (cliente.equals("Roxana") && creditos.equals("CreditoAutomotriz")) {
           text.setText("El Saldo final de " + cliente + " es: " + cuotasAutomotriz);
       }
   }
}