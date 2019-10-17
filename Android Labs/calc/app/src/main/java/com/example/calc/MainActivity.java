package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_vvod;
    Button btn_go;
    TextView tvOtvet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_vvod = (EditText) findViewById(R.id.edt_vvod);
        btn_go = (Button) findViewById(R.id.btn_go);
        tvOtvet = (TextView) findViewById(R.id.tvOtvet);

        btn_go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float num = 0;

        if (TextUtils.isEmpty(edt_vvod.getText().toString())){
            tvOtvet.setText("Введите число");
            return;
        }
        num=Float.parseFloat(edt_vvod.getText().toString());
        num= (float) (num * 2.2046);
        tvOtvet.setText(String.valueOf(num));
    }
}

