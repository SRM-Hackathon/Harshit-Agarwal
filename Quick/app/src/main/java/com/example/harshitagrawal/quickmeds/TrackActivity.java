package com.example.harshitagrawal.quickmeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    DatabaseReference trackRecord;
    ArrayList<OrderActivity> listOfOrders;
    ArrayList<String> orderStatus;
    String userName;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        listView=findViewById(R.id.orderListView);
        trackRecord= FirebaseDatabase.getInstance().getReference("orders");
        trackRecord.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })

    }
}
