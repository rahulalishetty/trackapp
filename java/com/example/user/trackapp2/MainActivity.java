package com.example.user.trackapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Button skip_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.startFlipping();
        skip_button=(Button)findViewById(R.id.skipbutton);
        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,login_activity.class));
            }
        });
    }
}