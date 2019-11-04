package adan.sholy.adantaskmng2.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import adan.sholy.adantaskmng2.data.MyTask;
import adan.sholy.adantaskmng2.R;
import adan.sholy.adantaskmng2.data.TasksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlltasksFragment extends Fragment {


    public AlltasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TasksAdapter tasksAdapter = new TasksAdapter(getContext());
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_alltasks,container,false);
        IvTasks
        return inflater.inflate(R.layout.fragment_alltasks, container, false);
    }
    public void readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid=auth.getUid();
        DatabaseReference reference=database.getReference();
        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                {
                    for (DataSnapshot d:dataSnapshot.getChildren())
                    {
                        MyTask t=d.getValue(MyTask.class);
                        Log.d("MTTASK",t.toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
