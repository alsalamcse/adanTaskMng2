package adan.sholy.adantaskmng2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import data.MyTask;

public class addTask extends AppCompatActivity {
    private EditText edTitle;
    private EditText edSub ;
    private EditText edPo;
    private SeekBar seekB ;
    private Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        edTitle = (EditText) findViewById(R.id.edTitle);
        edSub = (EditText) findViewById(R.id.edSub);
        edPo = (EditText) findViewById(R.id.etpnionity);
        seekB = (SeekBar) findViewById(R.id.seekB);
        btnsave = (Button) findViewById(R.id.btnsave);

       btnsave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dataHandler();

           }

    }};
}
       private void dataHandler()
       {
           String Title=edTitle.getText().toString();
           String Subject=edSub.getText().toString();
           String pnionity=edPo.getText().toString();
           int seekbar=seekB.getProgress();
           boolean isOk=false;
           if (isOk)
           {
               MyTask t=new MyTask();
               t.setTitle(Title);
               t.setSubject(Subject);

           }
       }
       public void creatTask(MyTask t)
       {
           FirebaseDatabase database=FirebaseDatabase.getInstance();
           DatabaseReference reference =database.getReference();
           String key = reference.child("tasks").push().getKey();
           reference.child("task").child(key).setValue(t).addOnCompleteListener(addTask.this,new OnDelegateCreatedListener<void>()){

               @Override

               public void onComplete(@NonNull Task<void>task)
               {
                   if (task.isSuccesful()) {
                       Toast.makeText(addTask.this,"add Succesful", Toast.LENGTH_SHORT).show();
                       finish();
                   }
                   else
                       {
                       Toast.makeText(addTask.this,"add failed"+task.getExpection().getMessages(), Toast.LENGTH_SHORT).show();
                       task.getExpection().printStackTrance();
                   }
               }
           }
       }};
           private void creatTask(String Title,String Subject,int Seekbar)
           {

           }





















