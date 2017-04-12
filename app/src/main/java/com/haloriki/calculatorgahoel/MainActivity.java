package com.haloriki.calculatorgahoel;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView ed_display;

    private Double result = 0.0;
    private String operator;
    private String currentOpr;
    private Double lastNum;
    private Double mrPlace = 0.0;

    private enum LAST_CLICKED {
        OPERAND, OPERATOR, NONE, EQUAL
    }

    ;

    private LAST_CLICKED last_clicked = LAST_CLICKED.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_display = (TextView) findViewById(R.id.txtCounting);
    }


    public void numericalClicked(View view) {

        if (last_clicked == LAST_CLICKED.OPERATOR) {
            ed_display.setText("0.0");
        }

        String title = ((Button) view).getText().toString();
        String num = ed_display.getText().toString().equals("0.0") ? "" : ed_display.getText().toString();
        num += title;

        ed_display.setText(num);
        last_clicked = LAST_CLICKED.OPERAND;
    }

    public void operatorClicked(View view) {

        if (last_clicked == LAST_CLICKED.EQUAL) {
            result = 0.0;
        }
        String currentNum = ed_display.getText().toString();
        currentOpr = ((Button) view).getText().toString();

        if (result > 0.0) {
            result = doCalc(result, Double.valueOf(currentNum), operator);
        } else {
            result = Double.valueOf(currentNum);
        }

        ed_display.setText(String.format("%.2f", result));
        operator = currentOpr;
        last_clicked = LAST_CLICKED.OPERATOR;

    }

    private Double doCalc(Double a, Double b, String opr) {
        switch (opr) {
            case "+":
                a += b;
                break;
            case "-":
                a -= b;
                break;
            case "*":
                a *= b;
                break;
            case "/":
                a /= b;
        }
        return a;
    }

    public void mrplusClicked(View view) {
        mrPlace = Double.valueOf(ed_display.getText().toString());
    }

    public void mrminClicked(View view) {
        mrPlace = 0.0;
    }

    public void mrClicked(View view) {
        ed_display.setText(mrPlace.toString());
    }

    public void equalClicked(View view) {

        Double currentNum = Double.valueOf(ed_display.getText().toString());

        if (last_clicked == LAST_CLICKED.EQUAL) {
            currentNum = lastNum;
        } else {
            lastNum = currentNum;
        }
        result = doCalc(result, Double.valueOf(currentNum), currentOpr);
        ed_display.setText(String.format("%.2f", result));
        last_clicked = LAST_CLICKED.EQUAL;
    }

    public void clearClicked(View view) {
        this.clear();
    }

    private void clear() {
        result = 0.0;
        ed_display.setText("0.0");
    }
}
