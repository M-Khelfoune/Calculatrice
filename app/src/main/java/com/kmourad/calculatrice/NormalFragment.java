package com.kmourad.calculatrice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import static com.kmourad.calculatrice.MainActivity.compute;

public class NormalFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //        TextView textView = (TextView) view.findViewById(R.id.EditText01);
//        textView.setText(compute.getCurrentValue());
        return inflater.inflate(R.layout.fragment_normal, container, false);
    }

/*
    public void onButtonClicked(View view) {
        Button button = (Button) view;
        TextView textView = (TextView) view.findViewById(R.id.EditText01);
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
*/
}
