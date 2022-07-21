package com.shajitha.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

FirebaseAuth mAuth;

EditText userEmail;
Button resetPwd;
ProgressBar resetPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        userEmail = findViewById(R.id.userEmailAddress);
        resetPwd = findViewById(R.id.resetPwdButton);
        resetPB = findViewById(R.id.resetPageProgressBar);

        mAuth = FirebaseAuth.getInstance();

        resetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              resetUserPassword();
            }

            private void resetUserPassword() {

                String uEmail = userEmail.getText().toString().trim();

                if(uEmail.isEmpty()){
                    userEmail.setHint("Please enter email to reset Password!!!");
                    userEmail.requestFocus();
                    return;
                }

                resetPB.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(uEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(ResetPassword.this, "We have sent you an email. Please check your email to reset password!!!", Toast.LENGTH_LONG).show();
                        }
                        else{

                            Toast.makeText(ResetPassword.this, "Hmmm!!! Something went wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}