package com.shajitha.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class dietPlan extends AppCompatActivity {
 EditText uHeight,uWeight;
 TextView uBmi, OverOrUnder;
 ImageView food1,food2;

    // Used to load the 'nativeclassapp' library on application startup.
    static {
        System.loadLibrary("nativeclassapp");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);

        uHeight =findViewById(R.id.userHeight);
        uWeight =findViewById(R.id.userWeight);
        uBmi = findViewById(R.id.bmi);
        OverOrUnder = findViewById(R.id.overOrUnder);
        food1 =findViewById(R.id.sfood1);
        food2 =findViewById(R.id.sfood2);

        float h = java.lang.Float.parseFloat(uHeight.getText().toString().trim());
        float w = java.lang.Float.parseFloat(uWeight.getText().toString().trim());

       // float h = java.lang.Float.parseFloat(String.valueOf(uHeight));
       // float w = java.lang.Float.parseFloat(String.valueOf(uWeight));

        uBmi.setText(calcBMI(h,w));

    }

    public native String calcBMI(float h,float w);

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
