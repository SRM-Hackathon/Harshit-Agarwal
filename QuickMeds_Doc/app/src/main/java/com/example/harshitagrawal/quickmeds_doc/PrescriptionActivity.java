package com.example.harshitagrawal.quickmeds_doc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PrescriptionActivity extends AppCompatActivity {

    ArrayList<String> usrNames;
    ArrayList<UserProfiles> users;
    DatabaseReference patients;
    String docId,docName;
    ListView listUsers;

    public static String DOC_NAME,USER_NAME;

    public void goBack(View view)
    {
        this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        usrNames=new ArrayList<String>();
        Intent inn=getIntent();
        docId=docHome.DOC_ID;
        docName=docHome.DOC_NAME;
        Log.i("User:",docId+docName);
        listUsers=findViewById(R.id.usersList);
        users=new ArrayList<UserProfiles>();
        patients= FirebaseDatabase.getInstance().getReference("userProfiles");
        patients.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users.clear();
                usrNames.clear();
                for(DataSnapshot usr:dataSnapshot.getChildren())
                {
                    UserProfiles user=usr.getValue(UserProfiles.class);
                    users.add(user);
                    usrNames.add(user.getName());
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,usrNames);
                listUsers.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent inte=new Intent(getApplicationContext(),WritingPrescriptionActivity.class);
                //String UserName="",DocName="";

                USER_NAME=usrNames.get(i);
                Log.i("User:",usrNames.get(i));
                DOC_NAME=docName;
                Log.i("User:",docName);
                startActivity(inte);
            }
        });

    }
}
