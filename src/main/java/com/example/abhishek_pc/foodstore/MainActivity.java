package com.example.abhishek_pc.foodstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v)
    {
        if(v.getId()==R.id.BLogin)
        {
            EditText a=(EditText)findViewById(R.id.TFusername);
            String str=a.getText().toString();
            EditText b=(EditText)findViewById(R.id.TFpassword);
            String pass=b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                Intent i=new Intent(MainActivity.this,CatalogActivity.class);
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                i.putExtra("username",str);
                startActivity(i);
            }
            else
            {
                Toast.makeText(MainActivity.this,"wrong username and password",Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId()==R.id.btSignin)
        {
            Intent i=new Intent(MainActivity.this,Sign_in.class);
            startActivity(i);
        }
    }
}
