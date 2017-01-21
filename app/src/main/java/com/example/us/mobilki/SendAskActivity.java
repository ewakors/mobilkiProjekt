package com.example.us.mobilki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by us on 17.01.2017.
 */

public class SendAskActivity extends AppCompatActivity implements View.OnClickListener{

    private Button sendAsk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_ask);


        sendAsk = (Button)findViewById(R.id.buttonSendAsk);

        sendAsk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSendAsk:
                Toast.makeText(getApplicationContext(), "Twoja opinia została wysłana",Toast.LENGTH_SHORT).show();
                break;
            default:

        }

    }
}