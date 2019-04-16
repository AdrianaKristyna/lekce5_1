package com.example.adriana.lekce5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {
        static String folder= "folderOfString";
        private SharedPreferences prefs;
        static String dataNameLogin ="login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        prefs=this.getSharedPreferences(folder, Context.MODE_PRIVATE);

        final EditText input=findViewById(R.id.input);
        TextView inputText =findViewById(R.id.inputText);
        Button save=findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text= input.getText().toString();
                prefs.edit().putString(dataNameLogin, text).apply();//vlozime do prefs text z input
            }
        });
        input.setText(prefs.getString(dataNameLogin,""));
        inputText.setText(prefs.getString(ThrActivity.dataNameInput,""));
    }
}
