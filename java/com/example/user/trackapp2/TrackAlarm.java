package com.example.user.trackapp2;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TrackAlarm extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_alrm);

        lv=(ListView) findViewById(R.id.list_item);
        lv.setAdapter(new BaseAdapterHelper(this));
    }
}
