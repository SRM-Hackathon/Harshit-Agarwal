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
    String med1,med2,med3,med4,med5;
    String quan1,quan2,quan3,quan4,quan5;
    ArrayList<String> combined;

    String userName,docName;
    EditText med,quan;

    int count;
    DatabaseReference prescriptions;
    public void givePrescription(View view)
    {
        String id=prescriptions.push().getKey();
        PrescriptionList prescriptionList=new PrescriptionList(docName,med1,med2,med3,med4,med5,quan1,quan2,quan3,quan4,quan5);
        prescriptions.setValue(prescriptionList);
        Toast.makeText(getApplicationContext(),"Prescription Saved Successfully",Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void add(View view)
    {
        if(count>4){Toast.makeText(getApplicationContext(),"You can't add any more medicines as of now",Toast.LENGTH_SHORT).show();return;}
        String medName,medQuan;
        medName=med.getText().toString().trim();
        medQuan=quan.getText().toString().trim();
        if(medName.length()==0||medQuan.length()==0)
        {
            Toast.makeText(getApplicationContext(),"Enter value",Toast.LENGTH_SHORT).show();
            return;
        }
        switch(count)
        {
            case 0:
                med1=medName;
                quan1=medQuan;
                count++;
                break;
            case 1:
                med2=medName;
                quan2=medQuan;
                count++;
                break;
            case 2:
                med3=medName;
                quan3=medQuan;
                count++;
                break;
            case 3:
                med4=medName;
                quan4=medQuan;
                count++;
                break;
            case 4:
                med5=medName;
                quan5=medQuan;
                count++;
                break;
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
        med1="";med2="";med3="";med4="";med5="";
        quan1="";quan2="";quan3="";quan4="";quan5="";
        prescriptions= FirebaseDatabase.getInstance().getReference("prescriptions").child(userName);
        combined=new ArrayList<String>();
        count=0;
        med=findViewById(R.id.medName);
        quan=findViewById(R.id.medQuant);

    }
}
