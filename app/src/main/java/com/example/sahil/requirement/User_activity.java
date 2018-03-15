package com.example.sahil.requirement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class User_activity extends AppCompatActivity {
    DatabaseReference databaseRequirement;
    ListView listView;
    List<RequirementDescription> requirementDescriptionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_activity);


        listView = (ListView) findViewById(R.id.Requirement_list);
        requirementDescriptionList = new ArrayList<>();

        databaseRequirement = FirebaseDatabase.getInstance().getReference("sansthaDetails");

        databaseRequirement.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                requirementDescriptionList.clear();

                for (DataSnapshot requirementSnapshot : dataSnapshot.getChildren()){

                    RequirementDescription requirementDescription = requirementSnapshot.getValue(RequirementDescription.class);
                    requirementDescriptionList.add(requirementDescription);

                }

                Requirement_list adaptor = new Requirement_list(User_activity.this, requirementDescriptionList);
                listView.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    }

    /*@Override
    protected void onStart() {
        super.onStart();

         databaseRequirement.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {

                 requirementDescriptionList.clear();

                 for (DataSnapshot requirementSnapshot : dataSnapshot.getChildren()){

                     RequirementDescription requirementDescription = requirementSnapshot.getValue(RequirementDescription.class);
                     requirementDescriptionList.add(requirementDescription);

                 }

                 Requirement_list adaptor = new Requirement_list(User_activity.this, requirementDescriptionList);
                 listView.setAdapter(adaptor);
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });

    }

}*/
