package com.example.dadabhagwan.listviewinsertupdatedelete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dadabhagwan.listviewinsertupdatedelete.CustomAdapter.MyAdapter;
import com.example.dadabhagwan.listviewinsertupdatedelete.GetterAndSetter.DataSet;

import java.util.ArrayList;

public class FirstActivity extends Activity {


    ListView List;
    Button btnNext;
    ArrayList<DataSet> list=new ArrayList<DataSet>();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initialize();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(i1,1);

            }
        });


    }
    public void initialize()
    {
        List= (ListView) findViewById(R.id.listview);
        btnNext= (Button) findViewById(R.id.btnNext1);
        adapter=new MyAdapter(list,FirstActivity.this);
        List.setAdapter(adapter);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if(data!=null) {

              String name=data.getStringExtra("fullname");
              int no=data.getIntExtra("MobileNumber",0);

               Toast.makeText(this, name+"\n"+no, Toast.LENGTH_SHORT).show();
              DataSet o=new DataSet();
              o.setFullName(name);
              o.setMobileNumber(no);
              list.add(o);
              adapter.notifyDataSetChanged();
            }
        }
    }



}
