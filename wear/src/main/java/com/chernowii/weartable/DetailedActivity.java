package com.chernowii.weartable;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by Konrad Iturbe on 03/14/16.
 */
public class DetailedActivity extends Activity
        implements WearableListView.ClickListener {

    // Sample dataset for the list
    String[] elements = {};

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_list);
        Intent intent = getIntent();
        elements = intent.getStringArrayExtra("list");
        // Get the list component from the layout of the activity
        WearableListView listView =
        (WearableListView) findViewById(R.id.wearable_list);

        // Assign an adapter to the list
        listView.setAdapter(new DetailedAdapter(this, elements));

        // Set a click listener
        listView.setClickListener(this);
        }

// WearableListView click listener
@Override
public void onClick(WearableListView.ViewHolder v) {
        String selectedElement = elements[v.getPosition()];
        Toast.makeText(this, "Element: " + selectedElement, Toast.LENGTH_SHORT).show();
}

@Override
public void onTopEmptyRegionClick() {
        }
        }