package com.example.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height,weight;
    TextView result;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title.
        getSupportActionBar().hide(); //hide the title bar.
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean run = true;
                double bmi;
                if (height.getText().equals(""))
                    run=false;
                if (weight.getText().equals(""))
                    run=false;
                if (run)
                {
                    int weightkg = Integer.parseInt(String.valueOf(weight.getText()));
                    double heightm = Double.parseDouble(String.valueOf(height.getText()))/100;
                    bmi= weightkg/(heightm*heightm);
                    result.setText(String.valueOf((double) Math.round(bmi * 100) / 100));
                }
            }
        });
    }
}