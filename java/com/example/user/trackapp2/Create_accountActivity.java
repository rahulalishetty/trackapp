package com.example.user.trackapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_accountActivity extends AppCompatActivity {
    EditText fullname,logid,password,confirmpassword;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        fullname=(EditText) findViewById(R.id.full_name);
        logid=(EditText) findViewById(R.id.login_id);
        password=(EditText) findViewById(R.id.password);
        submit=(Button) findViewById(R.id.submit);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);



        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String norpass=password.getText().toString();
                String conpass=confirmpassword.getText().toString();
                if(norpass.trim().length()>5) {
                    if (norpass.equals(conpass)) {
                        MyDBHandler dbh = new MyDBHandler(getApplicationContext());
                        DetailsLogin d = new DetailsLogin(fullname.getText().toString(), Long.parseLong(logid.getText().toString()), password.getText().toString());
                        dbh.addData(d);
                        Toast.makeText(getApplicationContext(), "Account created", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(Create_accountActivity.this, login_activity.class);
                        startActivity(it);
                    } else
                        Toast.makeText(getApplicationContext(), "password doesn't match", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"atleast 6 characters required",Toast.LENGTH_SHORT).show();

            }
        });

    }


}
