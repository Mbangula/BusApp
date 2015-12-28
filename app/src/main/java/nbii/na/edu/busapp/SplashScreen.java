package nbii.na.edu.busapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SplashScreen extends AppCompatActivity {

    private static final String TAG=SplashScreen.class.getSimpleName();

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private Bundle savedInstanceState;


    private void HideActionBar(){
        //hiding the support action bar
        this.getSupportActionBar().hide();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide the support action bar
        try {
            HideActionBar();
        } catch(Exception ex){
            Log.e(TAG, ex.getMessage());
        }
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

}
