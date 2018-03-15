package com.example.sahil.requirement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Starting_activity extends AppCompatActivity {


    Button buser;
    Button bsanstha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_activity);

        buser = (Button) findViewById(R.id.user_button);
        bsanstha = (Button) findViewById(R.id.sanstha_button);

        buser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starting_activity.this, User_activity.class);
                startActivity(intent);
            }
        });

        bsanstha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starting_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
