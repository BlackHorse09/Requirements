package com.example.sahil.requirement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

EditText editText,editText1;
Button button;
Spinner spinner;

    DatabaseReference databaseRequirement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseRequirement = FirebaseDatabase.getInstance().getReference("sansthaDetails");

        editText = (EditText) findViewById(R.id.edit_name);
        editText1 = (EditText) findViewById(R.id.edit_description);
        button = (Button)findViewById(R.id.button);
        spinner = (Spinner)findViewById(R.id.spinner3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRequirement();
            }
        });

    }


    private void addRequirement() {

        String name = editText.getText().toString().trim();
        String spinChoice = spinner.getSelectedItem().toString();
        String description = editText1.getText().toString();

        if (!TextUtils.isEmpty(name)) {


            String id = databaseRequirement.push().getKey();
            RequirementDescription requirementDescription = new RequirementDescription(id, name, spinChoice, description);
            databaseRequirement.child(id).setValue(requirementDescription);
            Toast.makeText(this,"Entry added",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "You should enter the name of your Sanstha",Toast.LENGTH_LONG).show();
        }

    }

}
