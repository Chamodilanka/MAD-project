package com.example.flowerparadise;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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


                String name=sendername.getText().toString();
                String email=receiveremail.getText().toString();
                String rname=receivername.getText().toString();
                String saddress=senderaddress.getText().toString();
                String raddress=receiveraddress.getText().toString();
                String date=receiverdeilverydate.getText().toString();



                boolean check=validateinfo(name,email,rname,saddress,raddress,date);

                if(check==true){
                    Intent intent= new Intent(detail.this,Payment.class);
                    startActivity(intent);
                    reference.push().setValue(customer_details);
                    Toast.makeText(getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sorry Check the information again",Toast.LENGTH_LONG).show();
                }
            }


        });
    }

     private Boolean validateinfo(String name,String email,String rname,String saddress,String raddress,String date){
        if(name.length()==0){
            sendername.requestFocus();
            sendername.setError("Field cannot be empty");
            return false;
        }
        else if(!name.matches("[a-zA-Z]+")){
            sendername.requestFocus();
            sendername.setError("Enter only alphabetical characters");
            return false;

        }

        else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            receiveremail.requestFocus();
            receiveremail.setError("Enter valid email");
            return false;

        }

         else if(!rname.matches("[a-zA-Z]+")){
             receivername.requestFocus();
             receivername.setError("Enter only alphabetical characters");
             return false;
         }
         else if(saddress.length()==0){
             senderaddress.requestFocus();
             senderaddress.setError("Field cannot be empty");
             return false;
         }
         else if(raddress.length()==0){
             receiveraddress.requestFocus();
             receiveraddress.setError("Field cannot be empty");
             return false;
         }
        else if(raddress.length()==0){
           receiveraddress.requestFocus();
            receiveraddress.setError("Field cannot be empty");
            return false;
        }
        else if(date.length()==0){
            receiverdeilverydate.requestFocus();
            receiverdeilverydate.setError("Field cannot be empty");
            return false;
        }
        else if(!date.matches("[0-9]{1,2}+/+[0-9]{1,2}+/+[0-9]{4}+")){
            receiverdeilverydate.requestFocus();
            receiverdeilverydate.setError("Invalid date format");
            return false;

         }


        else{
            return true;
        }

     }




}