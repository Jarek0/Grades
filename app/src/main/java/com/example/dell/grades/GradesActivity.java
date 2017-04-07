package com.example.dell.grades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Dell on 2017-04-07.
 */

public class GradesActivity extends AppCompatActivity {

    public ArrayList<Grade> grades = new ArrayList<Grade>();
    public int numberOfGrades;
    public final static String GRADE = "grade";
    Button returnButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        returnButton = (Button) findViewById(R.id.returnButton);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            numberOfGrades = bundle.getInt(MainActivity.NUMBER_OF_GRADES);
            for (int i = 0; i < numberOfGrades; i++) {
                grades.add(new Grade("grade " + (i + 1), 2));
            }

        } else {
            numberOfGrades = savedInstanceState.getInt(MainActivity.NUMBER_OF_GRADES);
            for (int i = 0; i < numberOfGrades; i++)
                grades.add(new Grade("grade " + (i + 1),
                        savedInstanceState.getInt(GRADE + i)));
        }

        GradesAdapter gradesAdapter = new GradesAdapter(this, grades);
        ListView listOfGrades = (ListView) findViewById(R.id.listOfGrades);
        listOfGrades.setAdapter(gradesAdapter);

        returnButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        saveGrades(bundle);
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        setResult(2, intent);
                        finish();
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveGrades(outState);
    }

    private void saveGrades(Bundle tobolek) {
        tobolek.putInt(MainActivity.NUMBER_OF_GRADES,
                numberOfGrades);
        for (int i = 0; i < numberOfGrades; i++)
            tobolek.putInt(GRADE + i, grades.get(i).getGrade());
    }
}
