package com.example.harshitagrawal.quickmeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    DatabaseReference trackRecord;
    ArrayList<OrderList> listOfOrders;
    ArrayList<String> orderStatus;
    String userName;
    ListView listView;

    public void backs(View view)
    {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        listView=findViewById(R.id.orderListView);
        listOfOrders=new ArrayList<OrderList>();
        orderStatus=new ArrayList<String>();
        userName=loggedIn.USR_NAME;
        trackRecord= FirebaseDatabase.getInstance().getReference("orders");
        trackRecord.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listOfOrders.clear();
                orderStatus.clear();
                for(DataSnapshot orders:dataSnapshot.getChildren())
                {
                    OrderList order=orders.getValue(OrderList.class);
                    if(order.getUserName().equals(userName)==false){continue;}
                    listOfOrders.add(order);
                    orderStatus.add("Order of:Prescription by Dr."+order.getDocName()+",Status:"+order.getStatus());
                    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,orderStatus);

                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,orderStatus);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
