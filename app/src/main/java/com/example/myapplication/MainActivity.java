package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView buttoncounterTextView;
    private TextView backgroundcounterTextView;
    private int buttoncount;
    private int backgroundcount;
    static final String Button_count_key = "button_count_key";//key for savinginstances
    static final String Backgrount_count_key = "background_count_key";//key for savinginstances
    static final String Log_I_key = "log_I_key";//created log for own understanding
    private SharedPreferences sharedPreferences;
    static final String sharedPreferencesPath = "com.example.android.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Log_I_key, "Inside onCreate");

        this.sharedPreferences = getSharedPreferences(sharedPreferencesPath, MODE_PRIVATE);

        this.buttoncount = this.sharedPreferences.getInt(Button_count_key, 0);

        this.backgroundcount = this.sharedPreferences.getInt(Backgrount_count_key, 0);

        this.buttoncounterTextView = (TextView) findViewById(R.id.buttoncounter);//feeding the value
        this.backgroundcounterTextView = (TextView) findViewById(R.id.backgroundcounter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor sharedPreferencesEditor = this.sharedPreferences.edit();
        sharedPreferencesEditor.putInt(Button_count_key, buttoncount);
        sharedPreferencesEditor.putInt(Backgrount_count_key, backgroundcount);
        sharedPreferencesEditor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Log_I_key, "Inside onResume()");
        this.backgroundcounterTextView.setText(Integer.toString(this.backgroundcount));
        this.buttoncounterTextView.setText(Integer.toString(this.buttoncount));

    }

    @Override
    protected void onStop() {
        Log.i(Log_I_key, "Inside onStop()");
        super.onStop();
        backgroundcount++;


    }


    public void onbuttonclick(View view) {
        Log.i(Log_I_key, "Inside onbuttonclick pressed()");
        buttoncount++;
        this.buttoncounterTextView.setText(Integer.toString(this.buttoncount));
    }
}