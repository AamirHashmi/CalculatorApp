package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

     TextView answerView;
     TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        answerView  = (TextView) findViewById(R.id.answerView);
        input = (TextView) findViewById(R.id.calculatorInput);

        Button clear = (Button) findViewById(R.id.Clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                answerView.setText("");
            }
        });

        Button openBracket = (Button) findViewById(R.id.leftBracket);
        openBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("(", true);
            }
        });

        Button closeBracket = (Button) findViewById(R.id.rightBracket);
        closeBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation(")", true);
            }
        });

        Button multiply = (Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("*", true);
            }
        });

        Button seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("7", true);
            }
        });

        Button eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("8", true);
            }
        });

        Button nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("9", true);
            }
        });

        Button power = (Button) findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("**", true);
            }
        });

        Button four = (Button) findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("4", true);
            }
        });


        Button five = (Button) findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("5", true);
            }
        });

        Button six = (Button) findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("6", true);
            }
        });

        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("-", true);
            }
        });


        Button one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("1", true);
            }
        });

        Button two = (Button) findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("2", true);
            }
        });

        Button three = (Button) findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("3", true);
            }
        });

        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("+", true);
            }
        });

        Button point = (Button) findViewById(R.id.point);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation(".", true);
            }
        });

        Button zero = (Button) findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToCalculation("0", true);
            }
        });

        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backspace();
            }
        });


        Button equals = (Button) findViewById(R.id.equals);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                    Expression expression = new ExpressionBuilder(input.getText().toString()).build();
                    double result = expression.evaluate();
                    answerView.setText(Double.toString(result));

               }catch (Exception e){
                   Log.d("Exception", e.getMessage());
               }
            }
        });

    }

    public void backspace(){
        String temp = input.getText().toString().trim();
        if(!temp.isEmpty()){
            input.setText(temp.substring(0, temp.length()-1));
        }
    }

    public void appendToCalculation(String string, Boolean canClear ){

        if(canClear){
            answerView.setText(" ");

            String temp = input.getText().toString() + string;
            input.setText(temp);

            Log.d("myTag", "if "+ string);
        }else{
            input.append(answerView.getText());
            String temp = input.getText().toString() + string;
            input.setText(temp);
            answerView.setText(" ");

            Log.d("myTag", "else "+ string);
        }
    }
}