package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loggedIn extends AppCompatActivity {


    String usrName,usrID,usrEmail,usrPass,usrPhone,usrAddr,usrDob;

    public static String USR_NAME,USR_EMAIL,USR_ID,USR_PASS,USR_PHONE,USR_ADDR,USR_DOB;

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
        USR_PHONE=usrPhone;
        USR_ADDR=usrAddr;
        USR_DOB=usrDob;
        startActivity(profileIntent);

    }
    public void askdoctor(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),askDoctor.class);
        startActivity(signUpIntent);

    }
    public void track(View view)
    {
        Intent trackIntent=new Intent(getApplicationContext(),TrackActivity.class);
        USR_NAME=usrName;
        startActivity(trackIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        usrName=MainActivity.USER_NAME;
        usrID=MainActivity.USER_ID;
        usrEmail=MainActivity.USER_EMAIL;
        usrPass=MainActivity.USER_PASS;
        usrPhone=MainActivity.USER_PHONE;
        usrAddr=MainActivity.USER_ADDRESS;
        usrDob=MainActivity.USER_DOB;
    }
}
