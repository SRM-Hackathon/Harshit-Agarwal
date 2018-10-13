package com.example.harshitagrawal.quickmeds_delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {



    public void logOut(View view)
    {
        this.finish();
    }
    public void orderDetails(View view)
    {
        Intent intent=new Intent(getApplicationContext(),OrderActivity.class);
        startActivity(intent);
    }
    public void profile(View view)
    {
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

}
