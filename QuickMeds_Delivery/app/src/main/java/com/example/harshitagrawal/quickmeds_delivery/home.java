package com.example.harshitagrawal.quickmeds_delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    public void viewProfile(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),profile.class);
        startActivity(signUpIntent);

    }
    public void orderDetails(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),orderdetails.class);
        startActivity(signUpIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }
}
