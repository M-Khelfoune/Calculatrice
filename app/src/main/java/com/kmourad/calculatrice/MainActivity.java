package com.kmourad.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static Compute compute = new Compute();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.EditText01);
        textView.setText(compute.getCurrentValue());
    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        TextView textView = (TextView) findViewById(R.id.EditText01);
        compute.onKeyClikedIsValid(button.getTag().toString());
        textView.setText(compute.getCurrentValue());
    }


    private void sortInputButton(String keyCliked) {
        char key = keyCliked.charAt(0);
        if ((key >= '0') && (key <= '9')) {
            compute.readNumbers(key);
        }
        if (key == 'C') {
            compute.setClear();
        }
        if (key == ',') {
            compute.acceptedComma();
        }
        if ((key == '/') || (key == '*') || (key == '-') || (key == '+')) {
            compute.setOperation(key);
        }
        if (key == '=') {
            compute.runOperation();
        }
        if (key == 'D') {
            compute.setBackspace();
        }
        if (key == 'E') {
            compute.setClearCurrent();
        }


    }

}
