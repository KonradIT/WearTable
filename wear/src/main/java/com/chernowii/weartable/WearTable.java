package com.chernowii.weartable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class WearTable extends Activity {
    int progress = 0;
    String[] TestList = new String[]{"Ankit", "Bohra", "Xyz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_table);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                SeekBar seekBar = (SeekBar) findViewById(R.id.slider_bar);
                Button getGroupID = (Button) findViewById(R.id.getGrpID);

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                        progress = progresValue+1;
                        TextView status = (TextView) findViewById(R.id.groupId);
                        status.setText(""+ progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                getGroupID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] TheElementsList = assignListToID();
                        Intent startIntent = new Intent(getApplicationContext(), DetailedActivity.class);
                        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startIntent.putExtra("list", TheElementsList);
                        startActivity(startIntent);
                    }
                });
            }
        });

    }
    public String[] assignListToID(){
        String[] List = new String[0];
        switch(progress){
            
            case 1:
                List = getResources().getStringArray(R.array.list1);
                break;
            case 2:
                List = getResources().getStringArray(R.array.list2);
                break;
            case 3:
                List = getResources().getStringArray(R.array.list3);
                break;
            case 4:
                List = getResources().getStringArray(R.array.list4);
                break;
            case 5:
                List = getResources().getStringArray(R.array.list5);
                break;
            case 6:
                List = getResources().getStringArray(R.array.list6);
                break;
            case 7:
                List = getResources().getStringArray(R.array.list7);
                break;
            case 8:
                List = getResources().getStringArray(R.array.list8);
                break;
            case 9:
                List = getResources().getStringArray(R.array.list9);
                break;
            case 10:
                List = getResources().getStringArray(R.array.list10);
                break;
            case 11:
                List = getResources().getStringArray(R.array.list11);
                break;
            case 12:
                List = getResources().getStringArray(R.array.list12);
                break;
            case 13:
                List = getResources().getStringArray(R.array.list13);
                break;
            case 14:
                List = getResources().getStringArray(R.array.list14);
                break;
            case 15:
                List = getResources().getStringArray(R.array.list15);
                break;
            case 16:
                List = getResources().getStringArray(R.array.list16);
                break;
            case 17:
                List = getResources().getStringArray(R.array.list17);
                break;
            case 18:
                List = getResources().getStringArray(R.array.list18);
        }
    return List;
    }
}
