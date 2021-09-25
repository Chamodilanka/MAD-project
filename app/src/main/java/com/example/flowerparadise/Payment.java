package com.example.flowerparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowerparadise.model.PaymentModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Payment extends AppCompatActivity {
    private Button Pay;
    EditText Name,CardNo,ExpDate,PinNo;
    DatabaseReference reference;
    PaymentModel paymentModel;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView detail=(TextView) findViewById(R.id.txt_payment);
        detail.setPaintFlags(detail.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        Name=(EditText)findViewById(R.id.editTextTextPersonName11);
        CardNo=(EditText)findViewById(R.id.editTextTextPersonName);
        ExpDate=(EditText)findViewById(R.id.editTextTextPersonName9);
        PinNo=(EditText)findViewById(R.id.editTextTextPersonName10);
        Pay=(Button)findViewById(R.id.button);
        paymentModel=new PaymentModel();
        reference= FirebaseDatabase.getInstance().getReference().child("Payment");

        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cardno=Integer.parseInt(CardNo.getText().toString().trim());
                int pinno=Integer.parseInt(PinNo.getText().toString().trim());

                paymentModel.setName(Name.getText().toString().trim());

                paymentModel.setCardno(cardno);
                paymentModel.setExpdate(ExpDate.getText().toString().trim());
                paymentModel.setPinno(pinno);

                String name=Name.getText().toString();
                String expdate=ExpDate.getText().toString();


                boolean check=validateinfo(name,expdate);
                if(check == true){
                    Intent intent= new Intent(Payment.this, prepayments.class);
                    startActivity(intent);
                    reference.push().setValue(paymentModel);
                    Toast.makeText(Payment.this,"order placed successfully",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Sorry Check the information again",Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    private Boolean validateinfo(String name,String expdate) {
        if (name.length() == 0) {
            Name.requestFocus();
            Name.setError("Field cannot be empty");
            return false;
        } else if (!name.matches("[a-zA-Z]+")) {
            Name.requestFocus();
            Name.setError("Enter only alphabetical characters");
            return false;

        }
       else if (expdate.length() == 0) {
            ExpDate.requestFocus();
            ExpDate.setError("Field cannot be empty");
            return false;
        } else if (!expdate.matches("[0-9]{1,2}+/+[0-9]{2}+")) {
            ExpDate.requestFocus();
            ExpDate.setError("Invalid Date Format");
            return false;

        }

        else{
            return true;
        }
    }
}