package com.kmourad.calculatrice;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.cursorVisible;
import static android.R.attr.value;

/**
 * Created by Human Booster on 04/10/2016.
 */

public class Compute {
    // Ajouter backspace
    // Ajouter clear second operande or operande current.
    private String currentValue = "0"; // remplissage avant operation clicked
    private double firstOperande = 0;  // reçoit la valeur de currentValue si op cliked;
    private double secondOperande = 0; // réçoit la valeur de curreentValue si = clicked;
    private boolean operationCliked = false; // démarre saisie de la 2 opérande
    private boolean operationExecuted = false;
    private char operationType = '=';   // identifie le type de l'opération demandé.

    public String getCurrentValue() {
        // manque precision nb chiffre aprés virgule par defaut.
        // ici on peut presenter un format affichage comme : 12 + 6
        int idx = 0;
        StringBuilder st = new StringBuilder(currentValue);
        idx = currentValue.indexOf('.');
        if (idx >= 0) {
            st.replace(idx, idx + 1, ",");
            while ((st.length() > idx) && (st.charAt(st.length() - 1) == '0')) {
                st.deleteCharAt(st.length() - 1);
            }
            if (st.charAt(st.length() - 1) == ',') {
                st.deleteCharAt(st.length() - 1);
            }
        }
        return st.toString();
    }

    public boolean onKeyClikedIsValid(String keyCliked) {
        char key = keyCliked.charAt(0);
        boolean retour = false;
        // saisie des nombres au fure et à mesure
        if ((key >= '0') && (key <= '9')) {
            if (operationExecuted) {
                currentValue = "0";
                operationExecuted = false;
                operationType = '=';
            }
            if ((currentValue.length() == 1) && (currentValue.charAt(0) == '0')) {
                currentValue = "";
            }
            if (operationCliked) {
                currentValue = String.valueOf(key);
                operationCliked = false;
            } else {
                currentValue = currentValue + key;
            }
            retour = true;
        }
        // touche clear pressé, efface toute operation ds un premier temps
        if (key == 'C') {
            currentValue = "0";
            operationCliked = false;
            operationType = '=';
            retour = true;
        }
        // touche virgule pressé, n'autorise qu'une seul, retour = false par defaut.
        if (key == ',') {
            if ((!operationCliked) && (currentValue.indexOf('.') == -1)) {
                currentValue = currentValue + '.';
                return true;
            }
        }
        // touche operation type selectionné, l'actuel ecrase la précédente
        if ((key == '/') || (key == '*') || (key == '-') || (key == '+')) {
            operationExecuted = false;
            operationCliked = true;
            operationType = key;
            firstOperande = Double.parseDouble(currentValue);
            retour = true;
        }
        // demande d'execution de l'opération, retour = false par defaut
        if (key == '=') {
            if (!operationExecuted) {
                secondOperande = Double.parseDouble(currentValue);
            }
            if (!((operationType == '/') && (secondOperande == 0))) {
                if (operationType == '/') {
                    firstOperande = firstOperande / secondOperande;
                }
                if (operationType == '*') {
                    firstOperande = firstOperande * secondOperande;
                }
                if (operationType == '-') {
                    firstOperande = firstOperande - secondOperande;
                }
                if (operationType == '+') {
                    firstOperande = firstOperande + secondOperande;
                }
                currentValue = String.valueOf(firstOperande);
                operationExecuted = true;
                retour = true;
            }
        }
        return retour;
    }
}
