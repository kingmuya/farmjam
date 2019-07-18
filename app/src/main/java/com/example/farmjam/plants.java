package com.example.farmjam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class plants extends AppCompatActivity {

    ImageView dairyfarmView,chickenView,fishView,greenView,floriView,oreliView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        dairyfarmView = findViewById(R.id.dfarrm);
        chickenView = findViewById(R.id.chickfarm);
        fishView = findViewById(R.id.fishfarm);
        greenView = findViewById(R.id.greenfarm);
        floriView = findViewById(R.id.agro);
       //oreliView = findViewById(R.id.agro2);

        dairyfarmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dairyfarm = new Intent(getApplication(),DairyFarm.class);
                startActivity(dairyfarm);

                chickenView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent chickenfarm = new Intent(getApplication(),Chick.class);
                        startActivity(chickenfarm);
                    }
                });

                fishView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fishfarm = new Intent(getApplication(),Fish.class);
                        startActivity(fishfarm);
                    }
                });

                greenView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent greenhousefarm = new Intent(getApplication(),greenhouse.class);
                        startActivity(greenhousefarm);
                    }
                });

                floriView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent floriculturefarm = new Intent(getApplication(),floriculture.class);
                        startActivity(floriculturefarm);

                    }
                });

              /*  oreliView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent oreliculturefarm = new Intent(getApplication(),oreliculture.class);
                        startActivity(oreliculturefarm);
                    }
                });

*/

            }
        });


    }
}
