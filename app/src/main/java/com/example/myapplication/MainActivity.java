package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView buttoncounterTextView;
    private TextView backgroundcounterTextView;
    private int buttoncount;
    private int backgroundcount;
    static final String Button_count_key ="button_count_key";//key for savinginstances
    static final String Backgrount_count_key ="background_count_key";//key for savinginstances
    static final String Log_I_key="log_I_key";//created log for own understanding


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Log_I_key, "Inside onCreate");

        this.buttoncount=0;//intialized to zero
        this.backgroundcount=0;//intialized to zero

        this.buttoncounterTextView=(TextView) findViewById(R.id.buttoncounter);//feeding the value
        this.backgroundcounterTextView=(TextView) findViewById(R.id.backgroundcounter);



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Log_I_key,"Inside onResume()");
        this.backgroundcounterTextView.setText(Integer.toString(this.backgroundcount));
        this.buttoncounterTextView.setText(Integer.toString(this.buttoncount));

    }

    @Override
    protected void onStop() {
        Log.i(Log_I_key,"Inside onStop()");
        super.onStop();
        backgroundcount++;

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(Log_I_key,"Inside onSaveInstances()");
        outState.putInt(Button_count_key,this.buttoncount );
        outState.putInt(Backgrount_count_key,backgroundcount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(Log_I_key,"Inside onRestoreInstances()");
        this.buttoncount=savedInstanceState.getInt(Button_count_key);
        this.backgroundcount=savedInstanceState.getInt(Backgrount_count_key);
    }

    public void onbuttonclick(View view) {
        Log.i(Log_I_key,"Inside onbuttonclick pressed()");
        buttoncount++;
        this.buttoncounterTextView.setText(Integer.toString(this.buttoncount));
    }}