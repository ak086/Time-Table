package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     ListView listView;
    public void generateTimetableNumber(int timeTableNumber){
        ArrayList<String> timeTableContent=new ArrayList<String>();

        for(int j=1;j<=10;j++){
            timeTableContent.add(Integer.toString(j*timeTableNumber));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timeTableContent);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.timeTableListViews);
       final SeekBar seekBar=findViewById(R.id.timeTableSeekBar);

        int max=20;
        int currentPosition=10;
        seekBar.setMax(max);
        seekBar.setProgress(currentPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                int timetableNumber;

                if(i<min){
                    timetableNumber=min;
                    seekBar.setProgress(min);
                }else{
                    timetableNumber=i;
                }
                Log.i("Seekbar value",Integer.toString(timetableNumber));
                generateTimetableNumber(timetableNumber);

            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}