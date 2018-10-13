package com.example.harshitagrawal.quickmeds_delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DatabaseReference deliveryProfile;
    EditText emailText,passText;

    ArrayList<DeliveryProfile> delMan;
    public void signUpHere(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),SignUp.class);
        startActivity(signUpIntent);

    }
    public void LoginHere(View view)
    {
        String email=emailText.getText().toString().trim();
        String pass=passText.getText().toString().trim();
        int chk=0;
        for(int i=0;i<delMan.size();i++)
        {
            if((delMan.get(i).getEmail()).equals(email))
            {
                if((delMan.get(i).getPass()).equals(pass))
                {
                    Intent signUpIntent=new Intent(getApplicationContext(),home.class);
                    startActivity(signUpIntent);
                    chk=1;
                    break;

                }
            }
        }
        if(chk==0)
        {
            Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delMan=new ArrayList<DeliveryProfile>();

        emailText=findViewById(R.id.emailLogin);
        passText=findViewById(R.id.passLog);



        deliveryProfile= FirebaseDatabase.getInstance().getReference("deliveryProfile");
        deliveryProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                delMan.clear();
                for(DataSnapshot deliMan:dataSnapshot.getChildren())
                {
                    DeliveryProfile delMans=deliMan.getValue(DeliveryProfile.class);
                    delMan.add(delMans);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
