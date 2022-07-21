package com.shajitha.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SOUPS extends AppCompatActivity {
    GridView gridView;
    String[] soupList = {"California Italian Wedding Soup","Ultimate Potato Soup","Italian White Bean Soup","French Onion Soup",
            "Chicken Tortilla Soup ","Lentil and Ham Soup"};
    int[] soupImage = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,
            R.drawable.s5, R.drawable.s6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soups);





        gridView = findViewById(R.id.gridView);
        soupAdapter mainAdapter = new soupAdapter(SOUPS.this, soupList,soupImage);
        gridView.setAdapter(mainAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st = soupList[+position];
                Toast.makeText(getApplicationContext(), soupList[+position],
                        Toast.LENGTH_SHORT).show();
                sendPage(st);
            }

            private void sendPage(String s) {

                        Intent soup = new Intent(SOUPS.this, Recipe.class);
                        String recipeName = s;
                        soup.putExtra("recipeName",recipeName);
                        startActivity(soup);

            }
        });

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






