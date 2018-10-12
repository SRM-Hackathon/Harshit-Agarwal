package com.example.harshitagrawal.quickmeds_doc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class docHome extends AppCompatActivity {


    public void logOut(View view)
    {
        this.finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_doc);
    }
}
