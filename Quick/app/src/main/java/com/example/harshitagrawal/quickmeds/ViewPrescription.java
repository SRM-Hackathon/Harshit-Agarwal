package com.example.harshitagrawal.quickmeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewPrescription extends AppCompatActivity {

    PrescriptionList obj;
    ArrayAdapter<String> arrayAdapter;
    ListView objj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prescription);
        obj=PrescriptionActivity.PRESCRIPTION;
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
        Log.i("User:",String.valueOf(entries.size()));
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,entries);
        //Log.i("User",arrayAdapter.toString());
        objj=findViewById(R.id.partiPresc);
        objj.setAdapter(arrayAdapter);

    }

    public void exit(View view)
    {
        this.finish();
    }
}
