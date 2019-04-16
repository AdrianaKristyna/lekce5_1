package com.example.adriana.lekce5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.orhanobut.hawk.Hawk;

public class ThrActivity extends AppCompatActivity {


    public static String dataNameInput ="input";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);
        Hawk.init(this).build();


        final EditText input=findViewById(R.id.input);
        Button save=findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ukladamHodnotu=input.getText().toString();
                Hawk.put(dataNameInput, ukladamHodnotu);
            }
        });

        String UlozenaHodnota = Hawk.get(dataNameInput);
        input.setText(UlozenaHodnota);
    }
}
