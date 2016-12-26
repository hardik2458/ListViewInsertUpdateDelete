package com.example.dadabhagwan.listviewinsertupdatedelete.CustomAdapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dadabhagwan.listviewinsertupdatedelete.GetterAndSetter.DataSet;
import com.example.dadabhagwan.listviewinsertupdatedelete.R;
import com.example.dadabhagwan.listviewinsertupdatedelete.SecondActivity;

import java.util.ArrayList;

/**
 * Created by dadabhagwan on 10/18/2016.
 */

public class MyAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<DataSet> data;

    Context context;
    public MyAdapter(ArrayList<DataSet> list, Context c)
    {
        this.data=list;
        this.context=c;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public DataSet getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {


        View vi=view;
        final ViewHolder holder ;
        if(view==null) {
            holder=new ViewHolder();
            vi= inflater.inflate(R.layout.setdata,null);
            holder.FullName= (TextView) vi.findViewById(R.id.tvFullname);
            holder.MobileNumber= (TextView) vi.findViewById(R.id.tvMobileNumber);
            holder.Update= (Button) vi.findViewById(R.id.btnUpdate);
            holder.Delete= (Button) vi.findViewById(R.id.btnDelete);
            vi.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) vi.getTag();
           holder.FullName.setText(data.get(i).getFullName());
           holder.MobileNumber.setText( data.get(i).getMobileNumber()+"");
           holder.Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder adb=new AlertDialog.Builder(context);
                    adb.setTitle("Delete?");
                    adb.setMessage("Are you sure you want to delete " + i);
                    final int positionToRemove =i;
                    adb.setNegativeButton("Cancel", null);
                    adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            data.remove(positionToRemove);
                            notifyDataSetChanged();
                        }});
                    adb.show();

                }
            });
            holder.Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


              showInputDialog(data.get(i).getFullName(),data.get(i).getMobileNumber(),i);

                }
            });

        }

        return vi;
    }
    public void showInputDialog(final String data1, int data2, final int index)
    {
        final Dialog dialog=new Dialog(context);
        dialog.setTitle("Input Box");
        dialog.setContentView(R.layout.update_data);
        dialog.setCancelable(false);
        final EditText fn= (EditText) dialog.findViewById(R.id.etUpdateFullName);
        final EditText ln= (EditText) dialog.findViewById(R.id.etUpdateMobileNumber);
        Button updating= (Button) dialog.findViewById(R.id.btnUpdating);
        fn.setText( data1+"");
        ln.setText( data2+"");

        updating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DataSet getdata=new DataSet();
                getdata.setFullName(fn.getText().toString());
                getdata.setMobileNumber(Integer.parseInt(ln.getText().toString()));


                data.set(index,getdata);
                notifyDataSetChanged();
                dialog.dismiss();

            }
        });
        dialog.show();

    }

         public static class ViewHolder
    {
        public TextView FullName;
        public TextView MobileNumber;
        public Button Update,Delete;

    }
}
