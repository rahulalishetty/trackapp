package com.example.user.trackapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 19-02-2017.
 */

class SingleRow{
    String nameActivity,time;
    SingleRow(String a,String b){
        this.nameActivity=a;
        this.time=b;
    }
}

public class BaseAdapterHelper extends BaseAdapter {

    Context c;
    ArrayList<SingleRow> list;
    BaseAdapterHelper(Context context){
        c=context;
        //list=new ArrayList<SingleRow>();
      //  MyDBHandler dbh = new MyDBHandler(context);
       // list=dbh.getColumnActivityName();
        list=new ArrayList<SingleRow>();
        MyDBHandler dbh = new MyDBHandler(context);
        list=dbh.getColumnActivityName();
      //  list.add(new SingleRow("name","time1"));
       // list.add(new SingleRow("name","time1"));
       // list.add(new SingleRow("name","time1"));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent,false);
        TextView an=(TextView) row.findViewById(R.id.tv1);
        TextView tm=(TextView) row.findViewById(R.id.tv2);
        SingleRow temp=list.get(position);

        an.setText(temp.nameActivity);
        tm.setText(temp.time);

        return row;
    }
}
