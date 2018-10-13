package com.example.harshitagrawal.quickmeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    DatabaseReference prescRef;
    ArrayList<PrescriptionList> NosPrescriptions;
    ArrayList<String> dispPresc;
    ListView presc;
    String userName;

    public static PrescriptionList PRESCRIPTION;
    public void back(View view)
    {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        userName=loggedIn.USR_NAME;
        NosPrescriptions=new ArrayList<PrescriptionList>();
        presc=findViewById(R.id.prescriptions);
        dispPresc=new ArrayList<String>();
        prescRef= FirebaseDatabase.getInstance().getReference("prescriptions");
        prescRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                NosPrescriptions.clear();
                dispPresc.clear();
                for(DataSnapshot presc:dataSnapshot.getChildren())
                {
                    PrescriptionList prescr=presc.getValue(PrescriptionList.class);
                    if(prescr.getUserName().equals(userName)){
                    NosPrescriptions.add(prescr);
                    dispPresc.add("Prescription By:"+prescr.getDocName());}
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,dispPresc);
                presc.setAdapter(arrayAdapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        presc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PRESCRIPTION=NosPrescriptions.get(i);
                Intent ii=new Intent(getApplicationContext(),ViewPrescription.class);
                startActivity(ii);

            }
        });
    }
}
