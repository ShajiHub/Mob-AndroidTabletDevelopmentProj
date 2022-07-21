package com.shajitha.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class welcomeUser extends AppCompatActivity {

    FirebaseUser user;
    DatabaseReference reference;

    String userID;
    TextView fullName;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");

        userID = user.getUid();
        fullName = findViewById(R.id.uName);


        //fullEmail.setText("Hi " + userID);
      //  reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
        reference.child(userID);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               //DataSnapshot.getValue(User.class)
                User userWelcome = snapshot.getValue(User.class);


                  String Name = userWelcome.username;
                  fullName.setText(Name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(welcomeUser.this, "Hmmm!!! Something went wrong", Toast.LENGTH_LONG).show();
            }
        });


        Intent cat = new Intent(this, Categories.class);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(cat);
            }
        }, 1000);


    }



    //creating App menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.appmenu,menu);
        return true;
    }

    //connect all needed pages in App menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.LogoutMenuItem:
                FirebaseAuth.getInstance().signOut();
                Intent gotoLoginPage = new Intent(this,LoginPage.class);
                startActivity(gotoLoginPage);
                return true;
            case R.id.homeMenuItem:
                Intent gotoHome = new Intent(this,MainActivity.class);
                startActivity(gotoHome);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}