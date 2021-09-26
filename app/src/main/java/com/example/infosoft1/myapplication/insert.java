package com.example.infosoft1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.path;
import static com.example.infosoft1.myapplication.R.id.text;


public class insert extends AppCompatActivity {


    static EditText a1;
    static EditText a2;
    static EditText a3;
    static EditText a4;
    static Button b1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        a1=(EditText) findViewById(R.id.txt_flowernme);
        a2=(EditText) findViewById(R.id.txt_price);
        a3=(EditText) findViewById(R.id.txt_description);
        a4=(EditText) findViewById(R.id.txt_category);

        b1=(Button) findViewById(R.id.btn_add);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference("flowress");

                try {
                    Flr flrr = new Flr(a1.getText().toString(), a2.getText().toString(), a3.getText().toString(), a4.getText().toString());
                    root.child(a1.getText().toString()).setValue(flrr);
                }
                catch (Exception ex){

                    Toast.makeText(getApplicationContext(),"Error"+ex, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
