package com.shajitha.recipeapp;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUserPage extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    EditText userName, userPwd, userEmail;
    Button regUser;

    private DatabaseReference mDatabase;
// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_page);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        regUser = findViewById(R.id.userRegisterButton);
        regUser.setOnClickListener(this);

        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmailAddress);
        userPwd = findViewById(R.id.userPassword);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.userRegisterButton:
                registerNewUser();
                break;
        }
    }

    private void registerNewUser() {
        String name = userName.getText().toString().trim();
        String email = userEmail.getText().toString().trim();
        String password = userPwd.getText().toString().trim();

        if (name.isEmpty()) {
            userName.setError("Please enter the name...");
            userName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            userEmail.setError("Please enter email address...");
            userEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userEmail.setError("Please enter valid email address...");
            userEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            userPwd.setError("Please type password...");
            userPwd.requestFocus();
            return;
        }

        if (password.length() < 6) {
            userPwd.setError("Password must be at-least 6 characters...");
            userEmail.requestFocus();
            return;
        }



        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(name, email);

                            FirebaseDatabase.getInstance().getReference("users")

                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(task1 -> {

                                if (task1.isSuccessful()) {
                                    Toast.makeText(RegisterUserPage.this, "User Successfully Registered", Toast.LENGTH_LONG).show();


                                } else {
                                    Toast.makeText(RegisterUserPage.this, "Registration not successful!!!", Toast.LENGTH_LONG).show();

                                }
                            });
                        }
                    }

                    ;


                });
    }
}


