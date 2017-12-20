package com.example.abhishek_pc.foodstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity {
DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void onSignupClick(View v)
    {
        if(v.getId()==R.id.Bsignupbutton)
        {
            EditText name=(EditText)findViewById(R.id.TFname);
            EditText email=(EditText)findViewById(R.id.TFemail);
            EditText uname=(EditText)findViewById(R.id.TFusername);
            EditText pass1=(EditText)findViewById(R.id.TFpass1);
            EditText pass2=(EditText)findViewById(R.id.TFpass2);

            String namestr=name.getText().toString();
            String emailstr=email.getText().toString();
            String unamestr=uname.getText().toString();
            String pass1str=pass1.getText().toString();
            String pass2str=pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                Toast.makeText(Sign_in.this,"passwords don't match",Toast.LENGTH_LONG).show();
            }
            else
            {
                Contact c=new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUsername(unamestr);
                c.setPass(pass1str);
                helper.insertcontact(c);
                Intent i=new Intent(Sign_in.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        }
    }
}
