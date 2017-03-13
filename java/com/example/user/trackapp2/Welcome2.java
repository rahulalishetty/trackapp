package com.example.user.trackapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.animation.AnimationUtils.loadAnimation;

public class Welcome2 extends AppCompatActivity {
    Button next;
    TextView tv;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);
        next=(Button)findViewById(R.id.buttonnext);
        tv=(TextView)findViewById(R.id.tv);
        iv=(ImageView)findViewById(R.id.iv1);
        Animation myanim= loadAnimation(this,R.anim.mytransition);
        Animation myanim2= loadAnimation(this,R.anim.mytransition2);
        tv.startAnimation(myanim2);
        iv.startAnimation(myanim);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"Enter",Toast.LENGTH_SHORT).show();
                Intent it=new Intent(Welcome2.this,ActivityY.class);
                startActivity(it);
            }
        });
    }
}
