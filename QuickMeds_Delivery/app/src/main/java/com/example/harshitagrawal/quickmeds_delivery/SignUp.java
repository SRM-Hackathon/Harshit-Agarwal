package com.example.harshitagrawal.quickmeds_delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    DatabaseReference signUpDeliver;

    EditText name,email,pass,confPass;

    public void backToLogin(View view)
    {
        String nameS,emailS,passS,confPassS;
        nameS=name.getText().toString().trim();
        emailS=email.getText().toString().trim();
        passS=pass.getText().toString().trim();
        confPassS=confPass.getText().toString().trim();
        if(nameS.length()==0||emailS.length()==0||passS.length()==0||confPassS.length()==0)
        {
            Toast.makeText(getApplicationContext(),"Enter Details properly.",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!passS.equals(confPassS))
        {
            Toast.makeText(getApplicationContext(),"Enter ame Password",Toast.LENGTH_SHORT).show();
            return;
        }
        DeliveryProfile deliveryUser=new DeliveryProfile(nameS,emailS,passS,"");
        String id=signUpDeliver.push().getKey();
        signUpDeliver.child(id).setValue(deliveryUser);
        Toast.makeText(getApplicationContext(),"Sign Up successful.",Toast.LENGTH_SHORT).show();

        this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signUpDeliver= FirebaseDatabase.getInstance().getReference("deliveryProfile");
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        confPass=findViewById(R.id.confPassword);

    }
}
