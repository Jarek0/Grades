package com.example.dell.grades;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell on 2017-04-07.
 */

public class GradesAdapter extends ArrayAdapter<Grade> {

    private List<Grade> grades;
    private Activity context;

    GradesAdapter(Activity context, List<Grade> grades) {
        super(context, R.layout.activity_grades, grades);
        this.context=context;
        this.grades = grades;
    }

    @NonNull
    @Override
    public View getView(int numberOfRow, View oldView, ViewGroup parent) {
        RadioGroup groupOfGrades;
        if (oldView == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            oldView = inflater.inflate(R.layout.row_of_grades, null);
            groupOfGrades = (RadioGroup) oldView.findViewById(R.id.groupOfGrades);
            groupOfGrades.setOnCheckedChangeListener(
                    new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(
                                RadioGroup groupOfGrades, int id)
                        {
                            actualizeGrades(groupOfGrades, id);
                        }
                    });
            groupOfGrades.setTag(grades.get(numberOfRow));
        }
        else {
            groupOfGrades = (RadioGroup) oldView.findViewById(R.id.groupOfGrades);
            groupOfGrades.setTag(grades.get(numberOfRow));
        }

        TextView textView = (TextView) oldView.findViewById(R.id.groupOfGradesTextView);

        textView.setText(grades.get(numberOfRow).getName());
        setGrade(groupOfGrades, numberOfRow);
        return oldView;
    }

    private void setGrade(RadioGroup groupOfGrades,int numberOfRow) {
        switch (grades.get(numberOfRow).getGrade()) {
            case 2:
                groupOfGrades.check(R.id.grade2);
                break;
            case 3:
                groupOfGrades.check(R.id.grade3);
                break;
            case 4:
                groupOfGrades.check(R.id.grade4);
                break;
            case 5:
                groupOfGrades.check(R.id.grade5);
                break;
        }
    }

    private void actualizeGrades(
            RadioGroup grupaOceny,int id) {
        Grade element =(Grade) grupaOceny.getTag();
        switch (id) {
            case R.id.grade2:
                element.setGrade(2);
                break;
            case R.id.grade3:
                element.setGrade(3);
                break;
            case R.id.grade4:
                element.setGrade(4);
                break;
            case R.id.grade5:
                element.setGrade(5);
                break;
        }
    }
}
