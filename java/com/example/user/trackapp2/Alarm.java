package com.example.user.trackapp2;

/**
 * Created by USER on 16-01-2017.
 */


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

import static java.lang.System.exit;

public class Alarm extends AppCompatActivity {
    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Button stop;
    EditText activity_name;
    ToggleButton tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);
        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        stop = (Button) findViewById(R.id.button2);
        activity_name = (EditText) findViewById(R.id.editText);
        tg=(ToggleButton) findViewById(R.id.toggleButton);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(Alarm.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                exit(0);
            }
        });
    }

    public void OnToggleClicked(View view) {
        //Intent intent = new Intent(this, AlarmReceiver.class);
        MyDBHandler dbh = new MyDBHandler(getApplicationContext());

        long time;
        if (TextUtils.isEmpty(activity_name.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Enter activity name", Toast.LENGTH_SHORT).show();
            tg.setChecked(true);
        }
        else {
            if (!((ToggleButton) view).isChecked()) {

               // Toast.makeText(this, "ALARM ON", Toast.LENGTH_SHORT).show();

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                Intent intent = new Intent(this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

                time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
                Toast.makeText(this, activity_name.getText().toString()+" set at "+alarmTimePicker.getHour()+" : "+alarmTimePicker.getMinute(), Toast.LENGTH_SHORT).show();
                //System.out.print(time);

                if (System.currentTimeMillis() > time) {
                    if (calendar.AM_PM == 0)
                        time = time + (1000 * 60 * 60 * 12);
                    else
                        time = time + (1000 * 60 * 60 * 24);
                }
                DetailsAlarm da=new DetailsAlarm(activity_name.getText().toString(),""+alarmTimePicker.getHour()+" : "+alarmTimePicker.getMinute());
                dbh.addActivityName(da);
                activity_name.setText("");
                Toast.makeText(getApplicationContext(),"Activity data stored",Toast.LENGTH_SHORT).show();
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time - 3000, 10000, pendingIntent);
            }
            else {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(this, "Activity turned OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

