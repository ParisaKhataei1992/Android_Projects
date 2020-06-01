package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Assignment1 extends AppCompatActivity {

    EditText b , r , z;
    TextView res;
    public static String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1);
        Button btnBack = findViewById(R.id.btn_back);

        Button submit = findViewById(R.id.btn_submit);
        b = (EditText) findViewById(R.id.txt_B);
        r = (EditText) findViewById(R.id.txt_R);
        z = (EditText) findViewById(R.id.txt_z);
        res = (TextView) findViewById(R.id.txtViw_result);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num1 = b.getText().toString();
                String num2 = r.getText().toString();
                String num3 = z.getText().toString();
                result = String.valueOf((100 * Integer.parseInt(num1))
                        * (86 * Integer.parseInt(num2))
                        * (54 * Integer.parseInt(num3)));
                res.setText(result);

                //Log.d("Assignment1" , z.getText().toString());
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }
}
