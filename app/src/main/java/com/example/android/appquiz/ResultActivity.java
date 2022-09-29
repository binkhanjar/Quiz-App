package com.example.android.appquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Restores the values of the name and result.
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        int result = intent.getIntExtra(MainActivity.RESULT, 0);
        String fullResult = result + getResources().getString(R.string.percentage);

        // Gets references using findViewById() method
        TextView nameTextView = (TextView) findViewById(R.id.name);
        TextView resultTextView = (TextView) findViewById(R.id.result);
        ImageView resultImageView = (ImageView) findViewById(R.id.image);

        // Restores the username
        nameTextView.setText(name);


        // Feedback for the Result
        if (result >= 80) {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.happy);
            Toast.makeText(this, "Well Done!", Toast.LENGTH_SHORT).show();
        } else if (result > 0) {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.fair);
            Toast.makeText(this, "Fair", Toast.LENGTH_SHORT).show();
        } else {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.sad);
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }


    }


}
