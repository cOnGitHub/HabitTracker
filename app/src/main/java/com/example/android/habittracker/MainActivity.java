package com.example.android.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String displayText = "";

        // Execute write into database
        DbHelperUtils.insertHabit(this);

        // Execute read from database
        displayText = DbHelperUtils.displayDatabaseInfo(this);

        // Display text on view
        TextView displayView = (TextView) findViewById(R.id.display_text_view);
        displayView.setText(displayText);
    }
}
