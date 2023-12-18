package com.example.calculatrice;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String number = "";
    private double num1 = 0;
    private double num2 = 0;
    private String symbol;

    private TextView answerTV,answerTV2;
    private Button keyPad0, keyPad1,keyPad2, keyPad3, keyPad4, keyPad5, keyPad6, keyPad7, keyPad8, keyPad9,keyPadDot;
    private Button keyPadAdd, keyPadSub, keyPadMult, keyPadDivide, keyPadClear, keyPadEquals;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTV = findViewById(R.id.textViewResult);
        answerTV2 = findViewById(R.id.textViewHistory);

        keyPad0 = findViewById(R.id.btn0);
        keyPad1 = findViewById(R.id.btn1);
        keyPad2 = findViewById(R.id.btn2);
        keyPad3 = findViewById(R.id.btn3);
        keyPad4 = findViewById(R.id.btn4);
        keyPad5 = findViewById(R.id.btn5);
        keyPad6 = findViewById(R.id.btn6);
        keyPad7 = findViewById(R.id.btn7);
        keyPad8 = findViewById(R.id.btn8);
        keyPad9 = findViewById(R.id.btn9);
        keyPad9 = findViewById(R.id.btnDot);

        keyPadAdd = findViewById(R.id.btnPlus);
        keyPadSub = findViewById(R.id.btnMinus);
        keyPadMult = findViewById(R.id.btnMultiple);
        keyPadDivide = findViewById(R.id.btnDivide);
        keyPadClear = findViewById(R.id.btnAC);
        keyPadEquals = findViewById(R.id.btnEquals);
        keyPadDot = findViewById(R.id.btnDot);

        keyPad0.setOnClickListener(this);
        keyPad1.setOnClickListener(this);
        keyPad2.setOnClickListener(this);
        keyPad3.setOnClickListener(this);
        keyPad4.setOnClickListener(this);
        keyPad5.setOnClickListener(this);
        keyPad6.setOnClickListener(this);
        keyPad7.setOnClickListener(this);
        keyPad8.setOnClickListener(this);
        keyPad9.setOnClickListener(this);
        keyPadDot.setOnClickListener(this);

        keyPadAdd.setOnClickListener(this);
        keyPadSub.setOnClickListener(this);
        keyPadMult.setOnClickListener(this);
        keyPadDivide.setOnClickListener(this);
        keyPadClear.setOnClickListener(this);
        keyPadEquals.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn0 ||
                view.getId() == R.id.btn1 ||
                view.getId() == R.id.btn2 ||
                view.getId() == R.id.btn3 ||
                view.getId() == R.id.btn4 ||
                view.getId() == R.id.btn5 ||
                view.getId() == R.id.btn6 ||
                view.getId() == R.id.btn7 ||
                view.getId() == R.id.btn8 ||
                view.getId() == R.id.btnDot ||
                view.getId() == R.id.btn9) {

                number = number + ((Button) view).getText().toString();
                answerTV.setText(number);



        } else if (view.getId() == R.id.btnPlus ||
                view.getId() == R.id.btnMinus ||
                view.getId() == R.id.btnDivide ||
                view.getId() == R.id.btnMultiple) {
            if (number == ""){
                answerTV.setText("0");
            }else {
                symbol = ((Button) view).getText().toString();
                num1 = Double.parseDouble(number);
                number = "";
                answerTV.setText(symbol);
            }

        } else if (view.getId() == R.id.btnAC) {
            symbol = "";
            num1 = 0;
            num2 = 0;
            number = "";
            answerTV.setText("0");
            answerTV2.setText("0");
        } else if (view.getId() == R.id.btnEquals) {
            if (number == "") {
                answerTV.setText("0");
            }else {
            num2 = Double.parseDouble(number);

            if (symbol.equals("+")) {
                answerTV.setText("" + (num1 + num2));
                answerTV2.setText(num1 + "+" + num2 );
            } else if (symbol.equals("-")) {
                answerTV.setText("" + (num1 - num2));
                answerTV2.setText(num1 + "-" + num2 );
            } else if (symbol.equals("÷")) {
                if (num2 != 0) {
                    answerTV.setText("" + (num1 / num2));
                    answerTV2.setText(num1 + "÷" + num2 );
                } else {
                    answerTV.setText("Can't divide by 0");
                }
            } else if (symbol.equals("×")) {
                answerTV.setText("" + (num1 * num2));
                answerTV2.setText(num1 + "×" + num2 );
            }

            num1 = 0;
            num2 = 0;
            number = "";
            }
        }
    }

}