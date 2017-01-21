package com.example.us.mobilki;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends ActionBarActivity implements View.OnClickListener {

   Button btnSearch;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btnSearch = (Button) findViewById(R.id.btnSearch);

       // search= (EditText) findViewById(R.id.editTextSearch);

        btnSearch.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.buttonAsk:
                Toast.makeText(getApplicationContext(), "Wyszukiwanie....",Toast.LENGTH_SHORT).show();
                break;
            default:


        }
    }
}
