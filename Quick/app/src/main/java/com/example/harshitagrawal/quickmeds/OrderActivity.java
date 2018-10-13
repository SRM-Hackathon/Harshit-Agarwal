package com.example.harshitagrawal.quickmeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ListView presc;
    String userName;
    DatabaseReference prescRef;
    DatabaseReference orderRef;
    ArrayList<PrescriptionList> NosPrescriptions;
    ArrayList<String> dispPresc;
    public void exit(View view)
    {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        presc=findViewById(R.id.presc);
        userName=loggedIn.USR_NAME;
        NosPrescriptions=new ArrayList<PrescriptionList>();
        dispPresc=new ArrayList<String>();
        prescRef= FirebaseDatabase.getInstance().getReference("prescriptions");
        orderRef=FirebaseDatabase.getInstance().getReference("orders");
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
                OrderList orderList=new OrderList((NosPrescriptions.get(i)).getDocName(),(NosPrescriptions.get(i)).getUserName(),"Waiting",(NosPrescriptions.get(i)).getMed1(),(NosPrescriptions.get(i)).getMed2(),(NosPrescriptions.get(i)).getMed3(),(NosPrescriptions.get(i)).getMed4(),(NosPrescriptions.get(i)).getMed5(),(NosPrescriptions.get(i)).getQuan1(),(NosPrescriptions.get(i)).getQuan2(),(NosPrescriptions.get(i)).getQuan3(),(NosPrescriptions.get(i)).getQuan4(),(NosPrescriptions.get(i)).getQuan5());
                String id=orderRef.push().getKey();
                orderRef.child(id).setValue(orderList);
                Toast.makeText(getApplicationContext(),"Order Placed",Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}
