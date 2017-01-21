package com.example.us.mobilki;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by us on 17.01.2017.
 */

public class AskActivity extends AppCompatActivity implements android.view.View.OnClickListener{

    private Button sendAsk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);


        sendAsk = (Button)findViewById(R.id.buttonAddAsk);

        sendAsk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonAddAsk:
                startActivity(new Intent(AskActivity.this,SendAskActivity.class));
                break;
            default:

        }

    }
}