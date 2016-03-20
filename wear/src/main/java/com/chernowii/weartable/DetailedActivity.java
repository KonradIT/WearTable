package com.chernowii.weartable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
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
public class DetailedActivity extends WearableActivity
        implements WearableListView.ClickListener {

    String[] elements = {};
    String[] atomicNumber = {};
    String[] Mass = {};
    int Number = 0;
    String APP_TAG = "Periodic Table Debug";

        @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_list);
        Intent intent = getIntent();
            elements = intent.getStringArrayExtra("list");
            atomicNumber = intent.getStringArrayExtra("atomic_number");
            Mass = intent.getStringArrayExtra("mass");
            Number = intent.getIntExtra("list_number",0);
            setAmbientEnabled();
            // Get the list component from the layout of the activity
        WearableListView listView =
        (WearableListView) findViewById(R.id.wearable_list);

        // Assign an adapter to the list
        listView.setAdapter(new DetailedAdapter(this, elements));

        // Set a click listener
        listView.setClickListener(this);
            final GestureDetector gesture = new GestureDetector(DetailedActivity.this,
                    new GestureDetector.SimpleOnGestureListener() {

                        @Override
                        public boolean onDown(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                               float velocityY) {
                            final int SWIPE_MIN_DISTANCE = 120;
                            final int SWIPE_MAX_OFF_PATH = 250;
                            final int SWIPE_THRESHOLD_VELOCITY = 200;
                            try {
                                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                                    return false;
                                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                   nextGroup();
                                }
                            } catch (Exception e) {
                                // nothing
                            }
                            return super.onFling(e1, e2, velocityX, velocityY);
                        }
                    });

            listView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return gesture.onTouchEvent(event);
                }
            });
        }

// WearableListView click listener
@Override
public void onClick(WearableListView.ViewHolder v) {
        String selectedElement = elements[v.getPosition()];
        String selectedAtomicNumber = atomicNumber[v.getPosition()];
        String MassForElement = Mass[v.getPosition()];
    new AlertDialog.Builder(DetailedActivity.this)
                .setTitle(selectedElement)
                .setMessage("Atomic Number: " + selectedAtomicNumber + "\n" + "Mass: " + MassForElement)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                })
                .show();
}

@Override
public void onTopEmptyRegionClick() {
        }
    public void nextGroup(){
    Number++;
    }
        }