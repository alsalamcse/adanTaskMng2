package adan.sholy.adantaskmng2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class WelcomeScreen extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    FirebaseAuth auth = FirebaseAuth.getInstance();

                    if (auth.getCurrentUser() == null || auth.getCurrentUser().getEmail() == null)
                    {
                        Intent i = new Intent(getApplication(), Singin.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Intent i = new Intent(getApplication(),MainTasksActivity .class);
                        startActivity(i);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        th.start();

    }
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        img=(ImageView)findViewById(R.id.img);



    }
}
