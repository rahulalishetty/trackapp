package com.example.user.trackapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {
    TextView tv;
    Button createnewaccount;
    Button login;

    MyDBHandler helper=new MyDBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity2);

        tv=(TextView)findViewById(R.id.tv);
        Animation myanim1= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim1);

        createnewaccount=(Button)findViewById(R.id.newAccount_button);
        login=(Button)findViewById(R.id.Login_button);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  int logInt = 0;
                EditText log,pas;
                String logInt,pasInText;
                 log = (EditText) findViewById(R.id.login_text);
                 pas = (EditText) findViewById(R.id.password_text);
                logInt = log.getText().toString();
                pasInText= pas.getText().toString();

                if(TextUtils.isEmpty(log.getText().toString()))
                    Toast.makeText(getApplicationContext(),"login or password incorrect",Toast.LENGTH_SHORT).show();
               else  {
                    Long logg = Long.parseLong(logInt);
                    MyDBHandler dbh = new MyDBHandler(getApplicationContext());
                    boolean k = dbh.findid(logg, pasInText);
                    if (k) {

                        Toast.makeText(getApplicationContext(), "Welcome "+dbh.findfullname(logg), Toast.LENGTH_SHORT).show();
                        log.setText("");
                        pas.setText("");
                        Intent it = new Intent(login_activity.this, Welcome2.class);
                        startActivity(it);
                    } else
                        Toast.makeText(getApplicationContext(), "login or password not correct", Toast.LENGTH_SHORT).show();

                }

            }
        });
        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(login_activity.this,Create_accountActivity.class);
                startActivity(it);
            }
        });
    }


}
