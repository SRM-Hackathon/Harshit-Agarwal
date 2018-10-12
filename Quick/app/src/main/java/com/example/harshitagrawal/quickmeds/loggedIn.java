package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loggedIn extends AppCompatActivity {

    public void profileView(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),profile.class);
        startActivity(signUpIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);
    }
}
