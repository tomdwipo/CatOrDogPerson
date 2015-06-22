package com.example.android.catordogperson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxChicken;

    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private Button showResultButton;
    private int dogCounter;
    private int catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
        seekBar = (SeekBar)findViewById(R.id.seekbarFeline);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTextView.setText("Comfortableness: "+ progress +"/" +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setUp(){
        dogCounter = 0;
        catCounter = 0;
        canineRadioGroup = (RadioGroup)findViewById(R.id.canineGroup);
        droolRadioGroup = (RadioGroup)findViewById(R.id.radioGroupDrool);
        seekBarTextView = (TextView)findViewById(R.id.seekbarProgressTextView);

        cutestCheckBoxDog = (CheckBox)findViewById(R.id.checkboxCuteDog);
        cutestCheckBoxCat = (CheckBox)findViewById(R.id.checkboxCuteCat);
        cutestCheckBoxChicken = (CheckBox)findViewById(R.id.checkboxCuteChicken);

        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxChicken);
        processDrool(droolRadioGroup);
        processCannies(canineRadioGroup);

        showResultButton = (Button)findViewById(R.id.showResult);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),catCounter +" " +dogCounter,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this , ResultActivity.class);
                    intent.putExtra("dogCounter", dogCounter);
                    intent.putExtra("catCounter", catCounter);
                    startActivity(intent);
            }
        });

    }

    public void processCutest(CheckBox dog, CheckBox cat , CheckBox chicken){
        if (dog.isChecked() && !cat.isChecked() && !chicken.isChecked()){
            dogCounter = dogCounter+5;
        }else if (cat.isChecked() && !dog.isChecked() && !chicken.isChecked()){
            catCounter +=5;
        }else {

        }
    }
    public void processDrool (final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                droolRadioButton =(RadioButton)findViewById(radioID);
               if (droolRadioButton.getText().equals("Yes")){
                   dogCounter+=dogCounter;
               }
            }
        });
    }
    public void processCannies (final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                canineRadioButton = (RadioButton)findViewById(radioID);
                if (canineRadioButton.getText().equals("Yes")){
                    dogCounter +=5;
                }
            }
        });
    }


}
