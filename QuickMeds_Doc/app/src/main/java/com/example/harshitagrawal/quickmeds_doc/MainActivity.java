package com.example.harshitagrawal.quickmeds_doc;

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

    DatabaseReference docUser;
    ArrayList<DocProfile> docList;
    EditText email,pass;
    public void signUp(View view)
    {
        Intent signUpIntent=new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(signUpIntent);
    }
    public static String DOC_NAME;
    public static String DOC_ID;
    public static String DOC_EMAIL;
    public static String DOC_SPECIALISATION;
    public void logIn(View view)
    {
        String emailStr,passStr;
        emailStr=email.getText().toString().trim();
        passStr=pass.getText().toString().trim();
        int chk=0;
        for(int i=0;i<docList.size();i++)
        {
            if(emailStr.equals(docList.get(i).getEmail()))
            {
                if(passStr.equals(docList.get(i).getPass()))
                {
                    Intent logIn=new Intent(getApplicationContext(),docHome.class);
                    logIn.putExtra(DOC_ID,docList.get(i).getId());
                    logIn.putExtra(DOC_EMAIL,docList.get(i).getEmail());
                    logIn.putExtra(DOC_SPECIALISATION,docList.get(i).getSpecialisation());
                    startActivity(logIn);
                    chk=1;
                }
            }
        }
        if(chk==0) Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        docList=new ArrayList<DocProfile>();
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        docUser= FirebaseDatabase.getInstance().getReference("docProfile");
        docUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                docList.clear();
                for(DataSnapshot docUser: dataSnapshot.getChildren())
                {
                    DocProfile docUsr=docUser.getValue(DocProfile.class);
                    docList.add(docUsr);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
