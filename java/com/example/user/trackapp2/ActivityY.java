package com.example.user.trackapp2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityY extends AppCompatActivity {
    ImageButton i1,i2,i3;
    Button lgt;
    int tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y);
        this.tap=0;
        lgt=(Button)findViewById(R.id.button3);
        i1= (ImageButton) findViewById(R.id.r1);
        i2= (ImageButton) findViewById(R.id.r2);
        i3=(ImageButton)findViewById(R.id.r3);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ActivityY.this,Alarm.class);
                startActivity(it);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ActivityY.this,Reminder.class);
                startActivity(it);
            }
        });
        i3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ActivityY.this,TrackAlarm.class);
                startActivity(it);
        }});
        lgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(ActivityY.this,MainActivity.class);
                startActivity(it);
            }
        });

    }

   /* @Override
    public void onBackPressed() {
        this.tap++;
        if(this.tap==1)
            Toast.makeText(getApplicationContext(),"Press back again to quit",Toast.LENGTH_SHORT).show();
        if(this.tap==2) {
            startActivity(new Intent(this,login_activity.class));
            }
    }
*/


}
