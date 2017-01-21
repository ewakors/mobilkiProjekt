package com.example.us.mobilki;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePassActivity extends ActionBarActivity implements android.view.View.OnClickListener{
    Button btnSave;
    Button btnClose;
    private TextView textOld,textNew,textConf;
    EditText editTextOldPass,editTextNewPass,editTextConfNewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        textOld = (TextView)findViewById(R.id.textOldPass);
        textNew = (TextView)findViewById(R.id.textNewPass);
        textConf = (TextView)findViewById(R.id.textConfNewPass);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextOldPass = (EditText) findViewById(R.id.editTextOldPass);
        editTextNewPass = (EditText) findViewById(R.id.editTextNewPass);
        editTextConfNewPass= (EditText) findViewById(R.id.editTextConfNewPass);


        btnSave.setOnClickListener(this);
        btnClose.setOnClickListener(this);


//        editTextName.setText(student.password);
//        editTextEmail.setText(student.email);
//        editTextSurname.setText(student.surname);
//        editTextName.setText(student.name);
    }
    public void changePass(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ChangePassActivity.this);

        alertDialog.setTitle("Zmiana hasła"); // Sets title for your alertbox

        alertDialog.setMessage("Na pewno chcesz zmienić hasło?"); // Message to be displayed on alertbox

        alertDialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                finish();
                Toast.makeText(ChangePassActivity.this,"Hasło zostało zmienione", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSave:
                changePass();
                break;
            case R.id.btnClose:
                finish();
                break;
            default:

        }
    }

}
