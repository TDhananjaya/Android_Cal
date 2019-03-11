package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idEditText;
    Button btnPlus, btnMinus,btnMul,btnDiv;
    Double x = 0.0;
    Button getResult;
    int clicked_btn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idEditText = (EditText) findViewById(R.id.editTextNumber);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus=(Button) findViewById(R.id.btnMinus);
        btnMul=(Button) findViewById(R.id.btnMultiply);
        btnDiv=(Button) findViewById(R.id.btnDivide);
        getResult = (Button) findViewById(R.id.btnAns);
        getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clicked_btn == 1){
                    idEditText.setText(String.valueOf(x));
                    x=0.0;
                }

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(idEditText.getText().toString())) {
                    cal("+",idEditText.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Number Required", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void cal(String type,String number){
//        Toast.makeText(this, number, Toast.LENGTH_SHORT).show();
        if (type.equals("+")){
            clicked_btn =1;
            Double numberDouble = Double.parseDouble(number);
            x=x+numberDouble;
            Toast.makeText(MainActivity.this, String.valueOf(x), Toast.LENGTH_SHORT).show();
            idEditText.setText("");
        }
    }

}
