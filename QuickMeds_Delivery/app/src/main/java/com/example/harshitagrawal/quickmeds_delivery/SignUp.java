package com.example.harshitagrawal.quickmeds_delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    public void backToLogin(View view)
    {
        this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
}
