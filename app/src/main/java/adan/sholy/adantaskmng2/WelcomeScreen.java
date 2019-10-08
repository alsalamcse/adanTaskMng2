package adan.sholy.adantaskmng2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);


        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent i=new Intent(getApplication(),SignInActivity.class);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
    }
}