package com.example.robensoncadet_ev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar Pb;
    private Button Bt;
    private EditText edit1, edit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pb = (ProgressBar)findViewById(R.id.pb);
        Bt = (Button) findViewById(R.id.btn);
        edit1 = (EditText)findViewById(R.id.et1);
        edit2 = (EditText)findViewById(R.id.et2);
        Pb.setVisibility(View.INVISIBLE);

        Bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            Pb.setVisibility(View.VISIBLE);

        }


        @Override
        protected String doInBackground(String... strings) {
            for(int i =1; i<=10; i++)
            {
                try {
                    Thread.sleep(1000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //Finaliza mi tarea asincrona.
        @Override
        protected void onPostExecute(String s) {
            Pb.setVisibility(View.INVISIBLE);

            String nom = edit1.getText().toString();
            String pass = edit2.getText().toString();

            if(nom.equals("Android") && pass.equals("123"))
            {
                Intent i = new Intent(getBaseContext(), Menu_act.class);
                startActivity(i);
                return;
            }

            if(nom.equals("android") && pass.equals("123"))
            {
                Intent i = new Intent(getBaseContext(), Menu_act.class);
                startActivity(i);
                return;
            }

        }


    }

    // Tarea Pesada
    public void Hilo(View v)
    {
        for(int i = 1; i<=10; i++)
        {
            try {

                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}