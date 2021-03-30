package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText operand1EditText;
    EditText operand2EditText;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operand1EditText = findViewById(R.id.operand1EditText);
        operand2EditText = findViewById(R.id.operand2EditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void addClick(View view) {
        double result = Double.parseDouble(operand1EditText.getText().toString()) + Double.parseDouble(operand2EditText.getText().toString());
        resultTextView.setText(Double.toString(result));
    }

    public void subtractClick(View view) {
        Toast.makeText(this, "Subtract click executed :)", Toast.LENGTH_SHORT).show();
    }

    public void multiplyClick(View view) {
        Toast.makeText(this, "Multiply click executed :)", Toast.LENGTH_SHORT).show();
    }

    public void divideClick(View view) {
        Toast.makeText(this, "Divide click executed :)", Toast.LENGTH_SHORT).show();
    }
}