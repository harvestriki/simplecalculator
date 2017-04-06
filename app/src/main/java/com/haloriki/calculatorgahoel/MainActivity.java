package com.haloriki.calculatorgahoel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView ed_display;

    private Double result;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_display = (TextView) findViewById(R.id.txtCounting);
    }


    public void numericalClicked(View view) {
        String title = ((Button) view).getText().toString();
        String num = ed_display.getText().toString().equals("0") ? "" : ed_display.getText().toString();
        num += title;

        ed_display.setText(num);
    }

    double oparete(String a, String b, String op){
        switch (op) {
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "*": return Double.valueOf(a) * Double.valueOf(b);
            case "/": try {
                returnt Double.ValueOf(a) / Double.value(b);
            }catch (Exception e){
                Log.d("")
            }
        }
    }

    public void operatorClicked(View view) {
        String currentNum = ((TextView) view).getText().toString();

        if(!currentNum.equals("0")){
            result = Double.valueOf(currentNum);

        }
    }

    public void equalClicked(View view) {

    }

    public void clearClicked(View view) {
        this.clear();
    }

    private void clear() {
        ed_display.setText("0");
    }
}
