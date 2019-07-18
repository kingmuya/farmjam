package com.example.farmjam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Fact extends AppCompatActivity {

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        //Initializing View variables
        mTextView = (TextView) findViewById(R.id.infoTextView);
        mButton = (Button) findViewById(R.id.factButton);

        //Display another fun fact after clicking the button
        View.OnClickListener listener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = "";
                String[] facts = {
                        "Agriculture in Kenya dominates 15-17% of kenya's total land",
                        "75% of Kenyans make their living by farming",
                        "Agriculture is the largest contributor to Kenya's gross domestic product(GDP)",
                        "Kenya is a leading producer of tea and coffee",
                        "Kenya is the third-leading exporter of fresh produce such as cabbages,onions and mangoes",
                        "Kenya is the world's 3rd largest exporter of cut flowers",
                        "Agriculture is the backbone of Kenya's economy",


                };
                //Randomly select a fact
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(facts.length);
                fact = facts[randomNumber];

                Intent mySuperIntent = new Intent(Fact.this, plants.class);
                startActivity(mySuperIntent);

                //Update the strin with a dynamic fact
                mTextView.setText(fact);
            }
        };
        mButton.setOnClickListener(listener);
    }
}
