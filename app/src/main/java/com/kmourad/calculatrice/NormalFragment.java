package com.kmourad.calculatrice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.kmourad.calculatrice.MainActivity.compute;

public class NormalFragment extends Fragment {
/* PARAMETER FROM MAINACTIVITY
    static Compute compute = null;
*/
    int[] buttonIDs = new int[]{R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
            R.id.buttonCE, R.id.buttonC, R.id.buttonBack, R.id.buttonDivise, R.id.buttonEgale,
            R.id.buttonMoins, R.id.buttonMultiplie, R.id.buttonPlus, R.id.buttonVirgule};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String nameButton = "";
        View view = inflater.inflate(R.layout.fragment_normal, container, false);
        for (int i = 0; i < buttonIDs.length; i++) {
            Button b = (Button) view.findViewById(buttonIDs[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClicked(v);
                }
            });
        }
        return view;
    }

/* RECEIVING PARAMETER FROM MAINACTIVITY
    public void setCompute(Compute myCompute) {
        compute = myCompute;
    }
*/

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        if (compute == null) {
            return;
        }
        ((MainActivity) getActivity()).compute.onKeyClikedIsValid(button.getTag().toString());
        ((MainActivity) getActivity()).setDisplay(((MainActivity) getActivity()).compute.getCurrentValue().toString());
    }

    private void sortInputButton(String keyCliked) {
        char key = keyCliked.charAt(0);
        /* FOR CALLING FROM MAINACTIVITY
        if (compute == null) {
            return;
        }
        */
        if ((key >= '0') && (key <= '9')) {
            ((MainActivity) getActivity()).compute.readNumbers(key);
        }
        if (key == 'C') {
            ((MainActivity) getActivity()).compute.setClear();
        }
        if (key == ',') {
            ((MainActivity) getActivity()).compute.acceptedComma();
        }
        if ((key == '/') || (key == '*') || (key == '-') || (key == '+')) {
            ((MainActivity) getActivity()).compute.setOperation(key);
        }
        if (key == '=') {
            ((MainActivity) getActivity()).compute.runOperation();
        }
        if (key == 'D') {
            ((MainActivity) getActivity()).compute.setBackspace();
        }
        if (key == 'E') {
            ((MainActivity) getActivity()).compute.setClearCurrent();
        }
    }
}
