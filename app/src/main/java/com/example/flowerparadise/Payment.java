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
    ImageButton next;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView detail=(TextView) findViewById(R.id.txt_payment);
        detail.setPaintFlags(detail.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        next=(ImageButton) findViewById(R.id.imageButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Payment.this, prepayments.class);
                startActivity(intent);
            }
        });

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

                reference.push().setValue(paymentModel);
                Toast.makeText(Payment.this,"order placed successfully",Toast.LENGTH_LONG).show();

            }
        });



    }
}