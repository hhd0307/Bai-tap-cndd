package com.hoangduc.intent_pt2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        double a= intent.getDoubleExtra("a",1);
        double b= intent.getDoubleExtra("b",1);


        TextView kq = findViewById(R.id.tvkq);
        if(a==0){
            if(b==0){
                kq.setText("Phương trình có vô số nghiệm");
            }
            else{
                kq.setText("Phương trình vô nghiệm");
            }
        }
        else{
        kq.setText(" "+ (Double)(-b/a));
        }
    }

    public void back(View view){
        finish();
    }
}

