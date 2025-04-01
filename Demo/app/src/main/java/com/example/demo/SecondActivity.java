package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView equationTextView, resultTextView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        equationTextView = findViewById(R.id.equationTextView);
        resultTextView = findViewById(R.id.resultTextView);
        backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();
        double a = intent.getDoubleExtra("a", 0);
        double b = intent.getDoubleExtra("b", 0);
        double c = intent.getDoubleExtra("c", 0);

        // Hiển thị phương trình
        equationTextView.setText(String.format("%.1fx² + %.1fx + %.1f = 0", a, b, c));

        // Tính delta
        double delta = b * b - 4 * a * c;
        String result;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            result = String.format("Phương trình có 2 nghiệm:\nx₁ = %.2f\nx₂ = %.2f", x1, x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            result = String.format("Phương trình có nghiệm kép:\nx = %.2f", x);
        } else {
            result = "Phương trình vô nghiệm";
        }

        resultTextView.setText(result);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}