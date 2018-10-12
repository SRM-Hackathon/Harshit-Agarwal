package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


    DatabaseReference userProfiles;
    ArrayList<UserProfiles> userList;
    ArrayList<String> emailList;
    ArrayList<String>passList;
    EditText email,pass;
    public static String USER_ID,USER_NAME,USER_EMAIL;
    public void signUp(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),signup.class);
        startActivity(signUpIntent);

    }
    public void loginPage(View view)
    {
        //Log.i("UserEmail",emailList.get(0));
        String emailData=email.getText().toString();
        String passData=pass.getText().toString();
        int chk=0;
        for (int i=0;i<userList.size();i++)
        {
            if(emailData.equals(userList.get(i).getEmail()))
            {
                if(passData.equals(userList.get(i).getPassword()))
                {
                    Intent signUpIntent=new Intent(getApplicationContext(),loggedIn.class);
                    signUpIntent.putExtra(USER_ID,userList.get(i).getId());
                    signUpIntent.putExtra(USER_NAME,userList.get(i).getName());
                    signUpIntent.putExtra(USER_EMAIL,userList.get(i).getEmail());
                    startActivity(signUpIntent);
                    chk=1;
                }

            }

        }
        if(chk!=1)Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userProfiles= FirebaseDatabase.getInstance().getReference("userProfiles");
        userList=new ArrayList<UserProfiles>();
        emailList=new ArrayList<String>();
        passList=new ArrayList<String>();

        userProfiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userList.clear();
                for(DataSnapshot user:dataSnapshot.getChildren())
                {
                    UserProfiles usr=user.getValue(UserProfiles.class);
                    userList.add(usr);
                    emailList.add(usr.getEmail());
                    passList.add(usr.getPassword());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        email=findViewById(R.id.emailText);
        pass=findViewById(R.id.passText);

    }
}
