package adan.sholy.adantaskmng2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Singin extends AppCompatActivity {
    private EditText etAdd1;
    private EditText etAdd2;
    private Button sn1;
    private Button sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin2);
        etAdd1=(EditText) findViewById(R.id.etAdd1);
        etAdd2=(EditText) findViewById(R.id.etAdd2);
        sn1=(Button) findViewById(R.id.sn1);
        sp1=(Button) findViewById(R.id.sp1);

    }
    private void dataHandler() {
        String email = etAdd1.getText().toString();
        String password = etAdd2.getText().toString();
        boolean isok = true;
        if(email.length()<4)
        {
            etAdd2.setError("Email lenght error");
           isok=false;

        }
        if (email.indexOf("@")<0||email.indexOf(".")<0)
        {
            etAdd2.setError("email worng format");
            isok=false;
        }
//        if (isValidEmailAddress(email) == false)
//             {
//          etAdd1.setError("Invalid Email");
//            isok = false;
//        }
        if (password.length() <8)
        {
            etAdd1.setError(" min lenght8");
            isok = false;
        }
        if (isok)
        {
            signIn(email,password);

        }

    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    private void signIn(String email,String password){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())

                    {
                //go to ,mail screen(all task activity)
                        Intent intent=new Intent(SinginActivity.this,MainTasksActivity.class);
                        startActivity(intent);

            }
            else
            {
                etAdd1.setError("email or password is wrong");
            }

            }
        });
    }

}

