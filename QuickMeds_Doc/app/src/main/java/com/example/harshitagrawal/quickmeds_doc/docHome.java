package com.example.harshitagrawal.quickmeds_doc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class docHome extends AppCompatActivity {


    String DocId,DocName,DocSpec,DocEmail;
    public static String DOC_ID,DOC_NAME;
    public void prescribeUser(View view)
    {
        Intent intent=new Intent(getApplicationContext(),PrescriptionActivity.class);
        DOC_ID=DocId;
        DOC_NAME=DocName;
        Log.i("User:",DOC_ID+DOC_NAME);
        startActivity(intent);
    }
    public void logOut(View view)
    {
        this.finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_doc);
        Intent intent=getIntent();

        DocId=MainActivity.DOC_ID;
        DocName=MainActivity.DOC_NAME;
        //DocSpec=intent.getStringExtra(MainActivity.DOC_SPECIALISATION);
        DocEmail=MainActivity.DOC_EMAIL;
        Log.i("User:",DocName);

    }
}
