package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String currentNumber = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewNumber = true;
    private final StringBuilder displayText = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        display = findViewById(R.id.display);

        int[] numberIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                          R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        
        for (int id : numberIds) {
            findViewById(id).setOnClickListener(this::onNumberClick);
        }

        findViewById(R.id.btnPlus).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnMinus).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnMultiply).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnDivide).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnEquals).setOnClickListener(this::onEqualsClick);
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            currentNumber = "";
            operator = "";
            firstNumber = 0;
            isNewNumber = true;
            displayText.setLength(0);
            display.setText("0");
        });
        findViewById(R.id.btnDot).setOnClickListener(v -> {
            if (!currentNumber.contains(".")) {
                currentNumber += ".";
                display.setText(currentNumber);
            }
        });
    }

    private void onNumberClick(View view) {
        String number = ((Button) view).getText().toString();
        if (isNewNumber) {
            currentNumber = number;
            isNewNumber = false;
        } else {
            currentNumber += number;
        }
        displayText.append(number);
        display.setText(displayText.toString());
    }

    private void onOperatorClick(View view) {
        if (!currentNumber.isEmpty()) {
            if (operator.isEmpty()) {
                firstNumber = Double.parseDouble(currentNumber);
            } else {
                calculateRunningTotal();
            }
            String newOperator = ((Button) view).getText().toString();
            operator = newOperator;
            displayText.append(" ").append(newOperator).append(" ");
            display.setText(displayText.toString());
            isNewNumber = true;
            currentNumber = "";
        }
    }

    private void calculateRunningTotal() {
        double secondNumber = Double.parseDouble(currentNumber);
        switch (operator) {
            case "+": firstNumber += secondNumber; break;
            case "-": firstNumber -= secondNumber; break;
            case "×": firstNumber *= secondNumber; break;
            case "÷":
                if (secondNumber != 0) {
                    firstNumber /= secondNumber;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
    }

    private void onEqualsClick(View view) {
        if (!currentNumber.isEmpty() && !operator.isEmpty()) {
            calculateRunningTotal();
            display.setText(String.valueOf(firstNumber));
            currentNumber = String.valueOf(firstNumber);
            operator = "";
            isNewNumber = true;
            displayText.setLength(0);
            displayText.append(currentNumber);
        }
    }
}