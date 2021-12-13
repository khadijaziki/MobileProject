package com.example.mobile_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class selectiion extends AppCompatActivity {
    private DatabaseReference mReferencebase;
    private FirebaseDatabase mDatabase;
    public selectiion() {
        mDatabase=FirebaseDatabase.getInstance();
        mReferencebase=mDatabase.getReference("users");
    }

    private List<Professionnel> users=new ArrayList<>();

    public interface Datastatus{
        void DataIsLoaded(List<Professionnel> users, List<String> keys);
        void DataIsInserted();
        void DataIsDeleted();

    }
    public void readusers(final Datastatus datastatus){
        mReferencebase.addValueEventListener( new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                users.clear();
                List<String> keys=new ArrayList<>();

                for(DataSnapshot keynode:snapshot.getChildren())
                {
                    keys.add(keynode.getKey());
                    Professionnel pr=keynode.getValue(Professionnel.class);
                    users.add(pr);
                }
                datastatus.DataIsLoaded(users,keys);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {


            }
        } );
    }

}
