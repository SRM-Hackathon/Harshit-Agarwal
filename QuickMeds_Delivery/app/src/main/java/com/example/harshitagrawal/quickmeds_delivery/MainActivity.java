package com.example.harshitagrawal.quickmeds_delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void signUpHere(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),SignUp.class);
        startActivity(signUpIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
