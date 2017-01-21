package com.example.us.mobilki;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfileActivity extends ActionBarActivity implements View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName,editTextSurname,editTextLogin;
    EditText editTextEmail;
    private int _Student_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);

//        editTextSurname.setVisibility(View.GONE);
//        editTextEmail.setVisibility(View.GONE);
//        editTextName.setVisibility(View.GONE);
//        editTextLogin.setVisibility(View.GONE);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


       _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
        UserRepo repo = new UserRepo(this);
        User student = new User();
        //student = repo.getUserById(_Student_Id);


//        editTextName.setText(student.password);
//        editTextEmail.setText(student.email);
//        editTextSurname.setText(student.surname);
//        editTextName.setText(student.name);
    }

    public void changeData(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(UserProfileActivity.this);

        alertDialog.setTitle("Zmiana danych użytkownika"); // Sets title for your alertbox

        alertDialog.setMessage("Na pewno chcesz zapisać zmieny?"); // Message to be displayed on alertbox

        alertDialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                finish();
                Toast.makeText(UserProfileActivity.this,"Dane zostały zmienione", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            changeData();
//            UserRepo repo = new UserRepo(this);
//            User student = new User();
//            student.email=editTextEmail.getText().toString();
//            student.password=editTextName.getText().toString();
//            student.user_id=_Student_Id;
//
//            if (_Student_Id!=0){
//                repo.updateUser(student);
//                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
//            }
        }else if(view== findViewById(R.id.btnDelete))
        {

            startActivity(new Intent(UserProfileActivity.this,ChangePassActivity.class));
//        else if (view== findViewById(R.id.btnDelete)){
//            UserRepo repo = new UserRepo(this);
//            repo.deleteUser(_Student_Id);
//            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
//            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();

        }



    }

}
