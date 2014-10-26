package com.practice.jillian.sampleapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Timer class
 */
public class Timer extends Activity implements View.OnClickListener {

    Button addButton;
    Button subButton;
    Button mulButton;
    Button divButton;
    EditText input1;
    EditText input2;
    TextView answerView;

    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        addButton = (Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        subButton = (Button)findViewById(R.id.minusButton);
        subButton.setOnClickListener(this);

        mulButton = (Button)findViewById(R.id.multiplyButton);
        mulButton.setOnClickListener(this);

        divButton = (Button)findViewById(R.id.divideButton);
        divButton.setOnClickListener(this);

        nextButton = (Button) findViewById(R.id.nextPageButton);
        /*nextButton.setOnClickListener(this);*/
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Timer.this, PageTwo.class);
                startActivity(myIntent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        /*final Context context = this;*/

        int answer = 0;

        input1 = (EditText)findViewById(R.id.editText2);
        input2 = (EditText)findViewById(R.id.editText3);

        if(!input1.getText().equals("") || !input1.getText().equals("")) {
            switch (v.getId()) {
                case R.id.addButton:
                    answer = Integer.parseInt(input1.getText().toString()) + Integer.parseInt(input2.getText().toString());
                    break;
                case R.id.minusButton:
                    answer = Integer.parseInt(input1.getText().toString()) - Integer.parseInt(input2.getText().toString());
                    break;
                case R.id.multiplyButton:
                    answer = Integer.parseInt(input1.getText().toString()) * Integer.parseInt(input2.getText().toString());
                    break;
                case R.id.divideButton:
                    answer = Integer.parseInt(input1.getText().toString()) / Integer.parseInt(input2.getText().toString());
                    break;
            }
        }

        answerView = (TextView)findViewById(R.id.textView5);
        answerView.setText(Integer.toString(answer));
    }

    public void nextPage(View v){
        Intent intent = new Intent(this, PageTwo.class);
        startActivity(intent);
    }
}
