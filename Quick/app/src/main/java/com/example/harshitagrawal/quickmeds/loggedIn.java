package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loggedIn extends AppCompatActivity {

<<<<<<< HEAD
    public void logOut(View view)
    {
        this.finish();
    }
=======
    public void profileView(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),profile.class);
        startActivity(signUpIntent);

    }

>>>>>>> 66db560248738cf3059d3ca0cad11e7e3ad07366
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);
    }
}
