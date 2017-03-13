package com.example.user.trackapp2;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Reminder extends AppCompatActivity {
    private Button startbtn1;
    private EditText seconds;
    private Toast toast;
    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);
        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.startFlipping();
        startbtn1 = (Button) findViewById(R.id.single);
        seconds = (EditText) findViewById(R.id.edittime);
        startbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                i = 0;
                try {
                    i = Integer.parseInt(seconds.getText().toString());
                    seconds.setText("");
                    Intent intent = new Intent(Reminder.this, AlarmReceiverActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(Reminder.this, 2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000)-2000, pendingIntent);
                    if (toast != null) {
                        toast.cancel();
                    }
                    toast.makeText(getApplicationContext(), "Alarm for Activity is set to " + i + " Seconds", Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    if (toast != null) {
                        toast.cancel();
                    }
                    Toast.makeText(getApplicationContext(), "Alarm for activity is set to: " + i + " seconds", Toast.LENGTH_LONG).show();
                    Log.i("Main Activity", "Number Format Exception");
                }
            }
        });

    }
}
