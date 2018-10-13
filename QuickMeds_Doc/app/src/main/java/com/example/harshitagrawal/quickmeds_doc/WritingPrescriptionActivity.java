package com.example.harshitagrawal.quickmeds_doc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class WritingPrescriptionActivity extends AppCompatActivity {

    ListView prescription;
    ArrayList<String> medicine;
    ArrayList<String> quantity;
    ArrayList<String> combined;

    String userName,docName;
    EditText med,quan;


    DatabaseReference prescriptions;
    public void givePrescription(View view)
    {
        String id=prescriptions.push().getKey();
        PrescriptionList prescriptionList=new PrescriptionList(docName,medicine,quantity);
        prescriptions.setValue(prescriptionList);
    }

    public void add(View view)
    {
        String medName,medQuan;
        medName=med.getText().toString().trim();
        medQuan=quan.getText().toString().trim();
        if(medName.length()==0||medQuan.length()==0)
        {
            Toast.makeText(getApplicationContext(),"Enter value",Toast.LENGTH_SHORT).show();
            return;
        }
        combined.add(medName+",Quantity:"+medQuan);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,combined);
        prescription.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_prescription);
        prescription=findViewById(R.id.prescription);
        Intent intt=getIntent();
        userName=PrescriptionActivity.USER_NAME;
        docName=PrescriptionActivity.DOC_NAME;
        medicine=new ArrayList<String>();
        quantity=new ArrayList<String>();
        combined=new ArrayList<String>();
        prescriptions= FirebaseDatabase.getInstance().getReference("prescriptions").child(userName);

        med=findViewById(R.id.medName);
        quan=findViewById(R.id.medQuant);

    }
}
