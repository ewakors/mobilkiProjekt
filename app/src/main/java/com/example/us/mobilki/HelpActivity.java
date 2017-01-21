package com.example.us.mobilki;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void browser(View view)
    {
        Intent browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wi.pb.edu.pl"));
        startActivity(browserIntent);
    }
}
