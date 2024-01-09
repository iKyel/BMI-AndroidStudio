package com.example.bmi_buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txtHeight;
    EditText txtWeight;
    Button btnOK;
    TextView tvKQ;
    TextView tvThongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double h,w;
                h = Double.parseDouble(txtHeight.getText().toString());
                w = Double.parseDouble(txtWeight.getText().toString());
                double BMI = w/(h*h);
                String s;
                if(BMI < 18.6){
                    s = "Nhẹ cân";
                }
                else if(BMI <25){
                    s = "Cân nặng bình thường";
                }
                else if(BMI < 30){
                    s = "Thừa cân";
                }
                else if(BMI < 35){
                    s = "Béo phì độ I";
                }
                else if(BMI < 40){
                    s = "Béo phì độ II";
                }
                else {
                    s = "Béo phì độ III";
                }
                DecimalFormat df = new DecimalFormat("#.#");
                tvKQ.setText(String.valueOf(df.format(BMI)));
                tvThongBao.setText(s);
            }
        });
    }

    private void InitWidget() {
        txtHeight = (EditText) findViewById(R.id.etHeight);
        txtWeight = (EditText) findViewById(R.id.editTextText3);
        btnOK = (Button) findViewById(R.id.btnOK);
        tvKQ = (TextView) findViewById(R.id.tvKQ);
        tvThongBao =(TextView) findViewById(R.id.tvThongBao);

    }
}