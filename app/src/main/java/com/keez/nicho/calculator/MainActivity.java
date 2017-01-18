package com.keez.nicho.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // "R" refers to resources

        TextView textElement = (TextView)findViewById(R.id.calculator_instruction);
        String instructionText = textElement.getText().toString();
        //String modifiedText = instructionText + "This is rubbish ignore me";
        //textElement.setText(modifiedText);
    }


}
