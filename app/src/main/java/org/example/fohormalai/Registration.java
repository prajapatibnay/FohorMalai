package org.example.fohormalai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private EditText et_name, et_phone, et_email, et_pass, et_confpass;
    private String name, phone, email, password, Cpassword;
    private TextView et_login;
    Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et_login = (TextView)findViewById(R.id.toLogin);

        et_name = (EditText)findViewById(R.id.fullName);
        et_email = (EditText)findViewById(R.id.emailID);
        et_pass = (EditText)findViewById(R.id.password);
        et_phone = (EditText)findViewById(R.id.number);
        et_confpass = (EditText) findViewById(R.id.confPassword);
        btn_reg = (Button)findViewById(R.id.btn_register2);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();     //call when the button is clicked to validate the input
            }
        });

        et_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Registration.this, MainActivity_Second.class);
                startActivity(k);
            }
        });
    }

    public void register(){
        initialize();   //initialize the input to string variables

        if (!validate()) {
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            onRegisterSuccess();
        }
    }
    public void onRegisterSuccess(){
        //TODO what will go after the valid input



    }
    public boolean validate(){
        boolean valid = true;
        if (name.isEmpty()||name.length()>32){
            et_name.setError("Please Enter valid name");
            valid = false;
        }
        if (phone.isEmpty()){
            et_phone.setError("Please enter phone number");
            valid = false;
        }
        if (email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Please enter valid email address");
            valid = false;
        }
        if (password.isEmpty()){
            et_pass.setError("Please enter password");
            valid = false;
        }
        if (Cpassword != password){
            et_confpass.setError("The password did not match");
            valid = false;
        }

        return valid;
    }
    public void initialize(){
        name = et_name.getText().toString().trim();
        email = et_email.getText().toString().trim();
        password = et_pass.getText().toString().trim();
        phone = et_phone.getText().toString().trim();
        Cpassword = et_confpass.getText().toString().trim();
    }
}
