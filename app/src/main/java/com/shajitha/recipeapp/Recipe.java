package com.shajitha.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Recipe extends AppCompatActivity {
    TextView foodName, foodIngredients, foodInstructions;
    ImageView foodImage;

    String[] soupList = {"California Italian Wedding Soup","Ultimate Potato Soup","Italian White Bean Soup","French Onion Soup",
            "Chicken Tortilla Soup ","Lentil and Ham Soup"};
    int[] soupImage = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,
            R.drawable.s5, R.drawable.s6};

    String[] ingredients = {
            "\n ½ pound extra-lean ground beef \n 1 egg, lightly beaten\n 2 tablespoons Italian-seasoned breadcrumbs\n  1 tablespoon grated Parmesan cheese\n 2 tablespoons shredded fresh basil leaves\n 1 tablespoon chopped Italian flat leaf parsley (Optional)\n 2 green onions, sliced (Optional)\n 5¾ cups chicken broth\n 2 cups finely sliced escarole (spinach may be substituted)\n 1 lemon, zested\n ½ cup orzo (rice-shaped pasta), uncooked\n grated Parmesan cheese for topping\n\n ",
            "\n ½ pound extra-lean ground beef \n 1 egg, lightly beaten\n 2 tablespoons Italian-seasoned breadcrumbs\n  1 tablespoon grated Parmesan cheese\n 2 tablespoons shredded fresh basil leaves\n 1 tablespoon chopped Italian flat leaf parsley (Optional)\n 2 green onions, sliced (Optional)\n 5¾ cups chicken broth\n 2 cups finely sliced escarole (spinach may be substituted)\n 1 lemon, zested\n ½ cup orzo (rice-shaped pasta), uncooked\n grated Parmesan cheese for topping\n\n ",
            "\n ½ pound extra-lean ground beef \n 1 egg, lightly beaten\n 2 tablespoons Italian-seasoned breadcrumbs\n  1 tablespoon grated Parmesan cheese\n 2 tablespoons shredded fresh basil leaves\n 1 tablespoon chopped Italian flat leaf parsley (Optional)\n 2 green onions, sliced (Optional)\n 5¾ cups chicken broth\n 2 cups finely sliced escarole (spinach may be substituted)\n 1 lemon, zested\n ½ cup orzo (rice-shaped pasta), uncooked\n grated Parmesan cheese for topping\n\n ",
            "\n ½ pound extra-lean ground beef \n 1 egg, lightly beaten\n 2 tablespoons Italian-seasoned breadcrumbs\n  1 tablespoon grated Parmesan cheese\n 2 tablespoons shredded fresh basil leaves\n 1 tablespoon chopped Italian flat leaf parsley (Optional)\n 2 green onions, sliced (Optional)\n 5¾ cups chicken broth\n 2 cups finely sliced escarole (spinach may be substituted)\n 1 lemon, zested\n ½ cup orzo (rice-shaped pasta), uncooked\n grated Parmesan cheese for topping\n\n ",
            "\n ½ pound extra-lean ground beef \n 1 egg, lightly beaten\n 2 tablespoons Italian-seasoned breadcrumbs\n  1 tablespoon grated Parmesan cheese\n 2 tablespoons shredded fresh basil leaves\n 1 tablespoon chopped Italian flat leaf parsley (Optional)\n 2 green onions, sliced (Optional)\n 5¾ cups chicken broth\n 2 cups finely sliced escarole (spinach may be substituted)\n 1 lemon, zested\n ½ cup orzo (rice-shaped pasta), uncooked\n grated Parmesan cheese for topping\n\n ",
            "\n ½ pound extra-lean ground beef \n 1 egg, lightly beaten\n 2 tablespoons Italian-seasoned breadcrumbs\n  1 tablespoon grated Parmesan cheese\n 2 tablespoons shredded fresh basil leaves\n 1 tablespoon chopped Italian flat leaf parsley (Optional)\n 2 green onions, sliced (Optional)\n 5¾ cups chicken broth\n 2 cups finely sliced escarole (spinach may be substituted)\n 1 lemon, zested\n ½ cup orzo (rice-shaped pasta), uncooked\n grated Parmesan cheese for topping\n\n ",};

    String[] instructions = {
            "\nStep 1:\n Mix together the meat, egg, bread crumbs, cheese, basil, parsley, and green onions; shape into 3/4 inch balls.\n\n Step 2:\n Pour broth into a large saucepan over high heat. When boiling, drop in meatballs. Stir in escarole, lemon zest and orzo. Return to a boil; reduce heat to medium. Cook at a slow boil for 10 minutes or until orzo is tender, stirring frequently. Serve sprinkled with cheese.\n\n",
            "\nStep 1:\n Mix together the meat, egg, bread crumbs, cheese, basil, parsley, and green onions; shape into 3/4 inch balls.\n\n Step 2:\n Pour broth into a large saucepan over high heat. When boiling, drop in meatballs. Stir in escarole, lemon zest and orzo. Return to a boil; reduce heat to medium. Cook at a slow boil for 10 minutes or until orzo is tender, stirring frequently. Serve sprinkled with cheese.\n\n",
            "\nStep 1:\n Mix together the meat, egg, bread crumbs, cheese, basil, parsley, and green onions; shape into 3/4 inch balls.\n\n Step 2:\n Pour broth into a large saucepan over high heat. When boiling, drop in meatballs. Stir in escarole, lemon zest and orzo. Return to a boil; reduce heat to medium. Cook at a slow boil for 10 minutes or until orzo is tender, stirring frequently. Serve sprinkled with cheese.\n\n",
            "\nStep 1:\n Mix together the meat, egg, bread crumbs, cheese, basil, parsley, and green onions; shape into 3/4 inch balls.\n\n Step 2:\n Pour broth into a large saucepan over high heat. When boiling, drop in meatballs. Stir in escarole, lemon zest and orzo. Return to a boil; reduce heat to medium. Cook at a slow boil for 10 minutes or until orzo is tender, stirring frequently. Serve sprinkled with cheese.\n\n",
            "\nStep 1:\n Mix together the meat, egg, bread crumbs, cheese, basil, parsley, and green onions; shape into 3/4 inch balls.\n\n Step 2:\n Pour broth into a large saucepan over high heat. When boiling, drop in meatballs. Stir in escarole, lemon zest and orzo. Return to a boil; reduce heat to medium. Cook at a slow boil for 10 minutes or until orzo is tender, stirring frequently. Serve sprinkled with cheese.\n\n",
            "\nStep 1:\n Mix together the meat, egg, bread crumbs, cheese, basil, parsley, and green onions; shape into 3/4 inch balls.\n\n Step 2:\n Pour broth into a large saucepan over high heat. When boiling, drop in meatballs. Stir in escarole, lemon zest and orzo. Return to a boil; reduce heat to medium. Cook at a slow boil for 10 minutes or until orzo is tender, stirring frequently. Serve sprinkled with cheese.\n\n"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        foodName = findViewById(R.id.recipeTitle);
        foodImage = findViewById(R.id.recipeImage);
        foodIngredients= findViewById(R.id.recipeIngredients);
        foodInstructions= findViewById(R.id.recipeInstructions);

        Intent intent = getIntent();
        String recName = intent.getStringExtra("recipeName");// received from prev page

        foodName.setText(recName);

        for(int i = 0; i <= soupList.length; i++) {

            if (recName.equals(soupList[i])) {
               // foodName.setText(soupList[i]);
                foodImage.setImageResource(soupImage[i]);
                foodIngredients.setText(ingredients[i]);
                foodInstructions.setText(instructions[i]);
                break;

            }
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
