package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loggedIn extends AppCompatActivity {


    String usrName,usrID,usrEmail,usrPass;

    public static String USR_NAME,USR_EMAIL,USR_ID,USR_PASS;

    public void logOut(View view)
    {
        this.finish();
    }
    public void PrescriptionSelect(View view)
    {
        USR_NAME=usrName;
        Intent intt=new Intent(getApplicationContext(),PrescriptionActivity.class);
        startActivity(intt);
    }


    public void Order(View View)
    {
        USR_NAME=usrName;
        Intent intent=new Intent(getApplicationContext(),OrderActivity.class);
        startActivity(intent);
    }
    public void profileView(View view)
    {
        Intent profileIntent=new Intent(getApplicationContext(),profile.class);
        USR_NAME=usrName;
        USR_EMAIL=usrEmail;
        USR_ID=usrID;
        USR_PASS=usrPass;
        startActivity(profileIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);
        usrName=MainActivity.USER_NAME;
        usrID=MainActivity.USER_ID;
        usrEmail=MainActivity.USER_EMAIL;
        usrPass=MainActivity.USER_PASS;
    }
}
