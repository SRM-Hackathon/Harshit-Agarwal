package com.example.harshitagrawal.quickmeds_doc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    DatabaseReference newDoc;
    EditText nameView,emailView,passView,confirmPassView,specializationView;
    public void backToLogin(View view)
    {
        String name,email,pass,confirmPass,spec;
        name=nameView.getText().toString().trim();
        email=emailView.getText().toString().trim();
        pass=passView.getText().toString().trim();
        confirmPass=confirmPassView.getText().toString().trim();
        spec=specializationView.getText().toString().trim();
        if(pass.equals(confirmPass)==false)
        {
            Log.i("User123",pass);
            Log.i("User123",pass);
            Toast.makeText(getApplicationContext(),"Enter same password",Toast.LENGTH_SHORT).show();
            return;
        }
        String id=newDoc.push().getKey();
        DocProfile newDocs=new DocProfile(id,name,spec,email,pass,"");
        newDoc.child(id).setValue(newDocs);
        Toast.makeText(getApplicationContext(),"Sign Up sccessfull",Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        newDoc= FirebaseDatabase.getInstance().getReference("docProfile");
        nameView=findViewById(R.id.nameText);
        emailView=findViewById(R.id.emailText);
        passView=findViewById(R.id.passText);
        specializationView=findViewById(R.id.specializationText);
        confirmPassView=findViewById(R.id.confirmPassText);
    }
}
