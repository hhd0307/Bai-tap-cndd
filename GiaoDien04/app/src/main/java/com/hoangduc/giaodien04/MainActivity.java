package com.hoangduc.giaodien04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    GridView gridview;
    boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        gridview = findViewById(R.id.gridview);
        final String[] list = {"C/C++","Java","Android","IOS","Symbian"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);
        gridview.setAdapter(adapter);
    }

    public void btn_onClick(View view) {
        check=!check;
        listview.setVisibility(check?View.GONE:View.VISIBLE);
        gridview.setVisibility(!check?View.GONE:View.VISIBLE);
        ((Button)view).setText(check?"ListView":"GridView");
    }
}
