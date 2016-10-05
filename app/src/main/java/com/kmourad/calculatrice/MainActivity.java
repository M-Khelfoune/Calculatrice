package com.kmourad.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {
    static String valueShow = "0";
    Compute compute = new Compute();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.EditText01);
        textView.setText(valueShow);
    }

    public void onButtonClicked(View view){
        Button button = (Button) view;
        TextView textView = (TextView) findViewById(R.id.EditText01);
        if (compute.onKeyClikedIsValid(button.getTag().toString())) {
            valueShow = compute.getCurrentValue();
            textView.setText(valueShow);
        }
    }
}
