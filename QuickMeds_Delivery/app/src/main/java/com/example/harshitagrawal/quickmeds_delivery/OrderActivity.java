package com.example.harshitagrawal.quickmeds_delivery;

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

public class OrderActivity extends AppCompatActivity {

    DatabaseReference orderList;
    ArrayList<OrderList> orders;
    ArrayList<String> order;
    public static OrderList OBJ;
    ListView presView;

    public void back(View view)
    {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orders=new ArrayList<OrderList>();
        order=new ArrayList<String>();
        presView=findViewById(R.id.partiPresc);
        orderList= FirebaseDatabase.getInstance().getReference("orders");
        orderList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                     orders.clear();
                     order.clear();
                     for(DataSnapshot Lorder:dataSnapshot.getChildren()) {
                         OrderList usr = Lorder.getValue(OrderList.class);
                         orders.add(usr);
                         order.add("Order of " + usr.getUserName());
                     }
                     ArrayAdapter<String> orderAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,order);
                     presView.setAdapter(orderAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        presView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                OBJ=orders.get(i);
                Intent intent=new Intent(getApplicationContext(),OrderViewActivity.class);
                startActivity(intent);
            }
        });

    }
}
