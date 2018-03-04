package com.hoangduc.intent_pt2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnKetQua;
    EditText txta,txtb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txta = findViewById(R.id.edtSoA);
        System.out.println(txta.toString());
        txtb = findViewById(R.id.edtSoB);
        btnKetQua = findViewById(R.id.btnKetQua);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences pre = getSharedPreferences("mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putString("valueA",txta.getText().toString());
        editor.putString("valueB", txtb.getText().toString());
        editor.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        txta.setText("0");
        txtb.setText("0");
        SharedPreferences pre = getSharedPreferences("mydata",  MODE_PRIVATE);
        String a= pre.getString("valueA","");
        String b= pre.getString("valueB","");
        String mess = "Wellcome back to MainActivity! \nYour last edit text : a= "+a +",b="+b;
        Toast toast = Toast.makeText(MainActivity.this,mess,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void ketqua(View view){
        double a,b;
        try {
         a= Double.parseDouble(txta.getText().toString());
         b= Double.parseDouble(txtb.getText().toString());
        }
        catch (NumberFormatException e){
            Toast toast = Toast.makeText(MainActivity.this, "Nhập số sai",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("a",a);
        intent.putExtra("b",b);
        startActivity(intent);
    }
}
