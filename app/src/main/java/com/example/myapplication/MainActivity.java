package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNumber, inputSecondNumber;
    private TextView textResult;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(v -> performCalculation("add"));
        buttonMinus.setOnClickListener(v -> performCalculation("subtract"));
        buttonMultiply.setOnClickListener(v -> performCalculation("multiply"));
        buttonDivide.setOnClickListener(v -> performCalculation("divide"));
    }


    private void performCalculation(String operation) {
        String firstInput = inputFirstNumber.getText().toString();
        String secondInput = inputSecondNumber.getText().toString();

        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            textResult.setText("Please enter both numbers.");
            return;
        }

        double firstNumber = Double.parseDouble(firstInput);
        double secondNumber = Double.parseDouble(secondInput);
        double result = 0;

        switch (operation) {
            case "add":
                result = firstNumber + secondNumber;
                break;
            case "subtract":
                result = firstNumber - secondNumber;
                break;
            case "multiply":
                result = firstNumber * secondNumber;
                break;
            case "divide":
                if (secondNumber == 0) {
                    textResult.setText("Cannot divide by zero.");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
        }

        textResult.setText("Result: " + result);
    }
}
