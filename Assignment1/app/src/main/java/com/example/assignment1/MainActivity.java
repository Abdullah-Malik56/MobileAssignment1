package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get edit text view data as numerical value.
                double amount = Double.valueOf(get(findViewById(R.id.amount)));
                float interest = (Float.valueOf(get(findViewById(R.id.interest))) / 12) / 100;
                int period = Integer.valueOf(get(findViewById(R.id.period))); // Months

                // Update result text view.
                ((TextView) findViewById(R.id.result)).setText("$" + String.format("%.2f", calculate(amount, interest, period)));
            }
        });
    }

    private String get(View view) {
        String string = ((EditText) view).getText().toString();
        if (string.isEmpty()) return "0";
        return string;
    }

    private double calculate(double amount, float interest, int period)
    {


        double numerator = amount * interest * Math.pow(1 + interest, period);
        double denominator = Math.pow(1 + interest, period) - 1;
        double result = numerator / denominator;

        return result;
    }



}