package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void signUp(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),signup.class);
        startActivity(signUpIntent);

    }
    public void loginPage(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),login.class);
        startActivity(signUpIntent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
