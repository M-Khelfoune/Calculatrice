package com.kmourad.calculatrice;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.kmourad.calculatrice.R.id.fragment_normal;

public class MainActivity extends AppCompatActivity {
    static protected Compute compute = new Compute();
    static TextView textView;
/* For Call normalFragment
    static NormalFragment normalFragment;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.EditText01);

/*  How TO Call normalFragment
        if (savedInstanceState == null) {
            normalFragment = (NormalFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_normal);
        }
        normalFragment.setCompute(compute);
*/
    }

    public void setDisplay(String toShow) {
        textView.setText(toShow);

    }

}
