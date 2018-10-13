package com.example.harshitagrawal.quickmeds_delivery;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OrderViewActivity extends AppCompatActivity {

    OrderList pres;
    ListView lii;
    DatabaseReference ref;
    OrderList obj;

    public void accepted(View view)
    {
        Button b= (Button) view;
        b.setBackgroundColor(Color.GREEN);
        OrderList orderList=new OrderList(obj.getId(),obj.getDocName(),obj.getUserName(),"ACCEPTED",obj.getMed1(),obj.getMed2(),obj.getMed3(),obj.getMed4(),obj.getMed5(),obj.getQuan1(),obj.getQuan2(),obj.getQuan3(),obj.getQuan4(),obj.getQuan5());
        ref.child(obj.getId()).setValue(orderList);
    }
    public void fetched(View view)
    {
        Button b= (Button) view;
        b.setBackgroundColor(Color.GREEN);
        OrderList orderList=new OrderList(obj.getId(),obj.getDocName(),obj.getUserName(),"FETCHED",obj.getMed1(),obj.getMed2(),obj.getMed3(),obj.getMed4(),obj.getMed5(),obj.getQuan1(),obj.getQuan2(),obj.getQuan3(),obj.getQuan4(),obj.getQuan5());
        ref.child(obj.getId()).setValue(orderList);
    }
    public void delivered(View view)
    {
        Button b= (Button) view;
        b.setBackgroundColor(Color.GREEN);
        OrderList orderList=new OrderList(obj.getId(),obj.getDocName(),obj.getUserName(),"DELIVERED",obj.getMed1(),obj.getMed2(),obj.getMed3(),obj.getMed4(),obj.getMed5(),obj.getQuan1(),obj.getQuan2(),obj.getQuan3(),obj.getQuan4(),obj.getQuan5());
        ref.child(obj.getId()).setValue(orderList);

        Toast.makeText(getApplicationContext(),"Delivered",Toast.LENGTH_SHORT).show();
        DatabaseReference orders=FirebaseDatabase.getInstance().getReference("orders").child(obj.id);
        orders.removeValue();
        this.finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view);
        obj=OrderActivity.OBJ;
        ref= FirebaseDatabase.getInstance().getReference("orders");
        lii=findViewById(R.id.medView);
        ArrayList<String> entries=new ArrayList<String>();
        if(obj.getMed1().equals(""))return;
        else if(obj.getMed2().equals("")){entries.add(obj.getMed1()+",Quantity:"+obj.getQuan1());}
        else if(obj.getMed3().equals("")){entries.add(obj.getMed1()+",Quantity:"+obj.getQuan1());
            entries.add(obj.getMed2()+",Quantity:"+obj.getQuan2());
        }
        else if(obj.getMed4().equals("")){entries.add(obj.getMed1()+",Quantity:"+obj.getQuan1());
            entries.add(obj.getMed2()+",Quantity:"+obj.getQuan2());
            entries.add(obj.getMed3()+",Quantity:"+obj.getQuan3());

        }
        else if(obj.getMed5().equals("")){entries.add(obj.getMed1()+",Quantity:"+obj.getQuan1());
            entries.add(obj.getMed2()+",Quantity:"+obj.getQuan2());
            entries.add(obj.getMed3()+",Quantity:"+obj.getQuan3());
            entries.add(obj.getMed4()+",Quantity:"+obj.getQuan4());

        }
        else
        {
            entries.add(obj.getMed1()+",Quantity:"+obj.getQuan1());
            entries.add(obj.getMed2()+",Quantity:"+obj.getQuan2());
            entries.add(obj.getMed3()+",Quantity:"+obj.getQuan3());
            entries.add(obj.getMed4()+",Quantity:"+obj.getQuan4());
            entries.add(obj.getMed5()+",Quantity:"+obj.getQuan5());

        }
        ArrayAdapter<String> med=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,entries);
        lii.setAdapter(med);


    }
}
