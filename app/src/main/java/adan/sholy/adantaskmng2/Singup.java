package adan.sholy.adantaskmng2;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Singup extends AppCompatActivity {
    private EditText firstname;
    private EditText lastname;
    private EditText phone;
    private EditText email;
    private EditText password1;
    private EditText password2;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        btnsave = (Button) findViewById(R.id.btnsave);
    }

    private void dataHndler()
    {
        boolean isok = true;
        String email = this.email.getText().toString();
        String password1 = this.password1.getText().toString();
        String firstname = this.phone.getText().toString();
        String lastname = this.firstname.getText().toString();
        String phone = this.lastname.getText().toString();
        String password2;
        password2 = this.password2.getText().toString();
        if (email.length() < 4 ||
                email.indexOf('@') < 0 ||
                email.indexOf('.') < 0) {
            this.email.setError("email wrong format");

        }
        if (password1.length() < 8 || password1.equals(password2) == false) {
            this.password1.setError("Have to be at least 8 char and the same password ");
            this.password2.setError("Have to be at least 8 char and the same password ");

            isok = false;
        }
        if (lastname.length() == 0) {
            this.firstname.setError("enter name");
            isok = false;
        }
        if (isok) {
            creatAcount(email, password1, password2, phone, lastname);
        }
    }

    private void creatAcount(final String email, String password1, String password2, String firstname, String lastname) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            private AccessibilityNodeInfo email;

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ((task.isSuccessful())) {
                    Toast.makeText(Singup.this, "sign up successful", Toast.LENGTH_SHORT).show();
                    finish();

                }
                else
                    {

                    this.email.setError("sign up faild");
                }
            }
        });
    }
}








