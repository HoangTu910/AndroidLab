package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextA, editTextB, editTextC;
    Button solveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        solveButton = findViewById(R.id.solveButton);

        solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = editTextA.getText().toString();
                String strB = editTextB.getText().toString();
                String strC = editTextC.getText().toString();

                if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB) || TextUtils.isEmpty(strC)) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ hệ số", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double a = Double.parseDouble(strA);
                    double b = Double.parseDouble(strB);
                    double c = Double.parseDouble(strC);

                    if (a == 0) {
                        Toast.makeText(MainActivity.this, "Hệ số a phải khác 0", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}