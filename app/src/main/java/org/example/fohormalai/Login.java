package org.example.fohormalai;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.example.fohormalai.Navigation.Navigation;

public class Login extends AppCompatActivity {

    private EditText et_email, et_password;
    private String email, password;
    private TextView et_register;
    Button btn_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_v2);
        // get action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login !");

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        et_register = (TextView)findViewById(R.id.toRegister);

        et_email = (EditText)findViewById(R.id.emailID);
        et_password = (EditText)findViewById(R.id.passID);
        btn_log = (Button)findViewById(R.id.btn_signIn);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        et_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(Login.this, Registration.class);
                startActivity(reg);
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(Login.this, Navigation.class);
                startActivity(reg);
            }
        });
    }

    public void login(){
        initialize();   //initialize the input string to variables

        if (!validate()){
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
        }
        else {
            onLoginSuccess();
        }
    }

    public void onLoginSuccess(){
        //TODO things that will go after login successful
    }

    public boolean validate(){
        boolean valid = true;
        if (email.isEmpty()){
            et_email.setError("Please enter your username");
            valid = false;
        }
        if(password.isEmpty()){
            et_password.setError("Please enter your password");
            valid = false;
        }
        return valid;
    }

    public void initialize(){
        email = et_email.getText().toString().trim();
        password = et_password.getText().toString().trim();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
