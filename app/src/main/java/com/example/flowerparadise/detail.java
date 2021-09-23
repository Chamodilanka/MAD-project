package com.example.flowerparadise;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowerparadise.model.Customer_details;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class detail extends AppCompatActivity {
    EditText sendername,senderaddress,senderprimarycontact,sendersecondarycontact,receivername,receiveraddress,receiveremail,receiverprimarycontact,receiverdeilverydate;
    AutoCompleteTextView senderdistrict,receiverdistrict;
    Button btnSubmit;

    DatabaseReference reference;
    Customer_details customer_details;


    private Button button;
    TextInputLayout  til_dropdown1;
    AutoCompleteTextView act_dropdown1;
    TextInputLayout  til_dropdown2;
    AutoCompleteTextView act_dropdown2;
    ArrayList<String>  arrayList_district;
    ArrayAdapter<String>  arrayAdapter_district;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView detail=(TextView) findViewById(R.id.txt_topic1);
        detail.setPaintFlags(detail.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        TextView detail2=(TextView) findViewById(R.id.txt_detail2);
        detail2.setPaintFlags(detail.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);


        button=(Button) findViewById(R.id.btn_next1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(detail.this,Payment.class);
                startActivity(intent);
            }
        });

        til_dropdown1=(TextInputLayout) findViewById(R.id.dropdown1);
        act_dropdown1=(AutoCompleteTextView) findViewById(R.id.act_dropdown1);

        arrayList_district=new ArrayList<>();
        arrayList_district.add("Colombo");
        arrayList_district.add("Kandy");
        arrayList_district.add("Galle");
        arrayList_district.add("Kelaniya");
        arrayList_district.add("Matara");
        arrayList_district.add("Hambantota");
        arrayList_district.add("Rathnapura");
        arrayList_district.add("Gampaha");
        arrayList_district.add("Batticalo");

        arrayAdapter_district=new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,arrayList_district);
        act_dropdown1.setAdapter(arrayAdapter_district);
        act_dropdown1.setThreshold(1);


        til_dropdown2=(TextInputLayout) findViewById(R.id.dropdown2);
        act_dropdown2=(AutoCompleteTextView) findViewById(R.id.act_dropdown2);

        arrayList_district=new ArrayList<>();
        arrayList_district.add("Colombo");
        arrayList_district.add("Kandy");
        arrayList_district.add("Galle");
        arrayList_district.add("Kelaniya");
        arrayList_district.add("Matara");
        arrayList_district.add("Hambantota");
        arrayList_district.add("Rathnapura");
        arrayList_district.add("Gampaha");
        arrayList_district.add("Batticalo");

        arrayAdapter_district=new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,arrayList_district);
        act_dropdown2.setAdapter(arrayAdapter_district);
        act_dropdown2.setThreshold(1);



        sendername=(EditText)findViewById(R.id.edit_1);
        senderaddress=(EditText)findViewById(R.id.edit_2);
        senderdistrict=(AutoCompleteTextView)findViewById(R.id.act_dropdown1);
        senderprimarycontact=(EditText)findViewById(R.id.editTextTextPersonName2);
        sendersecondarycontact=(EditText)findViewById(R.id.editTextTextPersonName3);
        receivername=(EditText)findViewById(R.id.editTextTextPersonName4);
        receiveraddress=(EditText)findViewById(R.id.editTextTextPersonName5);
        receiverdistrict=(AutoCompleteTextView)findViewById(R.id.act_dropdown2);
        receiverprimarycontact=(EditText)findViewById(R.id.editTextTextPersonName6);
        receiveremail=(EditText)findViewById(R.id.editTextTextPersonName7);
        receiverdeilverydate=(EditText)findViewById(R.id.editTextTextPersonName8);
        btnSubmit=(Button)findViewById(R.id.btn_submit);
        customer_details=new Customer_details();
        reference= FirebaseDatabase.getInstance().getReference().child("CustomerDetails");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int senderprim=Integer.parseInt(senderprimarycontact.getText().toString().trim());
                int sendersecon=Integer.parseInt(sendersecondarycontact.getText().toString().trim());
                int receiverprim=Integer.parseInt(receiverprimarycontact.getText().toString().trim());


                customer_details.setSender_Name(sendername.getText().toString().trim());
                customer_details.setSender_Address(senderaddress.getText().toString().trim());
                customer_details.setSender_District(senderdistrict.getText().toString().trim());
                customer_details.setReceiver_Name(receivername.getText().toString().trim());
                customer_details.setReceiver_Address(receiveraddress.getText().toString().trim());
                customer_details.setReceiver_District(receiverdistrict.getText().toString().trim());
                customer_details.setReceiver_Email(receiveremail.getText().toString().trim());
                customer_details.setReceiver_DeliveryDate(receiverdeilverydate.getText().toString().trim());
                customer_details.setReceiver_PrimaryConatct(receiverprim);
                customer_details.setSender_PrimaryConatct(senderprim);
                customer_details.setSender_SecondaryConatct(sendersecon);

                reference.push().setValue(customer_details);
                Toast.makeText(detail.this,"data inserted successfully",Toast.LENGTH_LONG).show();


            }
        });
    }

}