package com.example.android.catordogperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private ImageView petImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        petImageView = (ImageView)findViewById(R.id.petImageView);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            int catResult = extras.getInt("catCounter");
            int dogResult = extras.getInt("dogCounter");
            if (catResult > dogResult){
                resultTextView.setText("Cat Person..");
                petImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            }else if (dogResult > catResult){
                resultTextView.setText("Dog Person..");
                petImageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
            }else{
                resultTextView.setText("Neither!");
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
