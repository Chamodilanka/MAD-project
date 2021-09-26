package com.example.infosoft1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button but1;

    public void init(){

        but1=(Button)findViewById(R.id.btn_add);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1 =new Intent(MainActivity.this,insert.class);
                startActivity(a1);
            }
        });
    }

    public void init2(){
        but1=(Button)findViewById(R.id.btn_search);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a2 =new Intent(MainActivity.this,search.class);
                startActivity(a2);
            }
        });
    }

    public void init3(){
        but1=(Button)findViewById(R.id.btn_update);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a3 =new Intent(MainActivity.this,update.class);
                startActivity(a3);
            }
        });
    }

    public void init4(){
        but1=(Button)findViewById(R.id.btn_view);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a4 =new Intent(MainActivity.this,view.class);
                startActivity(a4);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        init2();
        init3();
        init4();
    }




}