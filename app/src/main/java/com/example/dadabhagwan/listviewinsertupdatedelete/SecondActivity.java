package com.example.dadabhagwan.listviewinsertupdatedelete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

    EditText etFullname,etMobileNo;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName=etFullname.getText().toString();
                int Mobileno=Integer.parseInt(etMobileNo.getText().toString());
                Intent i=new Intent();
                i.putExtra("fullname",fullName);
                i.putExtra("MobileNumber",Mobileno);
                setResult(RESULT_OK,i);
                finish();

            }
        });



    }
    public void initialize()
    {
        etFullname= (EditText) findViewById(R.id.etFullName);
        etMobileNo= (EditText) findViewById(R.id.etMobileNumber);
        Save= (Button) findViewById(R.id.btnSave);

    }

}
