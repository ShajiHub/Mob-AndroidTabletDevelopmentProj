package com.shajitha.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class contactUs extends AppCompatActivity {
    TextView t1;
    EditText name, email, phone, message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        name = findViewById(R.id.entername);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        message = findViewById(R.id.msg);
        send = findViewById(R.id.sendbutton);
    }

    public void send(View V){
        String fullName = name.getText().toString();
        String Email = email.getText().toString();
        String phoneNo = phone.getText().toString();
        String Message = message.getText().toString();
        Intent send = new Intent(Intent.ACTION_SENDTO);
        send.putExtra(Intent.EXTRA_EMAIL, Email);
        send.putExtra(Intent.EXTRA_SUBJECT, "Message from: " + fullName);
        send.putExtra(Intent.EXTRA_TEXT, "Message : " + Message + "\n" +"User Phone" + phoneNo);
        send.setData(Uri.parse("mailto:letzzzlearn@gmail.com"));
        if(send.resolveActivity(getPackageManager()) != null){
            startActivity(send);
        } else {
            Toast.makeText(this,"There is no email app",Toast.LENGTH_SHORT).show();
        }
    }
    //<uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>
    public void callUs(View V){
        Intent phoneCall = new Intent(Intent.ACTION_DIAL);
        phoneCall.setData(Uri.parse("tel:+141621435465"));
        startActivity(phoneCall);
    }

    public void mapView(View V){
        Uri gmap = Uri.parse("google.navigation: q=43.697239,-79.748428");
        Intent mapview = new Intent(Intent.ACTION_VIEW, gmap);
        mapview.setPackage("com.google.android.apps.maps");
        startActivity(mapview);
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
            case R.id.contactus:
                Intent gotoContactUs = new Intent(this,contactUs.class);
                startActivity(gotoContactUs);
                return true;

            case R.id.diet:
                Intent dietPage = new Intent(this,dietPlan.class);
                startActivity(dietPage);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
