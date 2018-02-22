package com.example.cabo.juegopulso;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public TextView cinta,numal;
    public Button btnpul;
    public double random = 1;
    public double random3;
    public Handler handler = new Handler();
    DecimalFormat df = new DecimalFormat("#.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cinta = (TextView) findViewById(R.id.txtcinta);
        numal = (TextView) findViewById(R.id.txtnumaleatorio);
        btnpul = (Button) findViewById(R.id.btnpulsar);
        random3 = (Math.random() * 2.6) + 1;

        numal.setText(df.format(random3));
        handler.postDelayed(runnable, 100);
        //inicia();

        btnpul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pulsar();
            }
        });



    }

    public void setea(){
        DecimalFormat df = new DecimalFormat("#.0");
        cinta.setText(df.format(random));
        double temp = Double.parseDouble(cinta.getText().toString());
        if(temp == 3.0){
            random = 1;
        }
        random = random+.1;

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
      /* do what you need to do */
            setea();
      /* and here comes the "trick" */
            handler.postDelayed(this, 100);
        }
    };

    /*private final int interval = 3000; // 1 Second
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        public void run() {
            Toast.makeText(MainActivity.this, "C'Mom no hands!", Toast.LENGTH_SHORT).show();
        }
    };

    public void inicia(){
        while(true) {
            handler.postAtTime(runnable, 2000);
            handler.postDelayed(runnable, interval);
            if(pulsar()==true){
                break;
            }
        }
    }*/



    public void pulsar(){
        double temporal = Double.parseDouble(cinta.getText().toString());
        double tempora2 = Double.parseDouble(numal.getText().toString());

        if(temporal == tempora2){
            Toast.makeText(MainActivity.this,"Buen Pulso!", Toast.LENGTH_LONG).show();

        }



    }
}
