package com.example.dlarb.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    CustomAdapter mAdapter;
    ListView list;
    EditText input;
    Button btn;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = (Button) findViewById(R.id.btn1);
        btn = (Button) findViewById(R.id.btn);
        input = (EditText) findViewById(R.id.edtxt);
        list = findViewById(R.id.listview);
        mAdapter = new CustomAdapter(items);
        list.setAdapter(mAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(input.getText().toString());
                mAdapter.notifyDataSetChanged();
                input.setText("");
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.clear();
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}
