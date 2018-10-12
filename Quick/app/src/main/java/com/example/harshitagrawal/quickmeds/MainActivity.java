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
        Log.i("UserEmail",emailList.get(0));
        String emails=email.getText().toString().trim();
        String passwords=pass.getText().toString().trim();
        byte chkSum=0;
        int pos=0;
        for (int i=0;i<emailList.size();i++)
        {
            Log.i("UserEmail",emailList.get(i));

            if(emails.equals(emailList.get(i).trim()));
            {
                chkSum=1;
                pos=i;
                break;
            }
        }
        if(chkSum==0)
        {
            Toast.makeText(getApplicationContext(),"No such ID exists",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!passList.get(pos).equals(passwords))
        {
            Log.i("UserEmail",passList.get(pos));
            Log.i("UserEmail",passwords);

            Toast.makeText(getApplicationContext(),"Email/Password incorrect",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent signUpIntent=new Intent(getApplicationContext(),login.class);
        signUpIntent.putExtra(USER_ID,userList.get(pos).getId());
        signUpIntent.putExtra(USER_NAME,userList.get(pos).getName());
        signUpIntent.putExtra(USER_EMAIL,userList.get(pos).getEmail());
        startActivity(signUpIntent);

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
