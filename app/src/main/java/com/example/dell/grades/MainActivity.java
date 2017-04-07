package com.example.dell.grades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int accountOfGrades=0;

    boolean correctName=false;
    boolean correctSurname=false;
    boolean correctAccountOfGrades=false;

    EditText nameEditText;
    EditText surnameEditText;
    EditText numberOfGradesEditText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        numberOfGradesEditText = (EditText) findViewById(R.id.numberOfGradesEditText);
        sendButton = (Button) findViewById(R.id.sendButton);

        sendButton.setVisibility(View.INVISIBLE);

        nameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (nameEditText.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(MainActivity.this, "Field name can not be empty", Toast.LENGTH_SHORT);
                    toast.show();
                    correctName = false;
                }
                else {
                    correctName = true;
                    showSendButton();
                }
            }
        });

        surnameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (surnameEditText.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(MainActivity.this, "Field surname can not be empty", Toast.LENGTH_SHORT);
                    toast.show();
                    correctSurname = false;
                }
                else {
                    correctSurname = true;
                    showSendButton();
                }
            }

        });

        numberOfGradesEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (numberOfGradesEditText.getText().toString().isEmpty() ||
                    Integer.parseInt(numberOfGradesEditText.getText().toString()) < 4 ||
                    Integer.parseInt(numberOfGradesEditText.getText().toString()) > 11)
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Field number of grades can not be empty and " +
                            "must have value between 4 and 11", Toast.LENGTH_SHORT);
                    toast.show();
                    correctAccountOfGrades = false;
                }
                else {
                    accountOfGrades = Integer.parseInt(numberOfGradesEditText.getText().toString());
                    correctAccountOfGrades = true;
                    showSendButton();
                }
            }
        });

        sendButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gradesActivityIntent = new Intent(MainActivity.this, GradesActivity.class);
                        gradesActivityIntent.putExtra("accountOfGrades", accountOfGrades);
                        startActivityForResult(gradesActivityIntent, 2);
                    }
                }
        );
    }

    private void showSendButton()
    {
        if(correctAccountOfGrades && correctSurname && correctName){
            sendButton.setVisibility(View.VISIBLE);
        }
        else sendButton.setVisibility(View.INVISIBLE);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
