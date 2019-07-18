package com.example.farmjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DairyFarm extends AppCompatActivity {
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_farm);
        search = findViewById(R.id.btnsearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dairyfarm = new Intent(getApplication(),Dairy2.class);
                startActivity(dairyfarm);

            }
        });
    }
}

