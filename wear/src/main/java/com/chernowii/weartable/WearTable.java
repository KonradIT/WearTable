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
            case 2:
                List = getResources().getStringArray(R.array.list2);
            case 3:
                List = getResources().getStringArray(R.array.list3);
            case 4:
                List = getResources().getStringArray(R.array.list4);
                //WIP continue here:
            case 5:
                List = List5;
            case 6:
                List = List6;
            case 7:
                List = List7;
            case 8:
                List = List8;
            case 9:
                List = List9;
            case 10:
                List = List10;
            case 11:
                List = List11;
            case 12:
                List = List12;
            case 13:
                List = List13;
            case 14:
                List = List14;
            case 15:
                List = List15;
            case 16:
                List = List16;
            case 17:
                List = List17;
            case 18:
                List = List18;

        }
    return List;
    }
}
