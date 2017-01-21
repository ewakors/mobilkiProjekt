package com.example.us.mobilki;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity implements android.view.View.OnClickListener{

    private Button ask,contakt,map, point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        ask = (Button)findViewById(R.id.buttonAsk);
        contakt = (Button)findViewById(R.id.buttonContact);
        map = (Button)findViewById(R.id.buttonMap);
        point = (Button)findViewById(R.id.buttonPostPoint);


        ask.setOnClickListener(this);
        contakt.setOnClickListener(this);
        map.setOnClickListener(this);
        point.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonAsk:
                startActivity(new Intent(AboutUsActivity.this,AskActivity.class));
                break;
            case R.id.buttonContact:
                startActivity(new Intent(AboutUsActivity.this,ContactActivity.class));
                break;
            case R.id.buttonMap:
                startActivity(new Intent(AboutUsActivity.this,MapActivity.class));
                break;
            case R.id.buttonPostPoint:
                startActivity(new Intent(AboutUsActivity.this,PostPointActivity.class));
                break;
            default:

        }

    }
}
