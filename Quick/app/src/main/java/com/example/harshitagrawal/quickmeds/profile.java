package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profile extends AppCompatActivity {

    String id,name,email,phones,add,dobs,pass;
    EditText phone,address,dob;

    DatabaseReference usrUpdate;

    public void updateValues(View view)
    {
        phones=phone.getText().toString().trim();
        add=address.getText().toString().trim();
        dobs=dob.getText().toString().trim();
        UserProfiles usrUpd=new UserProfiles(id,name,email,pass,dobs,phones,add);

        usrUpdate.child(id).setValue(usrUpd);
        Toast.makeText(getApplicationContext(),"Profile Updated",Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        id=loggedIn.USR_ID;
        name=loggedIn.USR_NAME;
        email=loggedIn.USR_EMAIL;
        pass=loggedIn.USR_PASS;
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        dob=findViewById(R.id.dob);
        usrUpdate= FirebaseDatabase.getInstance().getReference("userProfiles");
        ((TextView)findViewById(R.id.nameView)).setText(name);
        ((TextView)findViewById(R.id.emailView)).setText(email);



    }
}
