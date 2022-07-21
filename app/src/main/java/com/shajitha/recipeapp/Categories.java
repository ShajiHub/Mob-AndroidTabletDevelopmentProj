package com.shajitha.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.firebase.auth.FirebaseAuth;

import android.widget.ListView;
import java.util.ArrayList;

public class Categories extends AppCompatActivity {

   ArrayList<foodCategoriesModel> foodCategoriesModels = new ArrayList<>();

   int[] foodCategoryImages = {R.drawable.soup1, R.drawable.sandwich1, R.drawable.pasta1,
   R.drawable.chickenmeat, R.drawable.casseroles, R.drawable.kidsfav1, R.drawable.diet1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpFoodCategoryModels();
        foodCategoryAdapter adapter = new foodCategoryAdapter(this, foodCategoriesModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpFoodCategoryModels(){
        String[] foodCategoryNames = getResources().getStringArray(R.array.foodmenu);
        for(int i =0; i<foodCategoryNames.length; i++){//array to get all values from string.xml foodmenu and images
            foodCategoriesModels.add(new foodCategoriesModel(foodCategoryNames[i],foodCategoryImages[i]));//model class for each of the item
        }
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