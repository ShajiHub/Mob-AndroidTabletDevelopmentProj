package com.shajitha.recipeapp;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginPage extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    TextView resetPwd;
    EditText  userPwd, userEmail;
    Button regUser, loginUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        getSupportActionBar().hide();

        regUser = findViewById(R.id.userRegisterButton);
        regUser.setOnClickListener(this);

        loginUser = findViewById(R.id.loginButton);
        loginUser.setOnClickListener(this);

        resetPwd = findViewById(R.id.rPassword);
        resetPwd.setOnClickListener(this);

        userEmail = findViewById(R.id.userEmailAddress);
        userPwd = findViewById(R.id.userPassword);





        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.userRegisterButton:
                startActivity(new Intent(this,RegisterUserPage.class));
                 break;
            case R.id.loginButton:
               loginUser();
                break;
            case R.id.rPassword:
               startActivity(new Intent(LoginPage.this,ResetPassword.class));
               break;
        }

    }

    private void loginUser() {
        String email = userEmail.getText().toString().trim();
        String password = userPwd.getText().toString().trim();

        if(email.isEmpty()){
            userEmail.setError("Please enter email address...");
            userEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userEmail.setError("Please enter valid email address...");
            userEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            userPwd.setError("Please type password...");
            userPwd.requestFocus();
            return;
        }

        if(password.length() < 6){
            userPwd.setError("Password must be at-least 6 characters...");
            userEmail.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if(user.isEmailVerified()){
                    startActivity(new Intent(LoginPage.this,welcomeUser.class));

                }else{
                    user.sendEmailVerification();
                    Toast.makeText(LoginPage.this, "We have sent you an email. Please check your email to verify!!!", Toast.LENGTH_LONG).show();
                }



            } else {
                Toast.makeText(LoginPage.this, "login not successful!!!", Toast.LENGTH_LONG).show();

            }
        });

    }
}