package com.example.harshitagrawal.quickmeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    DatabaseReference newuser;
    EditText nameText,emailText,passwordText,confirmPassText;
    public void backToLogin(View view)
    {
        String name,email,pass,confirmPass;
        name=nameText.getText().toString().trim();
        email=emailText.getText().toString().trim();
        pass=passwordText.getText().toString().trim();
        confirmPass=confirmPassText.getText().toString().trim();
        if(!pass.equals(confirmPass)){
            Toast.makeText(getApplicationContext(),"Enter same passwords",Toast.LENGTH_SHORT).show();
            return;
        }
        String id=newuser.push().getKey();
        UserProfiles user=new UserProfiles(id,name,email,pass,"","","");
        newuser.child(id).setValue(user);
        Toast.makeText(getApplicationContext(),"Sign-Up successful",Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        newuser= FirebaseDatabase.getInstance().getReference("userProfiles");
        nameText=findViewById(R.id.name);
        emailText=findViewById(R.id.email);
        passwordText=findViewById(R.id.password);
        confirmPassText=findViewById(R.id.confirmPass);
    }
}
