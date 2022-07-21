package com.shajitha.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import com.plattysoft.leonids.ParticleSystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.shajitha.recipeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    ImageView f1_anim, f2_anim, f3_anim, f4_anim, f5_anim;

    // Used to load the 'recipeapp' library on application startup.
    static {
        System.loadLibrary("recipeapp");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        f1_anim = findViewById(R.id.f1);
        f2_anim = findViewById(R.id.f2);
        f3_anim = findViewById(R.id.f3);
        f4_anim = findViewById(R.id.f4);
        f5_anim = findViewById(R.id.f5);

        TranslateAnimation horizontal_anim = new TranslateAnimation(0.0f, 400.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        horizontal_anim.setDuration(5000);  // animation duration
        horizontal_anim.setRepeatCount(5);  // animation repeat count
        horizontal_anim.setRepeatMode(2);   // l to r, r to l

        TranslateAnimation vertical_anim = new TranslateAnimation(0.0f, 0.0f,
                 0.0f, 400.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        vertical_anim.setDuration(5000);  // animation duration
        vertical_anim.setRepeatCount(5);  // animation repeat count
        vertical_anim.setRepeatMode(2);   // top to bottom / bottom to top

         // start animation
        f1_anim.startAnimation(horizontal_anim);
        f2_anim.startAnimation(vertical_anim);
        f3_anim.startAnimation(horizontal_anim);
        f4_anim.startAnimation(horizontal_anim);
        f5_anim.startAnimation(vertical_anim);



        Intent intent = new Intent(this, LoginPage.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

        startActivity(intent);
            }
        }, 6000);
    }





    /**
     * A native method that is implemented by the 'recipeapp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}