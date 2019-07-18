package com.example.farmjam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class f2 extends AppCompatActivity  implements View.OnClickListener {

        EditText mID, mName, mEmail, mAge;
        Button clickSave, clickSearch, clickSelect, clickDelete, clickUpdate;
        SQLiteDatabase sqLiteDatabase;
        String name, email, age, search;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dairy2);

            //DataBase
            //1.Create Database
            sqLiteDatabase = openOrCreateDatabase("MyDb", Context.MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS students(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(255),Email VARCHAR(255),Age VARCHAR(255))");

            //EditTexts
            mID = findViewById(R.id.search);
            mName = findViewById(R.id.inputName);
            mEmail = findViewById(R.id.inputEmail);
            mAge = findViewById(R.id.inputAge);

            //Buttons
            clickSave = findViewById(R.id.btnSave);
            clickSearch = findViewById(R.id.btnSearch);
            clickSelect = findViewById(R.id.btnSelectall);
            clickDelete = findViewById(R.id.btnDelete);
            clickUpdate = findViewById(R.id.btnUpdate);

            //OnClick Listeners
            clickSave.setOnClickListener(this);
            clickSearch.setOnClickListener(this);
            clickSelect.setOnClickListener(this);
            clickDelete.setOnClickListener(this);
            clickUpdate.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.btnSave) {
                name = mName.getText().toString().trim();
                email = mEmail.getText().toString().trim();
                age = mAge.getText().toString().trim();

                if (name.equals("") || email.equals("") || age.equals("")) {
                    Toast.makeText(this, "Kindly Fill In All Details", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sqLiteDatabase.execSQL("Insert into students(Name,Email,Age) VALUES('" + name + " ' ,' " + email + " ',' " + age + " ');");
                    Toast.makeText(this, "Record Saved", Toast.LENGTH_SHORT).show();
                }

            } else if (v.getId() == R.id.btnSelectall) {
                Cursor c = sqLiteDatabase.rawQuery("Select * from students", null);
                if (c.getCount() == 0) {
                    Toast.makeText(this, "No Records!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {
                    buffer.append("Student Name : " + c.getString(1) + "\n");
                    buffer.append("Student Email : " + c.getString(2) + "\n");
                    buffer.append("Student Age : " + c.getString(3) + "\n");
                }
                Toast.makeText(this, buffer.toString(), Toast.LENGTH_LONG).show();
            } else if (v.getId() == R.id.btnSearch) {
                search = mID.getText().toString().trim();
                if (search.equals("")) {
                    Toast.makeText(this, "Enter student name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor c = sqLiteDatabase.rawQuery("Select * from students where Name ='" + search + " '", null);
                if (c.moveToFirst()) {
                    mName.setText(c.getString(1));
                    mEmail.setText(c.getString(2));
                    mAge.setText(c.getString(3));
                } else {
                    Toast.makeText(this, "Student Not Found", Toast.LENGTH_SHORT).show();
                }
            } else if (v.getId() == R.id.btnUpdate) {
                search = mID.getText().toString().trim();
                name = mName.getText().toString().trim();
                email = mEmail.getText().toString().trim();
                age = mAge.getText().toString().trim();

                if (search.equals("")) {
                    Toast.makeText(this, "Enter student name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor cursorupdate = sqLiteDatabase.rawQuery("select * from students where Name = '" + search + "'", null);
                if (cursorupdate.moveToFirst()) {
                    if (name.equals("") || age.equals("")) {
                        Toast.makeText(this, "Fields cant be empty", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        sqLiteDatabase.execSQL("Update students set Name =' " + name + " ',Email='" + email + " ',Age = '" + age + "'");
                        Toast.makeText(this, "Student record updated", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show();
                }
            } else if (v.getId() == R.id.btnDelete) {
                search = mID.getText().toString().trim();
                if (search.equals("")) {
                    Toast.makeText(this, "Enter student name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor cdelete = sqLiteDatabase.rawQuery("Select * from students where Name ='" + search + " '", null);
                if (cdelete.moveToFirst()) {
                    sqLiteDatabase.execSQL("Delete from students where Name='" + search + " '");
                    Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Student Not Found", Toast.LENGTH_SHORT).show();

                }
            }

    }
}
