package com.example.berna.examenandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button toast;
    private Button count;
    private Button zero;
    SharedPreferences pref;
    private int compte = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getApplicationContext().getSharedPreferences("Pref",0);
        final TextView txt = findViewById(R.id.textView);
        txt.setText(""+pref.getInt("comp",0));

        toast = (Button) findViewById(R.id.toast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tos = Toast.makeText(getApplicationContext(),"El nombre es: " + compte, Toast.LENGTH_SHORT);
                tos.setGravity(Gravity.CENTER, 0, 0);
                tos.show();
            }
        });

        count = (Button) findViewById(R.id.count);
        count.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                compte++;
                pref.edit().putInt("comp",compte).commit();
                txt.setText(""+pref.getInt("comp",0));
            }
        });

        zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                compte=0;
                pref.edit().putInt("comp",compte).commit();
                txt.setText(""+pref.getInt("comp",0));
            }
        });

    }
}
