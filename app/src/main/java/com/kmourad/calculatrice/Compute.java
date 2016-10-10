package com.kmourad.calculatrice;


public class Compute {
    private String currentValue = "0";   // input the numbers
    private double firstOperande = 0;     // first value operande
    private double secondOperande = 0;     // second value operande
    private boolean operationCliked = false; // start reading 2nd opérande
    private boolean operationExecuted = false;
    private char operationType = '=';   // last type of operation.
    private boolean errorDivideByZero = false;

    public String getCurrentValue() {
        if (errorDivideByZero) {
            return "Division par 0 non admise !";
        } else {
            return getFormatString(currentValue);
        }
    }

    private String stripLastPlotZero(char key, String toStrip){
        String theKey = toStrip;
        if ((toStrip.length() > 2) &&
                (toStrip.charAt(toStrip.length() - 2) == key) &&
                (toStrip.charAt(toStrip.length() - 1) == '0')) {
            theKey = toStrip.substring(0, toStrip.length()-2);
        }
        return theKey;
    }

    protected String getFormatString(String toShow) {
        String returnThis;
        returnThis = toShow.replace('.', ',');
        returnThis = stripLastPlotZero(',', returnThis);
        return returnThis;
    }

    protected void readNumbers(char key) {
        if (errorDivideByZero || operationExecuted) {
            setClear();
        }
        if ((currentValue.length() == 1) && (currentValue.charAt(0) == '0')) {
            currentValue = "";
        }
        if (operationCliked) {
            currentValue = String.valueOf(key);
            operationCliked = false;
        } else {
            currentValue += Character.toString(key);
        }
    }

    protected void setClear() {
        currentValue = "0";
        operationCliked = false;
        operationExecuted = false;
        operationType = '=';
        errorDivideByZero = false;
    }

    protected void acceptedComma() {
        if ((!operationCliked) && (currentValue.indexOf('.') == -1)) {
            currentValue = currentValue + '.';
        }
    }

    protected void setOperation(char key) {
        // operationType { /, *, +, -, }
        if (!(operationType == '=') && (operationExecuted)) {
            runOperation();
        }
        operationExecuted = false;
        operationCliked = true;
        operationType = key;
        firstOperande = Double.parseDouble(currentValue);
    }

    protected void runOperation() {
        if (errorDivideByZero) {
            setClear();
        }
        if (!operationExecuted) {
            secondOperande = Double.parseDouble(currentValue);
        }
        if (operationType == '/') {
            firstOperande = firstOperande / secondOperande;
            errorDivideByZero = Double.isInfinite(firstOperande);
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
        operationType = '=';
    }

    protected void setBackspace() {
        currentValue = stripLastPlotZero('.', currentValue);
        if ((currentValue.length()==1) && (currentValue.charAt(0)!='0')){
            currentValue = "0";
        }
        if (currentValue.length()>1) {
            currentValue = currentValue.substring(0, currentValue.length()-1);
        }
    }

    protected void setClearCurrent() {
        currentValue = "0";
    }

    public void onKeyClikedIsValid(String keyCliked) {
        char key = keyCliked.charAt(0);
        if ((key >= '0') && (key <= '9')) {
            readNumbers(key);
        }
        if (key == 'C') {
            setClear();
        }
        if (key == ',') {
            acceptedComma();
        }
        if ((key == '/') || (key == '*') || (key == '-') || (key == '+')) {
            setOperation(key);
        }
        if (key == '=') {
            runOperation();
        }
        if (key == 'D') {
            setBackspace();
        }
        if (key == 'E') {
            setClearCurrent();
        }
    }
}
