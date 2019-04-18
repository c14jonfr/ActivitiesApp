package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Mountain m0 = new Mountain("Matterhorn", "Alps", 4478);
        final Mountain m1 = new Mountain("Mont Blanc", "Alps", 4808);
        final Mountain m2 = new Mountain("Denali", "Alaska", 6190);

        final List<Mountain> mountains = new ArrayList<Mountain>();
        mountains.add(m0);
        mountains.add(m1);
        mountains.add(m2);



        List<String> mountainData = new ArrayList<String> ();

        for (int i = 0; i < mountains.size(); i++) {
            mountainData.add(mountains.get(i).toString());
        }

        //mountainData.add(m0.toString());
        //mountainData.add(m1.toString());

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item_textview, R.id.my_item_textview, mountainData);

        final ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              //
                launchMountainDetailsActivity(view);


            }
        });


        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.
    }

    public void launchMountainDetailsActivity(View view) {
        Intent intent = new Intent(this, MountainDetailsActivity.class);
        startActivity(intent);
    }
}

