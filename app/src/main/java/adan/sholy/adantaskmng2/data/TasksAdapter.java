package adan.sholy.adantaskmng2.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import adan.sholy.adantaskmng2.R;

public class TasksAdapter extends ArrayAdapter<MyTask>
{

    public TasksAdapter(@NonNull Context context)
    {
        super(context, R.layout.taskitem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // building item view

        View Vitem=LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,true);
        TextView tvTitle=Vitem.findViewById(R.id.itmTvTitle);
        TextView tvSubject=Vitem.findViewById(R.id.ItmTvSubject);
        RatingBar rbPrio=Vitem.findViewById(R.id.itmRatingPrio);
        CheckBox chIsCompleted=Vitem.findViewById(R.id.itmChbxlsCompleted);
        ImageView ivInfo=Vitem.findViewById(R.id.itmImgInfo);


        //getting data source

        final MyTask myTask=getItem(position);

        //todo טיפיל באירוע מחיקה

       chIsCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked)
               {

                   //todo delete this item
                   FirebaseUtils.getReference().child(myTask.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                       @Override
                       public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                           if (databaseError==null)
                           {
                               Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();


                           }
                           else {
                               Toast.makeText(getContext(), "not deldted:" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                           }
                       }
                   });
               }
           }
       });

        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSubject());
        rbPrio.setRating(myTask.getImportant());
        chIsCompleted.setChecked(false);


        return Vitem;
    }
}


