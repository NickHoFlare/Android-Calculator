package com.keez.nicho.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.keez.nicho.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION = '~';

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // "R" refers to resources

        binding.oneKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });

        binding.twoKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });

        binding.threeKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });

        binding.fourKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        binding.fiveKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });

        binding.sixKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });

        binding.sevenKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });

        binding.eightKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });

        binding.nineKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        binding.zeroKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });

        binding.decimalKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String activeText = binding.editText.getText().toString();

                if (!activeText.contains(".")) {
                    binding.editText.setText(binding.editText.getText() + ".");
                }
            }
        });

        binding.clearKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int textLength = binding.editText.getText().length();

                if (textLength >= 1) {
                    binding.editText.setText(binding.editText.getText().subSequence(0, textLength-1));
                }
            }
        });

        binding.clearKey.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                binding.editText.setText("");
                return true;
            }
        });

        binding.plusKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
                CURRENT_ACTION = ADDITION;
                binding.editText.setText(binding.editText.getText() + "+");
            }
        });

        binding.minusKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.editText.setText(binding.editText.getText() + "-");
            }
        });

        binding.multiplyKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.editText.setText(binding.editText.getText() + "*");
            }
        });

        binding.divideKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
                CURRENT_ACTION = DIVISION;
                binding.editText.setText(binding.editText.getText() + "/");
            }
        });

        binding.equalsKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
                CURRENT_ACTION = '~';
            }
        });
    }

    // If no current action, default to ~
    private void performCalculation() {
        String activeText = binding.editText.getText().toString();
        double left = 0;
        double right = 0;
        double result = 0;
        int operatorLocation = 0;

        if (CURRENT_ACTION == ADDITION) {
            operatorLocation = activeText.indexOf('+');
            if (operatorLocation != activeText.length() && operatorLocation != 0) {
                left = Double.parseDouble(activeText.substring(0, operatorLocation));
                right = Double.parseDouble(activeText.substring(operatorLocation + 1, activeText.length()));
                result = left + right;
            }
        } else if (CURRENT_ACTION == SUBTRACTION) {
            operatorLocation = activeText.indexOf('-');
            if (operatorLocation != activeText.length() && operatorLocation != 0) {
                left = Double.parseDouble(activeText.substring(0, operatorLocation));
                right = Double.parseDouble(activeText.substring(operatorLocation + 1, activeText.length()));
                result = left - right;
            }
        } else if (CURRENT_ACTION == MULTIPLICATION) {
            operatorLocation = activeText.indexOf('*');
            if (operatorLocation != activeText.length() && operatorLocation != 0) {
                left = Double.parseDouble(activeText.substring(0, operatorLocation));
                right = Double.parseDouble(activeText.substring(operatorLocation + 1, activeText.length()));
                result = left * right;
            }
        } else if (CURRENT_ACTION == DIVISION) {
            operatorLocation = activeText.indexOf('/');
            if (operatorLocation != activeText.length() && operatorLocation != 0) {
                left = Double.parseDouble(activeText.substring(0, operatorLocation));
                right = Double.parseDouble(activeText.substring(operatorLocation + 1, activeText.length()));
                result = left / right;
            }
        }

        if (CURRENT_ACTION != '~') {
            binding.editText.setText(String.valueOf(result));
        }
    }

}
