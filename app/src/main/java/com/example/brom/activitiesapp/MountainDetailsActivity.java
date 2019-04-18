package com.example.brom.activitiesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MountainDetailsActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    String matterhorn = "matterhorn";
    String montblanc = "montblanc";
    String denali = "denali";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_details);

        String mountainInfo = getIntent().getExtras().getString("MOUNTAININFO");
        textView = (TextView)findViewById(R.id.berra);
        textView.setText(mountainInfo);
        imageView = (ImageView)findViewById(R.id.imageView);
        if (mountainInfo.toLowerCase().matches(".*matterhorn.*")){
            imageView.setImageResource(R.drawable.matterhorn);
        }
        else if (mountainInfo.toLowerCase().matches(".*mont blanc.*")){
            imageView.setImageResource(R.drawable.montblanc);
        }
        else if (mountainInfo.toLowerCase().matches(".*denali.*")){
            imageView.setImageResource(R.drawable.denali);
        }


    }
}
